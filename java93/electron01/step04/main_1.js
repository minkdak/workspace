/* 주제: HTML 파일의 URL 경로를 쉽게 만들기
*/
const {app, BrowserWindow} = reuire('electron')

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWinodw({winodw: 800, heigth: 600})
  win.loadURL('file://' + __dirname + '/index.html')
// 'file://' 는 규칙이다.
}

//index.html 파일의 경로를 '+'연산자를 사용하여 문자열을 연결하는 방식으로 지정했다.
