/* 주제: 예외처리 - throw
=> 프로그램을 실행하는 도중 예외 상황이 발생했을 때,
  예외정보를 호출한 쪽에 알리는 명령어
*/

"use strict"

// throw 명령어가 없던 시절
function divide(a, b) {
  if (b == 0) { // 0으로 나누려 한다면
    return -12121212  // 리턴 값으로 나오기 희박한 수를 리턴한다.
  }
  return a / b
}

var result = divide(10, 2)
console.log(result)


var result = divide(10, 0)
if (result == -12121212) {
  console.log('0으로 나눌 수 없습니다.')
} else {
  console.log(result)
}
