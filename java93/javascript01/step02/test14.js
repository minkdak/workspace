/* 주제: 연산자 - 명시적 형변환(explicit type casting(conversion))
- 데이터를 다른 종류의 값으로 변경하는 것
*/
"use strict"

// boolean형으로 변환
// number --> boolean
//- 0은 false, 0 이외의 모든 수는 true
console.log(0, Boolean(0));
console.log(1, Boolean(1));
console.log(-1, Boolean(-1));
console.log(120, Boolean(120));
console.log(Infinity, Boolean(Infinity));
console.log(-Infinity, Boolean(-Infinity));


/* string --> Boolean-
 "" 빈문자열은 false, 그밖에 true
 */
console.log("", Boolean(""));
console.log(" ", Boolean(" "));
console.log("  ", Boolean("  "));
console.log("true", Boolean("true"));
console.log("false", Boolean("false"));


console.log(null, Boolean(null));
console.log(undefined, Boolean(undefined));
console.log(NaN, Boolean(NaN));
console.log("-------------------------------")

// number 형으로 변환
/* boolean --> number)
- true는 1, false는 0
*/
console.log(true, Number(true));
console.log(false, Number(false));

/* string --> Number
 - 빈문자열 또는 공백만 있는 문자열은 0
 - 숫자만 들어있는 문자열은 그 숫자로 변환,
 - 숫자가 아닌 모든 문자열은 NaN
 */
console.log("", Number(""));
console.log(" ", Number(" "));
console.log("  ", Number("  "));
console.log("12", Number("12"));
console.log("017", Number("017"));
console.log("false", Number("false"));
console.log("true", Number("true"));
console.log("hello", Number("true"));
console.log("2500원", Number("2500원"));
console.log("$2500", Number("$2500"));

/* parseInt(문자열)
 - 숫자로 시작하는 경우, 숫자 다음에 오는 문자는 없애고 숫자로 바꾼다.
 - 문자로 시작할 경우 숫자로 바꾸지 못한다.
 */
console.log("2500원", parseInt("2500원"));
console.log("2500$", parseInt("2500$"));
console.log("200만원", parseInt("200만원"));
console.log("$2500", parseInt("$2500"));

console.log(null, Number(null));
console.log(undefined, Number(undefined));
console.log(NaN, Number(NaN));

/* 배열 또는 객체--> Number
 - 빈배열은 0,
 - 값이 한 개만 있는 배열은 일반 변수처럼 계산한다.
 - 값이 두개 이상 들어있는 경우 배열은 NaN,
 - 객체는 NaN
*/
console.log("[]", Number([]));
console.log("[10]", Number([10]));
console.log("['10']"), Number(["10"]);
console.log("[10,20]", Number([10, 20]));
console.log("['10','20']", Number(["10","20"]));
console.log("{}", Number({}));
console.log("--------------------------------------------");

// string 형으로 전환
/* boolean --> string
 - true는 'true', false는 'fase'
*/

console.log(true, String(true));
console.log(false, String(false));

/* number --> string
- 그대로 문자열로 바뀐다.
*/
console.log(17, String(17));
//console.log(014, String(014));// strict 모드에서는 8진 표현을 허락하지 않는다.

console.log(null, String(null));
console.log(undefined, String(undefined));
console.log(NaN, String(NaN));
console.log("[]", String([]));
console.log("[10, 20, 30]", String([10, 20, 30]))
console.log("{}", String({}));
