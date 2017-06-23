/* 미니 Express 만들기 - GET, POST 요청을 다루는
*/

var http = require('http') // 서버를 실행시킬거야.
var url = require('url')
var path = require('path')
var fs = require('fs')


var getHandler = {} // 요청을 다룬 함수를 연결. 바깥에 놓은 이유는 create에서 사용하기위해.
var postHandler = {}//requestHandlerMappingFor


function notFound(request, response) {
  response.writeHead(200, {
    'Content-Type' : 'text/html;charset=UTF-8'
  })
  fs.readFile(path.join(__dirname, './html/http-404.html'), function(err, data) { // 파일 읽었으면 딱한번 함수 호출 읽은 파일이 data에 들어간다.
    if (err) throw err;
    response.end(data)
  })
  // console.log(path.join(__dirname, './html/http-404.html'))
  // response.end('해당 자원을 찾을 수 없습니다.')
}// 헤더정보를 보내고. 읽은 파일을 가지고 end를 시켜버림.


var server = http.createServer(function(request, response) {
  var urlInfo = url.parse(request.url, true) // url 분석, 정리한 값 객체로 저장
  var handler = null;
  if (request.method == 'GET'){
    handler = getHandler[urlInfo.pathname] //
    request.query = urlInfo.query // 인포 객체(폴더)안에 쿼리 객체안에 저장된 변수 = 값
  } else if (request.method == 'POST'){
    handler = postHandler[urlInfo.pathename] // 없으면 undefined 저장.
  }

  if(handler) {
    handler(request, response)
  } else {
    notFound(request, response)
  }
}) // server 객체 // 어떤 요청이 오더라도 즉시 응답하게끔.

module.exports = function() { //exports 함수객체를 호출하면 객체를 리턴한다.
  return {
    // 주어진 url로 GET 요청이 들어왔을 때 호출될 함수를 등록한다.
    get(url, handler) {
      getHandler[url] = handler // get 요청. url 이름으로 함수를 담는다.
    },

    post(url, handler) {
      postHandler[url] = handler
    },
    /* { /(url) : function(request, response)

  */}

    // 웹서버를 실행시킨다.
    listen(port, cb){
      server.listen(port, cb)
    }
  }
}
