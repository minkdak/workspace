// 데이터 처리를 담당하는 자바스크립트
// => DAO(Data Access Object)
"use strict"
const mysql = require('mysql')
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
connection.connect()
