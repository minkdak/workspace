// Echo 서버 만들기

const net = require('net') // 넷 모듈 로딩

// 1) 서버 객체를 준비한다.
const server = new net.createServer((socket) => { // 클라이언트가 접속하면 호출 됨.
  console.log('=> 클라이언트가 연결되었습니다.')

  socket.on('data', (data) => {
    socket.write('[참회]' + data.toString())
    socket.destroy()
  })
}) // createserver하고 호출될 함 수 지정. socket은 파라미터값.

// 2) 서버를 시작 시킨다.
server.listen(8888, () => {
  console.log('=> 서버 실행 중...')
})
