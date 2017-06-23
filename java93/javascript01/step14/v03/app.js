/* Express 프레임워크 적용 - 여러 개의 모듈로 서비스 핸들러를 분산하기
*/
var express = require('express')
var bodyParser = require('body-parser')
var path = require('path')
var router = require('./aa')
// 템플릿 엔진을 통합하여 관리자 모듈 로딩

var cons =require('consolidate')

var app = express()
app.use(express.static('public'))
app.use(bodyParser.urlencoded({extended: false}))

// aa: 외부에서 등록된 서비스 핸들러 가져오기. => 서비스 라우터 등록
// 라우터(router)? 경로 담당자
var router = require('./aa')
app.use('/aa', router) // /aa 경로에 대한 요청을 처리할 담당자를 설정한다.
// 이모듈이 리턴한 값 router.


app.engine('html', cons.handlebars)
app.set('view engine', 'html')
app.set('views', path.join(__dirname, './templates'))//템플릿 파일경로

app.get('/test.do', function(request, response) {
  response.render('test', {name: "동길홍"})
})

app.get('/test2.do', function(request, response) {
  response.render('test2', {names: ['길홍동', '임꺽정', '유관순']})
})

app.get('/test3.do', function(request, response) {
  response.render('d/test3', {names: ['길홍동2 ', '임꺽정2', '유관순2']})
})

app.listen(8888, function() {
  console.log('서버가 시작되었습니다.')
})
