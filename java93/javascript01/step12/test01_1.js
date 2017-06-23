/* HTTP 서버 만들기 - 서버 띄우기

*/

// 1) http 모듈 로딩
const http = require('http')

// 2) HTTPServer 객체 생성
// => 파라미터는 클라이언트 요청이 들어왔을 때 호출될 함수 이다.
// => 즉 클라이언트에서 요청이 들어오면 파라미터로 넘긴 함수를 호출한다.

const server = http.createServer(function(request, response) { // 익명함수
  // 브라우저에서 이서버로 리퀘스트 했을 때, 요청에 대한 상세정보를 파라미터로 받을 수 있다.\
  console.log('클라이언트 요청이 들어왔네!')
}) //http 모듈에 createServer라는객체가있다

// 3) 서버 실행

server.listen(8080) // 8080에서 들어라

console.log("서버 실행 중...")

// function ok() {
//
// } 이렇게 하면 유지보수가 어렵다.
