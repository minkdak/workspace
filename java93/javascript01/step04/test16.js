/* 주제: 함수 - 글로벌 변수와 로컬 변수
- 함수 밖에 선언된 변수는 글로벌(global) 변수이다.
- 함수 안에 선언된 변수는 로컬(local) 변수이다.
- 로컬 변수는 함수 실행(호출)이 끝나면 제거된다.
- 글로벌 변수는 언제든지 함수 안에서 사용할 수 있다.
*/
"use strict"

var v1 = 100;
function f1() {
  // 함수 안에서 글로벌 변수를 사용할 수 있따.
  console.log("f1():", v1);

  // 당연히 글로벌 변수의 값을 바꿀 수 있다.
  v1 = 200;
}

console.log(v1)
f1()
console.log(v1)

/*
var v1 = 100;
function f1() {

  console.log("f1():", v1);
  v1 = 200;
}
console.log(v1); //
f1();
console.log(v1); //

*/