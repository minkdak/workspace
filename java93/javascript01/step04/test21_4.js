/* 주제: 함수 - 연습
> node test21.js
--------------------------
prompt: command: list
[학생 성적 목록]
0: "홍길동1", 100, 90, 80, 270, 90
1: "홍길동2", 100, 90, 80, 270, 90
2: "홍길동3", 100, 90, 80, 270, 90
3: "홍길동4", 100, 90, 80, 270, 90
--------------------------
prompt: command: add
[학생 성적 입력]
prompt: name: 홍길동5
prompt: kor: 100
prompt: eng: 100
prompt: math: 100
성적
이름: 홍길동5
국어: 100
영어: 100
수학: 100
합계: 300
평균: 100
--------------------------
prompt: command: list
[학생 성적 목록]
0: "홍길동1", 100, 90, 80, 270, 90
1: "홍길동2", 100, 90, 80, 270, 90
2: "홍길동3", 100, 90, 80, 270, 90
3: "홍길동4", 100, 90, 80, 270, 90
4: "홍길동5", 100, 100, 100, 300, 100
--------------------------
prompt: command: delete
prompt: no: 2
"홍길동3"의 정보가 삭제되었습니다.
--------------------------
prompt: command: list
[학생 성적 목록]
0: "홍길동1", 100, 90, 80, 270, 90
1: "홍길동2", 100, 90, 80, 270, 90
2: "홍길동4", 100, 90, 80, 270, 90
3: "홍길동5", 100, 100, 100, 300, 100
--------------------------
prompt: command: quit
안녕히 가세요!
>
*/

/* 4단계:
+ 사용자로부터 command 값 입력 받기
+ 반복하기
+ 'quit' 명령 처리하기
+ 'list', 'add', 'delete' 명령 구분하기
*/

"use strict"

var prompt = require('prompt')

prompt.start()

inputCommand()

function inputCommand() {
  prompt.get(['command'], function(err, result){
    if(result.command == 'quit') {
      console.log('안녕히 가세요!')
      return // 함수실행을 끝낸다.
    } else if (result.command == 'list') {
      console.log('[학생 목록]')
    } else if (result.command == 'add') {
      console.log('[학생 입력]')
    } else if (result.command == 'delete') {
      console.log('[학생 삭제]')
    }
    inputCommand()
  })
}
