/* 주제: Object() - 기본 사용법
*/

// 1) 함수로 사용해보자!
// - 문자열을 다루는데 필요한 프로퍼티를 등록한다.
var str1 = new String('Hello') // 문자열을 객체로 표현한다.
console.log(str1)
console.log(typeof str1)

// String(인스턴스)를 사용해보자
console.log('문자열 길이 = ', str1.length)
console.log('2번방의 문자 = ', str1.charAt(2))
console.log('---------------------')

var str2 = 'Hello' // 문자열을 값으로 표현한다.
console.log(str2)
console.log(typeof str2)
console.log('str2의 길이 = ',str2.length)
console.log('2번방의 문자 = ', str2.charAt(2))
