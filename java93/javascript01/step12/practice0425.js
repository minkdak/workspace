const http = require('http')
const url = require('url')

const datasource = require('./datasource')
const studentDao = require('./student-dao')
const memberDao = require('./member-dao')
const studentService = require('./student-service')

const connection = datasource.getConnection()
studentDao.setConnection(connection)
memberDao.setConnection(connection)
studentService.setStudentDao(studentDao)
studentService.setMemberDao(memberDao)

  const server = http.createServer(function(request, response) {
    if (request.url == '/favicon.ico') {
      response.end();
      return;
    }
    var urlInfo = url.parse(request.url, true)

  if (urlInfo.pathname != '/student/add.do') {
    response.writeHead(404, {
      'Content-Type' : 'text/plain;charset=UTF-8'
    })
    response.end('잘못된 URL입니다.')
    return
  }
    var student = {
      name: urlInfo.query.name,
      tel: urlInfo.query.tel,
      email: urlInfo.query.email,
      password: urlInfo.query.password,
      working: urlInfo.query.working,
      schoolName: urlInfo.query.schoolName
    }
  var pageNo = parseInt(urlInfo.query.pageNo)
  var pageSize = parseInt(urlInfo.query.pageSize)

  response.writeHead(200, {
    'Content-Type' : 'text/html;charset=UTF-8'
  })

  response.write('<html> \
    <title>학생등록</title> \
    <head> \
    </head> \
    <body> ')
    response.write('<h1>학생 등록 결과</h1>')

  studentService.insert(student, function(results) {
    response.write('입력 성공입니다!')
    response.write('</body></html>')
    response.end();
    throw error;

  }, function(error) {
    response.write('DB 오류!')
    response.write('</body></html>')
    response.end();
    throw error;
  })

})

server.listen(8889)
console.log('서버 실행중..')
