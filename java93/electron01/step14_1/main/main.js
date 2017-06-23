/* 주제: MySQL DBMS에 직접 접속하기 VIII
=> DAO, Service를 nodeJS 모듈화시키기
 */
const {app, BrowserWindow} = require('electron')
const path = require('path')
const url = require('url')

const datasource = require('./util/datasource') // 데이터 소스 모듈을 불러온다
const connection = datasource.getConnection()

const studentDao = require('./dao/student-dao')
studentDao. setConnection(connection)
const memberDao = require('./dao/member-dao')
memberDao. setConnection(connection)

const studentService = require('./service/student-service')

console.log(connection)


/*
let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 800, height: 600})
  win.loadURL(url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, '../renderer/index.html'),
    slashes: true
  }))

}
*/



//
