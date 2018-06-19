const { app, ipcMain } = require('electron')
const api = require('./nbj-api')
const store = require('./store')

api.setBaseUrl('https://api.niubangold.com')
api.setHeaders({ 'MOBILE_DEVICE': 'android', 'CLIENT_VERSION': '3.4.5', 'User-Agent': 'okhttp/3.3.3' })

const MSG_USER_INFO_QUERY = 'user-info-query'
const MSG_USER_INFO_RESULT = 'user-info-result'

app.on('ready', () => {
    ipcMain.on(MSG_USER_INFO_QUERY, (event, arg) => {
        queryUserInfo(event.sender, arg)
    })
})

function createMessageResult (msg) {
    return {
        status: -1,
        result: {},
        msg: msg
    }
}

function sendResult (sender, result) {
    sender.send(MSG_USER_INFO_RESULT, result)
}

function queryUserInfo (sender, str) {
    let param = {
        'userId': store.get('userId'),
        'token': store.get('token')
    }
    if (!str || str.length < 5) {
        sendResult(sender, createMessageResult('请检查输入的查询字符'))
        return
    }
    if (str.startsWith('ZZ') || str.startsWith('201')) {
        param.platcust = str
    } else {
        param.pid = str
    }
    api.post('/api/member/app/bank/account/info', param, function (data) {
            sendResult(sender, JSON.parse(data))
        }, function (error) {
            sendResult(sender, createMessageResult('查询失败'))
        }
    )
}