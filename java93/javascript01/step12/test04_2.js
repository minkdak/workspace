/* 요청정보 다루기 - Quiz 2
 => 사용자로부터 기본 회원 데이터를 입력 받아 DBMS에 저장하라!
    학생 목록을 HTML 페이지로 출력하시오.
 => 요청 예) http://localhost:8888/student/add.do?name=홍길동&tel=1111&email=hong@test.com&password=1111&working=Y&shoolName=비트대학교
 => 출력 예)
   입력 성공입니다!

* 입력되었는지 여부는 test04_1.js를 통해 확인하라!

*/


//7)datasource,studentdao,pagckage.json복사 붙여넣기 및 객체 정의.
const http = require('http')
const url = require('url') //url을 전문적으로 처리하는 객체.
const datasource = require('./datasource')
const studentDao = require('./student-dao')
const memberDao = require('./member-dao')
const studentService = require('./student-service')
// 이데이터를 재사용한다.
const connection = datasource.getConnection()
studentDao.setConnection(connection)
memberDao.setConnection(connection)
studentService.setStudentDao(studentDao)
studentService.setMemberDao(memberDao)

const server = http.createServer(function(request, response) {
  if (request.url == '/favicon.ico') {
    response.end();
    return;
  } // 그냥무시.
  var urlInfo = url.parse(request.url, true)


  if (urlInfo.pathname != '/student/add.do') {
    response.writeHead(404, {

      'Content-Type' : 'text/plain;charset=UTF-8'
    })
    response.end('잘못된 URL입니다.')
    return
  }

  var student = {
    name: urlInfo.query.name,
    tel: urlInfo.query.tel,
    email: urlInfo.query.email,
    password: urlInfo.query.password,
    working: urlInfo.query.working,
    schoolName: urlInfo.query.schoolName
  }
var pageNo = parseInt(urlInfo.query.pageNo),
    pageSize = parseInt(urlInfo.query.pageSize)
  response.writeHead(200, {
    'Content-Type' : 'text/html;charset=UTF-8'
  })


  response.write('<html> \
    <title>학생등록</title> \
  <head> \
  </head> \
  <body> ')
  response.write('<h1>학생 등록 결과</h1>')


  studentService.insert(student function(results) {
    response.write('입력 성공입니다!')
    response.write('</body></html>')
    response.end();
  }, function(error) {
    response.write('DB 오류!')
    response.write('</body></html>')
    response.end();
    throw error;
  })
})

server.listen(8889)

console.log("서버 실행 중...")
