// //템플릿 엔진 기본 사용법
//
// const handlerbars = require('handlebars')
//
// var str = '나는 {{name}}입니다.' // 객체의 프로퍼티명
// var data = {
//   name: '홍길동'
// }
//
// var template = handlerbars.compile(str)
//
// var result = template(data)
//
// console.log(result)


// const handlebars = require('handlebars')
//
// var str = '{{#each students}} \
// {{no}}, {{name}}, {{email}} \n \
// {{/each}} '
//
// var data = {
//   students: [
//     {no: 1, name: '홍길동1', email: 'hong1@test.com'},
//     {no: 2, name: '홍길동2', email: 'hong2@test.com'},
//     {no: 3, name: '홍길동3', email: 'hong3@test.com'},
//     {no: 4, name: '홍길동4', email: 'hong4@test.com'}
//   ]
// }
//
// var template = handlebars.compile(str)
// var result = template(data)
//
// console.log(result)

// const fs = require('fs')
// const path = require('path')
//
// //var templPath = path.join(__dirname, 'practice0427-template.txt')
// //console.log(templPath,"ㅋㅋ")
//
// fs.readFile(path.join(__dirname, 'practice0427-template.txt'), 'utf8', (err, data) => {
//   if(err) throw err
//   console.log(data)
// })


// const fs = require('fs')
// const path = require('path')
// const handlebars = require('handlebars')
//
// var data = {
//   name: '홍길동'
// }
//
// var templPath = path.join(__dirname, 'practice0427-template.txt')
//
// fs.readFile(templPath, 'utf8', (err, data) => {
//   if(err) throw err
//
//   var template = handlebars.compile(data)
//   var result = template(data)
//   console.log(template)
// })
//
// const fs = require('fs') //fs모듈을 불러온다
// const path = require('path') //path모듈을 불러온다
// const handlebars = require('handlebars') // 핸들바(템플릿엔진중 하나) 를 불러온다.
//
// const http = require('http') // 서버를 만들기위한 모듈
// const url = require('url') // url주소를 얻기 위한 모듈
//
// const datasource = require('./datasource') // sql을 사용하기 위해 데이터 소스 모듈을 가져온다
// const studentDao = require('./student-dao') // 미리 작성한 dao의 함수를 사용하기 위해 파일을 가져온다
// const studentService = require('./student-service') // dao에서 만든 함수를 사용하여 보다 간결하게 사용하기위해 불러온다
//
// const connection = datasource.getConnection() // 다른 파일에 있는 소스를 연결하기위해 정보를 객체에 담는다
// studentDao.setConnection(connection)
// studentService.setStudentDao(studentDao)
//
// var template = null
// var templPath = path.join(__dirname, 'test05_5.html') //변수를 만들어 html을 사용하기위해 html파일의 경로를 담는다
// fs.readFile(templPath, 'utf8', (err, src) => { //fs모듈을 사용하여 변수에 담은 template 경로를 지정하고 해당 파일을 utf8로해석한다.
//   // 성공하면 err와 src를 파라미터로 받는 익명함수를 생성한다.
//   if(err) throw err // 에러 일경우 에러를 던진다.
//
//   template = handlebars.compile(src) // 템플릿 소스를 컴파일 하기 위해 핸들바에있는 컴파일을 사용한다. 이때 src는 함수호출시 받는 데이터값이 아니다.
// })
//
// const server = http.createServer(function(request, response) { // 서버 변수를 만들어 http모듈에서 서버를 만들 객체함수를 불러온다.
//   // 객체 함수를 불러왔을 때 다음과 같은 함수를 실행한다.
//   if (request.url == '/favicon.ico') { //url에서 favicon.ico를 요청ㅇ하면
//     response.end(); // 응답을 바로 끝내고
//     return; // 리턴한다
//   }
//   var urlInfo = url.parse(request.url, true) // url분석기를 이용하여 url을 분석하고 객체로담는다.
//   //true를 사용하면 query를 분석하여 끊어서 담는다
//
//   if (urlInfo.pathname != '/student/list.do') { // url에서 포트 뒤? 앞까지 주소가 다음과 같으면
//     response.writeHead(404, { // not found를 나타내면
//       'Content-Type' : 'text/plain;charset=UTF-8' //컨텐트 타입을 일반으로하여
//     })
//     response.end('잘못된 URL입니다.')//이문구를 출력하고 응답한다.
//     return
//   }
//
//   var pageNo = parseInt(urlInfo.query.pageNo), // url에서 query의 값 을 구한다. ?뒤
//       pageSize = parseInt(urlInfo.query.pageSize)
//   response.writeHead(200, {
//     'Constent-Type' : 'text/html;charset=UTF-8'
//   })
//
// studentService.list(pageNo, pageSize, function(results) { //studentServicedao에서 list함수를 불러와
//   //pageNo와 pagsSize를 파라미터로 받고 다음 함수를 실행한다.
//   var data = { //data로 담는다.
//     "students" : results // studetns프로퍼티 명에 실행한 함수의 결과를 받는다.
//   }
//   response.end(template(data));
// }, function (error) {
//   response.write('<html><body>')
//   response.write('<p>DB 오류!</p>')
//   response.write('</html></body>')
//   response.end();
//   throw error;
//   })
// })
//
// server.listen(8888)
// console.log('서버 실행 중...')

// const http = require('http')
// const url = require('url')
// const server = http.createServer(function(request, response) {
//   var urlInfo = url.parse(request.url, true)
//
//   if(urlInfo.pathname != '/get.do') {
//     response.end
//     return
//   }
//
//   response.writeHead(200, {
//     'Content-Type' : 'text/plain;charset=UTF-8'
//   })
//   response.write('name =' + urlInfo.query.name + '\n')
//   response.write('age =' + urlInfo.query.age + '\n')
//   response.write('tel =' + urlInfo.query.tel + '\n')
//   response.end();
// })
//
// server.listen(8888)
//
// console.log("서버 실행 중...")

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

  var buf = ''

  //1) POST 요청으로 들어온 데이터를 저장할 변수 준비.
  request.on('data', (data) => {
    buf +=data // 데이터를 받을 때마다 저장.
})


  // 2) POST요청 데이터를 읽을 때 마다 'data' 이벤트가 발생하는데,
  //이 이벤트를 처리해야 한다.
  //즉 데이터를 읽을 때마다, 그 읽은 데이터를 buf변수에 저장시킨다.
  //=>  'data' 이벤트는 클라이언트가 보낸 대량의 데이터 중에서 일부 데이터를 읽을 때 마다
//   //  발생된다. 이렇게 하는 이유는 개발자에게 처리 기회를 주기 위함이다.
//   request.on('end', () => { // end가 발생했을때...이함수를 실행하라는 뜻의 on
//     response.writeHead(200, {
//       'Content-Type' : 'text/plain;charset=UTF-8'
//   })
//   //4) 쿼리스트링 분석기를 이요하여 문자열을 객체로 바꾼다.
//   var params = qs.parse(buf) // 쿼리스트링 분석기롱 파싱. 그걸 객체에담는다.
//   console.log(params)
//   response.write('name=' + params.name + '\n')
//   response.write('age=' + params.age + '\n')
//   response.write('tel=' + params.tel + '\n')
//   response.end();
// })
// })
//
// server.listen(8888)
//
// console.log("서버 실행 중...")
