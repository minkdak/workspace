/* 요청정보 다루기 - Quiz 2
 => 사용자로부터 기본 회원 데이터를 입력 받아 DBMS에 저장하라!
    학생 목록을 HTML 페이지로 출력하시오.
 => 요청 예) http://localhost:8888/student/add.do?name=홍길동&tel=1111&email=hong@test.com&password=1111
 => 출력 예)
   입력 성공입니다!

* 입력되었는지 여부는 test04_1.js를 통해 확인하라!
*/
var $ = require('jquery')

const Dao = require('/dao')
Dao.setConnection(connection)

const mysql = require('mysql')
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})

// const connect()

const http = require('http')
const url = require('url')

const server = http.createServer(function(request, response) {
  console.log('클라이언트 요청이 들어왔네!')
  response.writeHead(200, {
    'Content-Type' : 'text/html;charset=UTF-8'
  })

  response.write('<html>\
    <html>\
    <head>\
    <meta charset="UTF-8">\
    <title>HTML</title>\
    <link rel="stylesheet"\
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"\
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"\
          crossorigin="anonymous">\
    <style>\
    .container {\
      width: 600px;\
      margin: 0px auto;\
    }\
    </style>\
    </head>\
    <body>\
    <div class="container">\
    <table id="student-tbl" class="table table-hover">\
    <thead>\
      <tr>\
        <th>번호</th>\
        <th>이름</th>\
        <th>전화</th>\
        <th>이메일</th>\
        <th>재직여부</th>\
      </tr>\
    </thead>\
    </div>\
    <tbody>\
    </tbody>\
    <span id="page-no">1</span>\
    </table>\
    </div>\
    </body>\
    </html>'
  )

  response.end();
})
list(1)
function list(pageNo) {
connection.query(
  'select m.mno, m.name, m.tel, m.email, s.work \
   from stud s inner join memb m on s.sno=m.mno',
  function(error, results) {
    if(error) {
      console.log('error!')
      throw error;
    }//if
    console.log(results)
    for (var i = 0; i < 3; i++) {
      if(i < results.length) {
        let s = results[i]
        response.write("<tr>").html("<td>" + s.mno +
        "</td><td><a href='#' data-no='" + s.mno + "' class='view-link'>" + s.name +
        "</a></td><td>" + s.tel +
        "</td><td>" + s.email +
        "</td><td>" + (s.work == "Y" ? "재직중" : "실업") + "</td>")
        .appendTo(tbody)
      }}
  })//connection>query)
} //list(pageNo)
server.listen(8080)

console.log("서버 실행 중...")
