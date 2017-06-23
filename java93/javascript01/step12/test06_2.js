/* GET 요청과 POST 요청의 데이터 다루기
=> POST 요청 데이터는 요청 헤더 이후에 전달된다.
  'url' 모듈의 분석기로 뽑아낸다
=> POST 요청으로 대량의 데이터를 보낼 수 있기 때문에
  서버쪽에서는 대량의 데이터를 받을 수 있는 방식으로 처리한다.
  => 테스트 하는 방법
  1) test06_2.js를 실행하여 웹서버를 가동시킨다.
  2) 웹 브라우저에서 test06_2.html 파일을 로딩한다.
  3) 입력폼에 값을 입력한 후 전송 버튼을 클릭한다.
  4) test06_2.js의 응답 결과를 확인한다.
*/


const http = require('http')
const url = require('url')
const qs = require('querystring')
/* Query String 분석기 준비
=> name=value&name2=
*/
const server = http.createServer(function(request, response) {
  var urlInfo = url.parse(request.url, true)
  if(urlInfo.pathname != '/post.do') {
    response.end()
    return
  }

  //1) POST 요청으로 들어온 데이터를 저장할 변수 준비.
  var buf = ''

  // 2) POST요청 데이터를 읽을 때 마다 'data' 이벤트가 발생하는데,
  //이 이벤트를 처리해야 한다.
  //즉 데이터를 읽을 때마다, 그 읽은 데이터를 buf변수에 저장시킨다.
  //=>  'data' 이벤트는 클라이언트가 보낸 대량의 데이터 중에서 일부 데이터를 읽을 때 마다
  //  발생된다. 이렇게 하는 이유는 개발자에게 처리 기회를 주기 위함이다.
  request.on('data', (data) => { // 데이터는 한번에 들어오는게 아니라 나눠서 들어온다.
    // 나눠서 들어오는 데이터를 처리하면 그 속도가 매우느릴 수 밖에없다.
    // 때문에 데이터를 계속하여 저장해서 요청을 처리한다.
    buf +=data // 데이터를 받을 때마다 저장.
})

  //3) POST 요청 데이터 읽기를 마쳤으면 'end' 이벤트가 발생한다.
  //따라서 'end' 이벤트가 발생했을 때 클라이언트 요청을 처리하면 된다.
  request.on('end', () => { // end가 발생했을때...이함수를 실행하라는 뜻의 on
    response.writeHead(200, {
      'Content-Type' : 'text/plain;charset=UTF-8'
  })

  //4) 쿼리스트링 분석기를 이용하여 문자열을 객체로 바꾼다.
  var params = qs.parse(buf) // 쿼리스트링 분석기롱 파싱. 그걸 객체에담는다.
  response.write('name=' + params.name + '\n')
  response.write('age=' + params.age + '\n')
  response.write('tel=' + params.tel + '\n')
  console.log(params)
  response.end();
})
})

server.listen(8888)

console.log("서버 실행 중...")
