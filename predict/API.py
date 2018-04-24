# coding=UTF-8

import BaseHTTPServer
import urllib
import os
import pandas as pd
import ContentPridict
import json

class MyRequestHandler(BaseHTTPServer.BaseHTTPRequestHandler):


    def do_POST(self):
        mpath, margs = urllib.splitquery(self.path)
        datas = self.rfile.read(int(self.headers['content-length']))
        self.do_action(mpath, datas)

    def do_action(self, path, args):
        self.outputtxt(path + args)


    def generate_answer(self):
        return '''{'id': 1234, 'name': 'daniel'}'''


    def outputtxt(self, content):

        dic = {}
        res = '''{'answer': '', 'status': 3}'''

        handle_context = "".join(urllib.unquote(content))
        handle_context_split = handle_context.split("&")
        for param in handle_context_split:
            splited = param.split('=')
            dic[splited[0]] = splited[1].decode('utf-8')

        reply_df = pd.read_csv("reply.csv")
        key_df = pd.read_csv("key.csv")

        user_id = int(dic['user_id'])
        print user_id
        status = int(dic['status'])
        print status

        # 请求答案
        if status == 0:
            question = dic['question']
            answer = ContentPridict.pridic(user_id, reply_df, key_df, question)
            if answer == None:
                res = json.dumps({'answer': "", 'status': 0})
                ContentPridict.savetalkcontent(user_id, reply_df, key_df, question, answer)
            else:
                res = json.dumps({'answer': answer, 'status': 1})
        # 保存内容
        else:
            question = dic['question']
            answer = dic['answer']
            ContentPridict.savetalkcontent(user_id, reply_df, key_df, question, answer)
            res = json.dumps({'status':2})
            print reply_df
            print key_df


        # 指定返回编码
        enc = "UTF-8"
        # content = content.encode(enc)
        self.send_response(200)
        self.send_header("Content-type", "text/html; charset=%s" % enc)
        self.send_header("Content-Length", str(len(res)))
        self.end_headers()
        self.wfile.write(res)



#----------------------------------------------------------------------

if __name__ == '__main__':
    os.chdir("D:\\DoraHacks\\")
    serverAddress = ('', 8081)
    server = BaseHTTPServer.HTTPServer(serverAddress, MyRequestHandler)
    server.serve_forever()

