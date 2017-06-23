/* 주제: Object() - 객체 생성 및 초기화
- 객체를 초기화시킬 때 사용하는 기본함수
*/

// 1) Object() 함수의 고유 기능 - 객체를 사용하는 데 필요한 최소한의 프로퍼티를 등록하기.
var obj1 = {} // new Object() 명령의 단축코드
var obj2 = new Object();
var obj3 = Object.
console.log(obj1);
console.log(obj2);

// Object() 함수 객체에는
// 일반 함수에 인스턴스 함수들이 보관되어 있다.

var obj2 = {
  name: '홍길동',
  age: 20
}

// 인스턴스 함수(객체에 직접 저장되거나 생성자의 prototype에 저장된 함수)를 사용해보자!
console.log(obj2.hasOwnProperty('name'))
console.log(obj2.hasOwnProperty('age'))
console.log(obj2.hasOwnProperty('tel'))

// 함수 객체에 보관덴 일반 함수를 사용해보자!
var obj3 = Object.create(null);

//
