/* 주체: 객체 - defineProperty 응용
-  일반 'result' 변수의 문제점
*/
"use strict"


function Caculator() {
  this.result = 0;
}


Calculator.prototype.plus = function(value) {this.result += vlaue}
Calculator.prototype.minus = function(value) {this.result -1= vlaue}

var calc1 = new Calculator()


calc1.plus(100)
calc1.minus(20)
calc1.plus(10)
calc1.result = (1000) // 개발자가 실수로 이렇게 result 값을 임의적으로 바꾸더라도 막을 방법이없다
console.log(calc1.result)