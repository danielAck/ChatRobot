# coding=UTF-8

import jieba.posseg as posg
import pandas as pd
import numpy as np
import os
import sys

reload(sys)
sys.setdefaultencoding('utf-8')


def savetalkcontent(user_id, reply_df, key_df, question, reply):

    seg = posg.cut(question)

    reply_id = reply_df.shape[0]
    key_id = key_df.shape[0]

    reply_row = [reply_id + 1, user_id, reply]

    # 查找是否同一个用户有相同的回复
    select = reply_df[reply_df.reply == reply]
    select = select[select.user_id == user_id]
    # 没有重复
    if select.empty:
        # 插入一行reply
        reply_df.loc[reply_id] = reply_row

    v = []
    n = []

    for segment in seg:
        if segment.flag == 'v':
            v.append(segment.word)
        if segment.flag == 'n':
            n.append(segment.word)

    list = []

    for verb in v:
        for none in n:
            content = verb + none
            list.append(content)
            key_df.loc[key_id] = [key_id + 1, user_id, reply_id, content]
            key_id += 1


def pridic(user_id, reply_df, key_df, question):

    reply_df = reply_df[reply_df.user_id == user_id]
    key_df = key_df[key_df.user_id == user_id]

    if reply_df.empty or key_df.empty:
        return None


    seg = posg.cut(question)

    v = []
    n = []

    for segment in seg:
        if segment.flag == 'v':
            v.append(segment.word)
        if segment.flag == 'n':
            n.append(segment.word)

    list = []

    for verb in v:
        for none in n:
            content = verb + none
            list.append(content)


    # 进入话题，利用贝叶斯计算
    if len(list) != 0:
        # 默认使用第一个主题
        topics = str(list[0])
        print topics

        # 获取reply的id列表
        replys = reply_df['id'].tolist()

        pbia = {}
        pb = {}
        pabi = {}

        # 计算每一个reply的概率
        for reply in replys:
            totalnum = key_df.shape[0]
            select_key_df = key_df[key_df.reply_id == reply]
            num_bi = select_key_df.shape[0]

            pb[reply] = float(num_bi) / float(totalnum)


            # TODO select_key_a 有可能为0， 之后处理
            select_key_a = select_key_df[key_df.keyword == topics]

            num_pabi = select_key_a.shape[0]
            pabi[reply] = float(num_pabi) / float(num_bi)


        denominator = 0.00000001
        for i in replys:
            denominator += pb[i] * pabi[i]


        for i in replys:
            numerator = pb[i] * pabi[i]
            pbia[i] = numerator / denominator


        max_id = sorted(pbia.items(), key=lambda x: x[1], reverse=True)[0][0]

        final_reply = reply_df[reply_df.id == max_id]
        return np.array(final_reply).tolist()[0][2]




# os.chdir("D:\\DoraHacks\\")
#
# question = "今天去看电影吧"
# reply = "好啊！"
#
# reply_df = pd.read_csv("reply.csv")
# key_df = pd.read_csv("key.csv")
#
# user_id = 1
#
# savetalkcontent(user_id, reply_df, key_df, question, reply)
#
# user_id = 2
# savetalkcontent(user_id, reply_df, key_df, question, reply)
#
# res = pridic(1, reply_df, key_df, "我们看电影")
# if res == None:
#     print "None!!!"
# else:
#     print res







