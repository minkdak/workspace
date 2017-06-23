/* 주체: 객체 - 배열에서 여러 개의 항목 받기
- 할당 연산자(=) 사용하여 한번에 여러 개의 배열 항목을 받을 수 있다.
  var [변수1, 변수2, 변수3,...] = 함수

*/

"use strict"

// 각 변수 선언 마다 값 초기화시키기
var a = 10;
var b = 20;
var c = 30;
console.log(a, b, c)

// 한 번 변수를 선언할 때 여러 개의 변수를 성넝하고 쵝화시키기
var i = 10, j = 20, k =30;
console.log(i, j, k)

// 배열의 값을 한 번에 여러변수에 할당하는 방법
var [x, y, z] = [10, 20, 30, 50]
console.log(x, y, z)

//
var obj = {
  name: '홍길동'
  age: 20
  tel: '1111-1111'
  email: 'hong@test.com'
}
/*
var name = obj.name;
var age = obj.age;
console.log(name, age);
*/

// 다음처럼 한 번에 객체에서 원하는 값을 뽑아 별도 변수에 저장할 수 있다.
var {name, age} = obj
console.log()
var {age, email} = objconsole.log(age, email)
