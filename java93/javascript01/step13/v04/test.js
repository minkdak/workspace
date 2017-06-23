var miniExpress = require('./mini-express') //로딩

var app = miniExpress()
//객체리턴

app.get('/', function(request, response){
  response.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'})
  response.end('<html> \
  <body> \
  <h1>안녕하세요!</h1> \
  </body> \
  </html>')
})

app.listen(8888, function() { //실행
  console.log('서버가 시작되었습니다.')
})
