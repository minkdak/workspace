/* in-parameter 활용
=> insert나 update 할 때 여러 개의 값을 지정하기 위해 '+'를 사용하여
  문자열을 연결해야 한다.
  이런 불편함을 없애기 위해 in-parameter문법을 사용한다.
*/
const mysql = require('mysql')
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
}) //
console.log('MySQL 서버에 연결할 도구 생성완료')

connection.connect()
console.log('MySQL 서버와 연결됨!')



// query(SQL 명령, 결과가 도착했을 때 호출될 함수)
connection.query('insert into memb(name, email, tel, pwd)+ values(?,?,?,password(?))',
              //여기에 들어가는 값을 배열로 저장한다.
              ["오호라2","ohora2@test.com", "111-1111", "1111"],
              // ' ("오호라","ohora@test.com", "111-1111", password("1111"))',
              function(error, results){

  console.log('결과를 가져왔음!')
  if (error) throw error;
  console.log(results)
})

connection.end()
console.log('MySQL 서버와 연결 끊기가 예약되었음!')
