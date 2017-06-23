"use strict"

var prompt = require('prompt')

prompt.start()
/* 1단계:
+ 사용자로부터 command 값 입력 받기
*/
prompt.get(['command'], function (err, result){
  console.log(result.command)
})
