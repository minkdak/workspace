/* Express 프레임워크 적용
*/
var express = require('express')
var bodyParser = require('body-parser')
var path = require('path')
var cons = require('consolidate'); // 템플릿 엔진이고 사용법을 다르다. 이를 통합 관리해준다.

var app = express()

// 웹브라우저가 요청하는 파일이 어떤 폴더에 있는지 지정한다.
app.use(express.static('public')) //1) 폴더명은 마음대로 할 수 있다. 여러 파일을 지정할 수 있다.

// 클라이언트에서 분석 요청이 들어온다면 다음과 같이 만든다.
// POST 요청 데이터 분석기를 등록한다.
// => 이 분석기를 등록해야만 POST 요청으로 들어온 데이터를 꺼낼 수 있다.
app.use(bodyParser.urlencoded({extended: false})) // app.use 사용해라.


app.engine('html', cons.handlebars) // 사용할 템플릿 엔진을 등록한다.
app.set('view engine', 'html') // 기본 템플릿 엔진으로 어떤 것을 사용할 지 지정한다.
app.set('views', path.join(__dirname, '/views')) // 템플릿 파일이 있는 위치를 지정한다.(경로)

// 서비스 라우터를 등록한다.
// => http://localhost:8888/student/.... 요청을 처리할 라우터를 등록한다.
app.use('/student', require('./control/student-control'))
//2) /student로 들어오는 요청을 require()라우터 에 물어봐라.

app.get('/', function(request, response) { // 3) /요청이 들어오면 함수를 실행하자. 이함수의 역할은 템플릿 엔진을 실행한다.
  response.render('index') // 어느 템플릿을 쓸것인지 경로지정. 'index' -> html 은 안적어도된다 위에서 설정했다.
}) //index html. 필기

app.listen(8888, function() {
  console.log('서버가 시작되었습니다.')
})
