const http = require('http')
const url = require('url')

const datasource = require('./datasource')

const studentDao = require('./student-dao')
const studentService = require('./student-service')
const connection = datasource.getConnection()
studentDao.setConnection(connection)
studentService.setStudentDao(studentDao)

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

var pageNo = parseInt(urlInfo.query.pageNo)
var pageSize = parseInt(urlInfo.query.pageSize)

response.writeHead(200, {
  'Content-Type' : 'text/html;charset=UTF-8'
})


response.write('<html> \
  <head> \
    <title>학생목록</title> \
  </head> \
  <body>')//response.write(html>head)
response.write('<h1>학생목록</h1>')
response.write('pageNo=' + urlInfo.query.pageNo + '<br>')
response.write('pageSize=' + urlInfo.query.pageSize + '<br>')

studentService.list(pageNo, pageSize, function(results) {
  response.write('<table border = "1"> \
  <thead> \
    <tr><th>번호</th><th>이름</th><th>이메일</th><th>전화</th><th>직장인</th></tr> \
  <thead> \
  <tbody>')

  for (var r of results) {
    response.write('<tr><td>' + r.mno + '</td>')
    response.write('<td>' + r.name + '</td>')
    response.write('<td>' + r.email + '</td>')
    response.write('<td>' + r.tel + '</td>')
    response.write('<td>' + r.work + '</td></tr>')
  }

  response.write('</tbody></table> \
  </body></html>')
  response.end()
}, function(error) {
  response.write('DB 오류!')
  response.write('</body></html>')
  response.end()
  throw error
  })

})

server.listen(8888)
console.log('서버 실행중..')
