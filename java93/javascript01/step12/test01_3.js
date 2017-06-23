/* HTTP 서버 만들기 - 싱글스레드 방식*/

// 1) http 모듈 로딩
const http = require('http')

// 2) HTTPServer 객체 생성
// => 파라미터는 클라이언트 요청이 들어왔을 때 호출될 함수 이다.
// => 즉 클라이언트에서 요청이 들어오면 파라미터로 넘긴 함수를 호출한다.

const server = http.createServer(function(request, response) {
  console.log('클라이언트 요청이 들어왔네!')

// 요청이 들어오면 5초 후에 응답을 완료한다
  setTimeout(function() {
    response.end();
  }, 5000)
})

// 3) 서버 실행

server.listen(8080) // 8080에서 들어라

console.log("서버 실행 중...")

// function ok() {
//
// } 이렇게 하면 유지보수가 어렵다.
