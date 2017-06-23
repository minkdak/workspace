/* 주제: g함수들이나 객체를 별돌의 파일로 분리하여 관리하기
- 지정된 시간이 지나면 자동으로 호출될 함수를 등록하는 방법
  clearInterval
- callback: 지정된 시간이 지났을 때 호출될 함수 주소
- dealy: 타임아웃 시간(밀리초)
- ...args: callback을 호출할 때 넘겨줄 값들
*/

"use strict"

function plus(a, b) {return a + b}
function minus(a, b) {return a - b}
function multiple(a, b) {return a * b}
function divide(a, b) {return a / b}

module.exports.plus = plus;
exports.minus = minus;
exports.multiple = multiple;
