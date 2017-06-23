/* 주제: exprots 객체를 다른 객체로 대체하기
*/

"use strict"


module.exports = function() {
  return [
    result : 0,
    plus(value) {this.result += value},
    minus(value) {this.result -= value},
    multiple(value) {this.result *= value},
    divide(value) {this.result /= value},
  ]
}
