// MEMB 테이블 데이터 처리
"use strict"
const mysql = require('mysql')
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
connection.connect()



function insertMember(member, successFn, errorFn) {
  connection.query(
    'insert into memb(name,tel,email,pwd) values(?,?,?,password(?))',
    [ member.name, member.tel, member.email, member.password],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  }) //connection.query()
} //insertStudent()


function updateMember(member, successFn, errorFn) {
  connection.query(
    'update memb set name=?, tel=?, email=? where mno=?',
    [member.name, member.tel, member.email, member.no],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  })
} // updateMember()

function deleteMember(no, successFn, errorFn) {
  connection.query(
    'delete from memb where mno=?',
    [no],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  }) //connection.query()
}//deleteMember()
