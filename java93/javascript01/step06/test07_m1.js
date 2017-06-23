/* 주제: exprots 객체를 다른 객체로 대체하기
*/

"use strict"



module.exports = {
  plus(a, b) {return a + b},
  minus(a, b) {return a - b},
  multiple(a, b) {return a * b},
  divide(a, b) {return a / b}
}

var {plus, minus} = require('./test07_m1.js')
/*
var plus = require('./test07_m1.js').plus
var minus = require('./test07_m1.js').minus
*/

console.log(plus(10, 20))
console.log(minus(10, 20))
