/* 객체 - this 변수의 활용
- this 변수를 내부 함수에서 사용하는 방법
  */
  "use strict"

var obj1 ={}
obj1.v1 = 100
obj1.f1 =function() {
  console.log(this)// 해당 함수가 속한 객체의 간단한 정보가 나온다.
  console.log(this.v1)
  // console.log(v1) // 함수 안에도 바깥쪽에서도 v1이없다면 에러.
}// 이 함수가 속해있는 객체에있는 걸 호출하기원함.
//this = 호출할 때 앞에 준 객체(obj1) 주소가 저장됨.

obj1.f1()
//f1() 이렇게 호출하면 현재 이 자바스크립트에서만 사용할 수 있는 함수로 인식.

function f2() {
  // console.log(this) 객체에 소속된 함수가 아니라면 this가 존재하지 않는다.
  console.log('hello')
}

f2() // 이 파일 안에서만 사용하는 함수라면 객체를 지정할 필요가 없다.
