const { app, BrowserWindow, ipcMain, Menu } = require('electron')

// Keep a global reference of the window object, if you don't, the window will
// be closed automatically when the JavaScript object is garbage collected.
let window

function createWindow() {
    window = new BrowserWindow({ width: 800, height: 600, show: false })
    // Menu.setApplicationMenu(null)
    window.loadFile('index.html')
    window.once('ready-to-show', onWindowReadyToShow)
    window.on('closed', onWindowClosed)
}

function onWindowReadyToShow() {
    window.show()
}

function onWindowClosed() {
    window = null
}

function onAppReady() {
    createWindow()
}

// Electron 会在初始化后并准备
// 创建浏览器窗口时，调用这个函数。
// 部分 API 在 ready 事件触发后才能使用。
app.on('ready', onAppReady)


// 当全部窗口关闭时退出。
app.on('window-all-closed', () => {
    // 在 macOS 上，除非用户用 Cmd + Q 确定地退出，
    // 否则绝大部分应用及其菜单栏会保持激活。
    if (process.platform !== 'darwin') {
        app.quit()
    }
})

app.on('activate', () => {
    // 在macOS上，当单击dock图标并且没有其他窗口打开时，
    // 通常在应用程序中重新创建一个窗口。
    if (win === null) {
        createWindow()
    }
})

require('./query-user-info')