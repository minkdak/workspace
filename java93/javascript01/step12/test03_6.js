/* 요청정보 다루기 - Quiz!
 => 계산기 서비스를 구현하라!
요청 예) http://localhost:8888/calculator?a=100&b=200&op=-
출력결과 예)
100 - 200 = -100
=> op에 들어갈 연산자: +, -, *, /, %
*/


const http = require('http')
const url = require('url')

const server = http.createServer(function(request, response) {
  if (request.url == '/favicon.ico') {
    response.end();
    return;
  } // 그냥무시.

  response.writeHead(200, {
    'Content-Type' : 'text/plain;charset=UTF-8'
  })
  var urlInfo = url.parse(request.url, true)

  if (urlInfo.pathname != '/calculator') {
    response.end('잘못된 URL 입니다.')
    return
  }

// URL 분석기 실행
  var a = parseInt(urlInfo.query.a)
  var b = parseInt(urlInfo.query.b)
  var op = urlInfo.query.op
  var i = 0;
/* URL은 항상 ASCII 코드 값으로 표현해야 한다.
  다른 데이터는 URL 인코딩, 즉 아스키 문자화 시켜서 표현한다.
  그래서 '+'문자는 '%2B'라는 문자로 URL 인코딩하여 전달해야 한다.
  또한 '%'도 URL 인코딩하는데 특별한 기호로 사용되기 때문에,
  '+' 문자와 마찬가지로 URL 인코딩한 '%25'문자로 바꿔 전달해야 한다.
*/
console.log(a, b, op)
switch (op) {
  case '+': i = a + b ; break;
  case '-': i = a - b ; break;
  case '*': i = a * b ; break;
  case '/': i = a / b ; break;
  case '%': i = a % b ; break;
}
console.log(i)
  response.write(a + op + b + '=' + i)

  response.end();
})

server.listen(8080)

console.log("서버 실행 중...")
