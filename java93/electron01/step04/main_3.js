/* 주제: HTML 파일의 URL 경로를 쉽게 만들기
*/
const {app, BrowserWindow} = require('electron')
const path = require('path')

const url = require('url')

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow(width: 800, height: 600)
// HTML 경로를 제대로된 URL로 바꾸기 위해 'url'모듈을 사용한다.
  var htmlURL = url.format({  // 상자(객체). 안에 들어있는 도구(함수)
    protocol: 'file:'
    pathname: path.join(__dirname, 'index.html'),
    slashes: true
  })
  console.log(htmlURL)
  win.loadURL(htmlURL)// 보기 힘들다.-> main

}
