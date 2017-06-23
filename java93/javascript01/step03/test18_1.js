/* 주제: 예외처리 - throw
=> 프로그램을 실행하는 도중 예외 상황이 발생했을 때,
  예외정보를 호출한 쪽에 알리는 명령어
*/

"use strict"

// throw 적용 전
function divide(a, b) {
  return a / b
}

var result = divide(10, 2)
console.log(result)

result = divide(10, 0)
console.log(result)

// thorw 명령이 없던 시절의 해결 방법
