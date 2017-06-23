/* Quiz - test04_1.js 에 템플릿 엔진을 적용하라!
 => 템플릿 파일: test05_5.html
*/

const fs = require('fs')
const path =require('path')
const handlebars = require('handlebars')

const http = require('http')
const url = require('url') //url을 전문적으로 처리하는 객체.
const datasource = require('./datasource')
const studentDao = require('./student-dao')
const studentService = require('./student-service')
// 이데이터를 재사용한다.
const connection = datasource.getConnection()
studentDao.setConnection(connection)
studentService.setStudentDao(studentDao)


var template = null

var templatePath = path.join(__dirname, 'test05_5.html')
fs.readFile(templatePath, 'utf8', (err, src) => {
  if(err) throw err

  template = handlebars.compile(src)
})


const server = http.createServer(function(request, response) {

  if (request.url == '/favicon.ico') {
    response.end();
    return;
  }
  var urlInfo = url.parse(request.url, true)

  if (urlInfo.pathname != '/student/list.do') {
    response.writeHead(404, {
      'Content-Type' : 'text/plain;charset=UTF-8'
    })
    response.end('잘못된 URL입니다.')
    return
  }

var pageNo = parseInt(urlInfo.query.pageNo),
    pageSize = parseInt(urlInfo.query.pageSize)
  response.writeHead(200, {
    'Content-Type' : 'text/html;charset=UTF-8'
  })


studentService.list(pageNo, pageSize, function(results) {
  var data = {
    "students" : results
  }
  response.end(template(data));
}, function(error) {
    response.write('<html><body>')
    response.write('<p>DB 오류!</p>')
    response.write('</html></body>')
    response.end();
    throw error;
  })
})

server.listen(8888)

console.log("서버 실행 중...")
