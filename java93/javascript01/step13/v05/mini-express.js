/* 미니 Express 만들기 - POST 요청 시 파라미터 데이터를 처리하는 코드 추가.
*/

var http = require('http') // 서버를 실행시킬거야.
var url = require('url')
var path = require('path')
var fs = require('fs')
var qs = require('querystring') // querystring 분석

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

function findHandler(method, servicePath){
  if (method == 'GET'){
    return getHandler[servicePath]

  } else if (method == 'POST'){
    return postHandler[servicePath]
  }
  return null
}


var server = http.createServer(function(request, response) {
  var urlInfo = url.parse(request.url, true)

  var handler = findHandler(request.method, urlInfo.pathname);

  if(handler) { // handler가 있다면 get 요청 post값에따라 실행
    if (request.method == 'GET') {
      request.query = urlInfo.query // 인포 객체(폴더)안에 쿼리 객체안에 저장된 변수 = 값
      handler(request, response)//실행
    } else if (request.method == 'POST') {
      var queryString = ''
      request.on('data', function(data) {
        queryString += data
    })
    request.on('end', function() {
      request.query = qs.parse(queryString) //url로 알수 없으니까, request query에담아주고
      handler(request, response) // 호출
    })
  }

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

    // 웹서버를 실행시킨다.
    listen(port, cb){
      server.listen(port, cb)
    }
  }
}
