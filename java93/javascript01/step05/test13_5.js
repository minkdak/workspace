/* 객체 - this 변수의 활용
- this 변수를 내부 함수에서 사용하는 방법
  */
  "use strict"

var obj1 ={
  v1: 100,
  f1() {
    console.log(this.v1)
    return function() {
      console.log(this)
      console.log('hi~~~~~!')
    } //객체와는 상관없는 일반함수이다.
    // f1함수가 객체에 소속된다고 얘도 소속되는건 아니다.
  }
}


var f2 = obj1.f1()
f2()

var obj2={}
obj2.x =f2
obj2.x()//여기서는 this가 있음.. why?

/* this는 함수가 객체에 담겨있고 그 함수를 호출할 때,
함수가 객체에 안담겨있다면 this는 존재하지 않는다.
*/
