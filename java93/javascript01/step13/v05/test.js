/* GET, POST 요청 처리 테스트
=> 테스트 방법
  test.html을 웹 브라우저로 로딩하여 확인하라!
*/
var miniExpress = require('./mini-express')  // 만들어둔 express형 파일에 연결(모듈)

var app = miniExpress() // 객체를 저장


app.get('/get_test.do', function(request, response){ // get요청이 들어올 때 실행할 함수
  response.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'})
  response.write('GET 요청처리!')
  response.write('name=' + request.query.name)
  response.write('age=' + request.query.age)
  response.write('tel=' + request.query.tel)
  response.end()
})

app.post('/post_test.do', function(request, response){ // POST요청이 들어올 때 실행할 함수.
  response.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'})
  response.write('POST 요청처리!')
  response.write('name=' + request.query.name)
  response.write('age=' + request.query.age)
  response.write('tel=' + request.query.tel)
  response.end()
})

app.listen(8888, function() { // 서버 실행..
  console.log('서버가 시작되었습니다.')
})
