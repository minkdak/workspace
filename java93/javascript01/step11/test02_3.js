
/* 데이터 조회 명령 : upadate
upadate 테이블명 set 칼럼명=값, 칼럼명=값, ...
where 조건
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

connection.query('update memb set tel="2222-2222" where name="오호라"', function(error, results) {
  console.log('결과를 가져왔음!')
  if (error) throw error;
  console.log(results)
})

connection.end()
console.log('MySQL 서버와 연결 끊기가 예약되었음!')
