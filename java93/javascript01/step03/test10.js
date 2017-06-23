/* 주제: 흐름 제어문 - switch의 조건 값
- case에 지정할 수 있는 값의 종류
*/
"use strict"

var level;

level = "경비원";
switch (NaN) {
 case "문자열":
  console.log("문자열 가능!");
  break;
 case 1:
  console.log("숫자 가능");
  break;
 case true:
  console.log("boolean값 가능");
  break;
 case 3.14159:
  console.log("부동소수점 가능");
  break;
 case undefined:
  console.log("undefined 가능"); // <-- 정의 된 변수가 없음
  break;
 case null:
  console.log("null가능"); // 변수는 있지만 값이 없음.
  break;
  console.log("NaN 가능");
 case NaN: //NaN은 직접 비교할 수 없다. is(NaN)으로 비교해야한다.
}
console.log("---------------------------");

var v = NaN;

if (v == NaN)
 console.log(NaN);
