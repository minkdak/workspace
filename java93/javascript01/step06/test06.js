/* 주제: g함수들이나 객체를 별돌의 파일로 분리하여 관리하기
- 지정된 시간이 지나면 자동으로 호출될 함수를 등록하는 방법
  clearInterval
- callback: 지정된 시간이 지났을 때 호출될 함수 주소
- dealy: 타임아웃 시간(밀리초)
- ...args: callback을 호출할 때 넘겨줄 값들
*/

"use strict"

// require (모듈경로)
// => module 객체에 보관된 exports 객체를 리턴한다.
var m1 = require('./test06_m1.js')


console.log(m1.plus(10, 20))
console.log(m1.minus(10, 20))
console.log(m1.multiple(10, 20))
// console.log(m1.divide(10, 20))
