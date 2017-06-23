"use strict"
const net = require('net')
window.$ = window.jQuery = require('jquery')
var host = $('#host'),
    port = $('#port'),
    alias = $('#alias'),
    message = $('#message'),
    messageBox = $('#messageBox');

var socket = new net.Socket()


var buffer = ''

socket.on('data', (data) => {
  buffer += data.toString()

  // 줄바꿈 코드를 찾아서 값을 추출한다.
  var value = null
  while (true) {
    var newLineIndex = buffer.indexOf('\n')
    if ( newLineIndex < 0)
      return;

    value = buffer.substring(0, newLineIndex)
    buffer = buffer.substring(newLineIndex + 1)

    if (value.length > 0)
	  break;
  }

  messageBox.val(messageBox.val() + value + '\n')
  messageBox.scrollTop(messageBox.prop('scrollHeight'));
})

socket.on('error', (error) => {
  alert(error.message)
})

$('#connectBtn').click(() => {//포트번호를 가져와보자
  socket.connect(parseInt(port.val()), host.val(), () =>{
    socket.write(alias.val() + '\n') // 연결하자마자 이거 쓰겠다고 ㅇㅋ?
  })

})

$('#sendBtn').click(() => {
  socket.write(message.val() + '\n')
})
