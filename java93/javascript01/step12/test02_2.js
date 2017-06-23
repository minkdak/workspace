/* 클라이언트로 출력하기 - 응답 데이터의 콘텐츠 타입을 지정하기
=> 서버가 클라이언트에게 보내는 데이터가 어떤 형식인지
  http 응답 헤더를 통해 알려준다.
=> 응답 헤더 예
  Content-Type : text/palin;charset=UTF-8
*/


const http = require('http')
const server = http.createServer(function(request, response) {
  console.log('클라이언트 요청이 들어왔네!')

  // 서버에서 보내는 데이터가 무엇인지 응답 헤더에 지정한다.
  response.writeHead(200, {//응답헤더 지정
    'Content-Type' : 'text/plain;charset=UTF-8'
  }) // text/plain: MIME 타입이란 클라이언트에게 전송된 문서의 다양성을 알려주기 위한 메커니즘입니다
    // charset=UTF-8
  response.write('Hello, world')
  response.write('안녕하세요!')
  response.end();
})

server.listen(8888)

console.log("서버 실행 중...")
/*
서버에서 결과를 보내면 클라이언트 출력한다.
그러나, 서버에서 보낸 데이터가 어떻게 인코딩된 데이터인지 알지 못하기 때문에
한글을 출력할 때 깨진다.
*/
