/* 주체: 객체 - 일반 객체와 함수 객체
property
 =\
*/
"use strict"

//합수 객체 응용편
// 1) 역할
// 이 함수 객체는 계산 결과를 저장할 수 있도록 객체를 초기화시키는 일을 한다.


var obj = {}
obj.result = 10

//read only 프로퍼티 추가하기
// 객체를 전문적으로 조작할 수 있는 Object"라는 도구가 있다.
// 그 도구의 기능(function)을 이용하여 read only 프로퍼ㅣ를 만들 수 있다.
/* Object. defineProperty(객체, 프로퍼티명, 옵션정보를 저장한 객체)
*/Object.defineProperty(obj, 'result2', {
    value: '100'
})

console.log(obj.result)
console.log(obj.result2)
console.log('--------------')
obj.result = 20
console.log(obj.result)
obj.result2 = 200 // result2 는 read only 프로퍼티이기 때문에 값을 변경할 수 없다.
console.log(obj.result2)
