var miniExpress = require('./mini-express') // 여기서 서버생성은 완료된다.

var app = miniExpress() //객체리턴.


app.listen(8888)
