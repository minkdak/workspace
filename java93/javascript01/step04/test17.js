/* 주제: 함수 - 글로벌 변수와 로컬 변수
- 함수 밖에 선언된 변수는 글로벌(global) 변수이다.
- 함수 안에 선언된 변수는 로컬(local) 변수이다.
- 로컬 변수는 함수 실행(호출)이 끝나면 제거된다.
- 글로벌 변수는 언제든지 함수 안에서 사용할 수 있다.
*/
"use strict"

var v1 = 100;
function f1() {
  // 함수 안에 선언하는 변수는 모두 로컬 변수이다.
  // => 같은 이름을 갖는 글로벌 변수가 있다 하더라도,
  //    상관없이 새 로컬 변수를 만든다.
  // => 로컬 변수는 함수 호출이 끝나면 제거 된다.
  var v1 = 200;
  var v2 = 300;
  console.log("f1():", v1, v2);

}

console.log(v1); // 글로벌 변수 v1
f1();
console.log(v1); // 글로벌 변수 v1
//console.log(v2); // 글로벌 변수 v2. f1() 로컬 변수 v2를 사용할 수 없다.
f1();
