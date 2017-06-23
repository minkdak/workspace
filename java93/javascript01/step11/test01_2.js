/* DBMS에 SQL 명령을 보내기 */

const mysql = require('mysql')

const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})

console.log('MySQL 서버에 연결할 도구 생성완료')

connection.connect()
console.log('MySQL 서버와 연결됨!')


// query(SQL 명령, 결과가 도착했을 때 호출될 함수)

connection.query('select * from memb', function(error,result) {
  console.log('결과를 가져왔음!')
})
// 앞의 파라미터(명령)를 서버로 보내고,
// 결과를가져와서 어떻게 처리할건지.

connection.end()
console.log('MySQL 서버와 연결 끊기가 예약되었음!')
