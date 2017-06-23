/* 주제: 함수 - arrow function
 - 함수 정의를 축약한 문법
 */

 "use strict"

 var f1 = function() {
   console.log("익명함수...");
 }

var f2 = () => {console.log("Arrow합수")};
var f3 = () => console.log("Arrow함수");

f1()
f2()
f3()
