import itchat
import requests
import json

List = []
lastMessage = ''

def GetQR():
    # 生成二维码
    itchat.auto_login(picDir='QRCode.png')

def BotLogin():
    global List
    # 获取列表
    List =  itchat.get_friends(update = True)
    post_dict = GetFriendList()
    post_json = json.dumps(post_dict)

    # 调用登陆成功接口
    url = r'http://120.78.143.70:8080/AutoChat/chatting/login.do'
    params = {'json': str(post_json)}
    ans = requests.post(url = url, data = params)
    print(ans.content)
    # print(str(post_dict))
    itchat.run()

def CheckStatue():
    Statue = itchat.check_login()
    if Statue == '200':
        return True
    else:
        return False

def GetFriendList():
    FriendList = {'userId': List[0]['UserName'], 'friends': []}
    for i in List[1:]:
        FriendInfo = {}
        FriendInfo['friendname'] = i['NickName']
        FriendInfo['friendnote'] = i['RemarkName']
        FriendInfo['friendId'] = i['UserName']
        FriendInfo['sex'] = i['Sex']
        FriendList['friends'].append(FriendInfo)
    return FriendList

def GetMyInfo():
    MyInfo = {}
    MyInfo['UserName'] = List[0]['NickName']
    MyInfo['RemarkName'] = List[0]['RemarkName']
    MyInfo['UserID'] = List[0]['UserName']
    MyInfo['Sex'] = List[0]['Sex']
    return MyInfo

@itchat.msg_register('Text')
def text_reply(msg):
    global lastMessage
    print('收到消息：\n来自：', msg['User']['RemarkName'], '消息内容：', msg['Content'])

    if msg['FromUserName'] != List[0]['UserName']:
        lastMessage = msg['Content']
        # 发送消息请求
        url = r'http://120.78.143.70:8080/AutoChat/chatting/auto.do'
        params = {'userId': List[0]['UserName'], 'friendId': msg['User']['UserName'], 'question':  msg['Content']}
        ans = requests.post(url = url, params = params)

        # 解析服务器返回的内容
        msg = json.loads(ans.content)
        if msg['status'] == 0:
            return msg['data']
        elif msg['status'] == 1:
            appkey = "b7a7cf923ab5425db603f547d13c094a"
            url = 'http://www.tuling123.com/openapi/api?key=%s&info=%s' % (appkey, msg)
            req = requests.get(url)
            content = req.text
            data = json.loads(content)
            answer = data['text']
            return answer
        elif msg['status'] == 3:
            url = r'http://qnvqx7.natappfree.cc'
            params = {'haha': 2, 'user_id': 1, 'question': lastMessage, 'status': 0}
            req = requests.post(url = url, data = params)
            content = req.text
            data = json.loads(content)
            if data['status'] == 1:
                answer = data['answer']
                return answer
            else:
                appkey = "b7a7cf923ab5425db603f547d13c094a"
                url = 'http://www.tuling123.com/openapi/api?key=%s&info=%s' % (appkey, msg)
                req = requests.get(url)
                content = req.text
                data = json.loads(content)
                answer = data['text']
                return answer
    else:
        params_ = {'haha': 2, 'user_id': 1, 'question': lastMessage, 'status': 1, 'answer': msg['Content']}
        url_ = r'http://qnvqx7.natappfree.cc'
        requests.post(url = url_, data = params_)
