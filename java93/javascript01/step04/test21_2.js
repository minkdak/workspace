"use strict"
//비동기식임
/* 2단계:
+ 사용자로부터 command 값 입력 받기
+ 반복하기
var prompt = require('prompt')

prompt.start()

inputCommand()
function inputCommand() {
    prompt.get(['command'], function(err, result) {
      console.log(result.command);
      inputCommand();
})}

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
