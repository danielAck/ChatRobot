from flask import request, Flask, Response
import json
import os
import messagebot
import time
import _thread

app = Flask(__name__)
app.secret_key = 'secret'

def GetCode():
    messagebot.GetQR()
    messagebot.BotLogin()
    

@app.route('/getQR', methods=['GET'])
def create_task():
    _thread.start_new_thread(GetCode, ())
    while not os.path.exists('QRCode.png'):
        continue
    path = 'QRCode.png'
    QR = open(path, 'rb')
    rep = Response(QR, mimetype="image/png")
    #os.remove('QRCode.png')
    return rep

app.run()