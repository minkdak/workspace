/* 요청정보 다루기 - Quiz 2
 => 사용자로부터 페이지 번호와 개수를 입력받아
    학생 목록을 HTML 페이지로 출력하시오.
 => 요청 예) http://localhost:8888/student/list.do?pageNo=2%pageSize=3
 => 출력 예)
   간단히 테이블로 출력하라!
*/

//7)datasource,studentdao,pagckage.json복사 붙여넣기 및 객체 정의.
const http = require('http')
const url = require('url') //url을 전문적으로 처리하는 객체.
const datasource = require('./datasource')
const studentDao = require('./student-dao')
const studentService = require('./student-service')
// 이데이터를 재사용한다.
const connection = datasource.getConnection()
studentDao.setConnection(connection)
studentService.setStudentDao(studentDao)

const server = http.createServer(function(request, response) {//클라이언트 요청이 들어오면 함수가 호출된다.요청,응답 파라미터
  if (request.url == '/favicon.ico') {
    response.end();
    return;
  } // 그냥무시.
  var urlInfo = url.parse(request.url, true) //url객체에서 parse는 url을 내입맘ㅅ에 맞게. true는 ?기준으로 잘라준다.
  //request에 있는 url을 잘라서 urlInfo 객체에 담음.
  //pathname : 포트번호 제외하고 ? 전까지의 url
  if (urlInfo.pathname != '/student/list.do') {//4) 오류시 띄울 창.
    response.writeHead(404, { //404 notfound에러
      //응답할 때 클라이언트 헤드에게 ?를 보낼건데. 첫번째 파라미터 값에 따라.
      'Content-Type' : 'text/plain;charset=UTF-8'
    })
    response.end('잘못된 URL입니다.') //응답을 끝낼때 출력할 수 있다.
    return
  }
var pageNo = parseInt(urlInfo.query.pageNo),
    pageSize = parseInt(urlInfo.query.pageSize) // 9) studentdao의 list에 파라미터값을 pageSize를 설정해준다.
  response.writeHead(200, { // 200을받으면 이렇게 출력할거야
    'Content-Type' : 'text/html;charset=UTF-8'
  })


//3)http 클라이언트에 이 데이터를 보낸다.
  response.write('<html> \
    <title>학생목록</title> \
  <head> \
  </head> \
  <body> ') //html출력.

  response.write('<h1>학생목록</h1>') //6)페이지 뜨는지확인하고.
  response.write('pageNo=' + urlInfo.query.pageNo + '<br>')// 5)페이지넘버 출력 페이지넘버값받아올수 있는지 확인
  response.write('pageSize=' + urlInfo.query.pageSize + '<br>') // 학생목록을 받아와 페이지넘버를 출력한다.
  //제대로 값을 받았는지 확인하고자 이렇게....입력.
  studentService.list(pageNo, pageSize, function(results) {// 8) 데이터 요청 화면 출력
    response.write('<table border= "1"> \
    <thead> \
      <tr><th>번호</th><th>이름</th><th>이메일</th><th>전화</th><th>직장인</th></tr> \
    </thead> \
    <tbody>')
    for (var r of results) { // 성공시 호출될 함수
      response.write('<tr><td>' + r.mno + '</td>')
      response.write('<td>' + r.name + '</td>')
      response.write('<td>' + r.email + '</td>')
      response.write('<td>' + r.tel + '</td>')
      response.write('<td>' + r.work + '</td></tr>')
    }
    response.write('</tbody></table> \
    </body></html>') // 작업을 한다음에 end를 해야한다. 그렇기 때문에 안에 넣는다.
    response.end();
  }, function(error) {
    response.write('DB 오류!')
    response.write('</body></html>')
    response.end();
    throw error;
  }) //데이터 베이스는 비동기이기 때문에 데이터베이스를 받은다음 또 작업을 수행해야한다.
// 이함수가 호출되면 connectionquery라는 비동기함수가 실행됨.
// 여기다가 response.end하면 그냥 데이터 가져오는 중에 끝나버림. 다음라인으로 가버림.
// 지금은 함수호출이 끝난게아니다.
// 데이터베이스에서 답변이 왔을때 끝낸다.
})

server.listen(8888)

console.log("서버 실행 중...")

// for (var r of results) { // 성공시 호출될 함수
//   response.write(r.mno + ',' + r.email + ',' + r.tel + ',' + r.work + '<br>')
// }
// response.write('</tbody></table> \
// </body></html>') // 작업을 한다음에 end를 해야한다. 그렇기 때문에 안에 넣는다.
// response.end();
