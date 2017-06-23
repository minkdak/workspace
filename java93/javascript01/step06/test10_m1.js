/* 주제: 모듈 안에서 모듈 밖의 변수를 사용할 수 있는가?
*/

"use strict"

//v1 = 200 -> 안됨

var v1 = 200
console.log('test10_m1.js => v1:', v1)

global.v2 = 200
global.v3 = 300
console.log('test10_m1.js => global.v2:',global.v2)
console.log('test10_m1.js => global.v3:',global.v3)

// module.exports 에 아무것도 저장하지 않으면
// 그냥 빈 객체를 리턴할 것이다.
