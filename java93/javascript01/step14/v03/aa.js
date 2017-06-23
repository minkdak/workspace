/* 서비스 핸들러를 정의한 모듈
*/
var express = require('express')
var bodyParser = require('body-parser')
var path = require('path')
var router = express.Router() //express에서 router를 만들겠다.
//router: 경로 조정기

router.use('/aa/test.do', function(request, response) {
  response.end('aa/test.do~~~~~')
})

router.use('/aa/test2.do', function(request, response) {
  response.end('aa/test2.do....')
})

module.exports = router
//준비된 router 정보를 모듈로 리턴.
// 이 준비된 라우터를 어디에서 사용하느냐.
