/* 주제: 흐름 제어문 - 반복문 for.. of
- 배열 뿐만아니라 iterator
  (including Array, Map, Set, String, TypedArray, arguments object and so on)의
  값을 추출할 때 사용한다.
- for.. in 과의 차이점은 변수에 저장되는 것은 인덱스나 프로퍼티 명이 아니라 값이다.
- 문법
for (var value in 배열 또는 객체)
*/
"use strict"

var names = ["홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"];

for (var index in names){ // for ..in 에서 변수에 저장되는 것은 인덱스 또는 프로퍼티 명
  console.log(index);
}
console.log("-------------------------------------");

for (var value of names){ // for..of 에서 변수에 저장되는 것은 값이다.
  console.log(value);
}
console.log("-------------------------------------");

// 다음 for 문은 index를 직접 다룰 수 있다. 그러나 for.. in은 불가능하다.
for (var i = 0; i < names.length; i +=2){
  console.log(i, names[i]);
}
console.log("-------------------------------------");

var student = {
  name: "홍길동",
  age: 20,
  tel: "111-1111",
  email: "test@test.com"
};
/*
for (var label in student) {
  console.log(label);
}
console.log("-------------------------------------");

for (var value of student) {
  console.log(value);
}
console.log("-------------------------------------");
*/
