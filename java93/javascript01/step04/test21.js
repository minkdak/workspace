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
"use strict"
//비동기식
var prompt = require('prompt');
var studentList = [
  ['홍길동1', 100, 100, 100, 300, 100],
  ['홍길동2', 90, 90, 90, 270, 90],
  ['홍길동3', 80, 80, 80, 240, 80],
  ['홍길동4', 70, 70, 70, 210, 70],
  ['홍길동5', 60, 60, 60, 180, 60]
];
inputCommand()

prompt.start();
function inputCommand() {
  prompt.get(['command'], function(err, result) {
    switch (result.command) {
    case 'quit':
      dfunction doQuit ()
      case 'list':
      console.log('[학생 목록]')
      var count = 0;
      for (var student of studentList) {
        console.log(count++ + ":" + student[0] + ',' +
        student[1] + ',' +
        student[2] + ',' +
        student[3] + ',' +
        student[4] + ',' +
        student[5]);
      };
      return; //함수실행을 끝낸다
      break;
    case 'add':
      console.log('[학생 입력]')
      prompt.get(['name', 'kor', 'eng', 'math'], function(err, result) {
        var student = [result.name,
          parseInt(result.kor),
          parseInt(result.eng),
          parseInt(result.math)];
          student[4] = student[1] + student[2] + student[3]
          student[5] = student[4] / 3

          studentList[studentList.Length] = student
          console.log('입력되었습니다.')
          console.log()
          inputCommand();
      })
      return;
    case 'delete':
      console.log('[학생 삭제]')
      prompt.get(['no'],function(err, result) {
        var no = parseInt(result.no)
        if (studentList.lengt == 0) {
          console.log('삭제할 항목이 없습니다.')
        }
        if ( no < 0 || no >= studentlist.lengt) {
          console.log('학생 번호가 옳지 않습니다.')
          inputCommand
          return
        }
        studentList.splice(no, 1)
        console.log('삭제했습니다')
        console.log()
        inputCommand();
        return;
      })

    default:
      console.log('해당 명령은 지원하지 않습니다.')
    }
      inputCommand();
  })
}
console.log('안녕히 가세요!')
function (doDefault
)


/*//비동기라서 동기함수로 바꿔줘야함
prompt.start();
function inputCommand() { //동기 함수
for (var i = 1; i < 5; i++) {
  prompt.get(['command'], function(err, result) {
    console.log(result.command);
  })
}}
*/
/*
function okok(err, result) {
  console.log(result.command);
}
prompt.get(['command'], okok)
*/
//문제점 가까이 있을 때는 어떤 값인지 알 수 있지만 한참 밑에갔을 경우 찾기 힘들기 때문에
//유지보수가 어렵다.
/*
var list1 = [["홍길동", 100, 90, 80, 270, 90],
            ["홍길동2", 100, 90, 80, 270, 90],
            ["홍길동3", 100, 90, 80, 270, 90],
            ["홍길동4", 100, 90, 80, 270, 90]]

function hr() {
  console.log("--------------------------")
}
hr()

prompt.get(['command'], function(err, result) {
  var list = result.list;
  var command = result.command;

  switch (command){
  case "list":
    console.log("학생 성적 목록");
    for (var i = 0; i < list1.length; i++) {
      console.log(list1[i])
    }

    }
  //case "add":
  //    name:
});

hr()
prompt.get(['command'], function(err, result) {
  var add = result.add;
  var command = result.command;

  switch (command) {
    case "add":

      break;
    default:

  }
*/
