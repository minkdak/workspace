/* 주제: exports를 사용자가 다른 객체로 대체하기
- 기존에 존재하는 exports 객체에 뭔가를 담아서 리턴할 수 있지만,
  아예 exports 객체를 다른 객체로 대체해서 리턴할 수 있다.
*/

"use strict"

// require (모듈경로)
// => module 객체에 보관된 exports 객체를 리턴한다.
var m1 = require('./test07_m1.js')


console.log(m1.plus(10, 20))
console.log(m1.minus(10, 20))
console.log(m1.multiple(10, 20))
console.log(m1.divide(10, 20))

var {plus, minus} = require('./test07_m1.js')

console.log(plus(10, 20))
console.log(minus(10, 20))
