/* 주제: 모듈들 사이에서 변수 공유학
- 자바스크립트 파일에 그냥 선언한 변수는
  => 웹 브라우저 실행 환경: 글로벌 변수
  => NodeJS실행 환경: 모듈 변수
- 글로벌 변수는 모듈에 상관없이 모든 함수에서 접근 가능하다.
- 모듈 변수는 오직 그 모듈 내에서만 접근가능하다.

*/
"use strict"

var v1 = 100
global.v2 = 100

require('./test10_m1.js')

console.log('test10.js => v1:', v1)
console.log('test10.js => global.v2:', global.v2)

//
