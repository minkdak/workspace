/* 미니 Express 만들기 - 웹서버 만드는 코드를 캡슐화 한다.
*/

var http = require('http') // 서버를 실행시킬거야.

var server = http.createServer(function(request, response) {
  response.end()
}) // server 객체 // 어떤 요청이 오더라도 즉시 응답하게끔.

module.exports = function() { //exports 함수객체를 호출하면 객체를 리턴한다.
  return {
    listen(port, cb){
      server.listen(port, cb)// 넘어온 port 번호로 서버를 시작시킨다.
                             // 서버가 가동되면 'listening' 이벤트가 발생하고
                             // 지정된 함수 'cb'가 호출 된다.
                             // 물론 cb가 없다면, 호출되지 않는다.
                             // 즉 서버가 시작된 후 알림을 받고 싶다면,
                             // 두 번째 파라미터에 함수를 전달하라!
                             // 호출할 함수가 없다면 cb를 비우고 이 때, listener 이벤트는
                             // 발생하지않는다.
    }
  }
}
