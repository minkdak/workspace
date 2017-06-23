/*"use strict"

var a = 10; // 0000 0000 0000 0000 0000 0000 0000 1010
var b = 12; // 0000 0000 0000 0000 0000 0000 0000 1100

console.log("a & b =", a & b); // 1000 -> 8
console.log("a | b =", a | b); // 1110 -> 14
console.log("a ^ b =", a ^ b); // 0110 -> 6
console.log("~a", (~a).toString(10)); // 0101 -> -11
console.log("--------------------------------------");

//red와 blue 색을 없애는 기법
var pixel = 0x34f588; // 00110100 11110101 10001000
var mask = 0x00f500; // 00000000 11110101 00000000
console.log((pixel & mask).toString(16));// 00000000 11110101 00000000

// OR의 사용

var pixel = 0x34f588; // 00110100 11110101 10001000
var mask = 0xaa0000;  // 10101010 0000000 00000000
console.log((pixel | mask).toString(16)); // 10111100 11110101 10001000

// XOR의 사용
var pixel = 0x34f588; // 00110100 11110101 10001000
var mask = 0x34f588;
console.log((pixel ^ mask).toString(16));
*/

//콤마 연산자
/*

var a, b = 20, c;
console.log(a, b, c);

var r;
r = 100 * 2, 5 / 3, 4 + 7;
console.log(r);

function f(){
   return 5, 7 , 8;
}
console.log(f());

/*

//연산자 - 단축배정 연산자
use strict"
var a = 10;
a = a + 7;
console.log(a);

a = 10;
a += 7
console.log(a);


"use strict"

var r;
r = 10 + 2 * 3;
console.log(r);

r = (10 + 2) * 3;
console.log(r);

r = 10 - 3 + 7 ;
console.log(r);

r = 10 / 2 *3 ;
console.log(r);

var a = 10;
r = a++ + a++ - a ++;
// 10 + 11 - 12, a =13
console.log(r , a);
*/
"use constrict"

//boolean형으로 변환
//number --> boolean
// 0 =fasle , 이외 모든수는 true
console.log(0, Boolean(0)); //false
console.log(1, Boolean(1)); // true
console.log(-1, Boolean(-1)); // true
console.log(120, Boolean(120)); // true
console.log(Infinity, Boolean(Infinity)); //true
console.log(-Infinity, Boolean(Infinity)); //true
console.log("-------------------------------------");

//String --> Boolean형변환
//"" 빈문자열은 false, 그밖true
console.log("",Boolean("")); //false
console.log(" ", Boolean(" ")); //true
console.log("  ", Boolean("  ")); //true
console.log("true", Boolean("true")); //true
console.log("false", Boolean("false")); //true

console.log(null, Boolean(null))//;flase
console.log(undefined, Boolean(undefined));//false
console.log(NaN, Boolean(NaN));//false
console.log("-------------------------------------");

//number 형변환

//boolean -- > number
console.log(false, Number(false));
console.log(true, Number(true));

//stiring --> number
//빈문자열 또는 공백만 있는 문자열은 0
//숫자만 들어있는 문자열은 그 숫자로 변환,
//숫자가 아닌 모든 문자열은 NaN

console.log("", Number(""));// 0
console.log(" ", Number(" "));// 0
console.log("  ", Number("  "));// 0
console.log("12", Number("12"));// 12
console.log("017", Number("017"));// 17
console.log("false", Number("false"));//NaN
console.log("true", Number("true"));//NaN
console.log("hello", Number("hello"));//NaN
console.log("2500원", Number("2500원"));//NaN
console.log("$2500", Number("$2500"));//NaN
console.log("-------------------------------------");

//parseInt(문자열)
//숫자로 시작하는 경우, 숫자 다음에 오는 문자는 없애고 숫자로 바꾼다
//문자로 시작할 경우 숫자로 바꾸지 못한다.

console.log("2500원", parseInt("2500원"));//2500
console.log("2500$", parseInt("2500$"));//2500
console.log("200만원", parseInt("2500만원"));//2500
console.log("$2500", parseInt("$2500"));//NaN

console.log(null, Number(null));//
console.log(undefined, Number(undefined));//
console.log(NaN, Number(NaN));//
console.log("-------------------------------------");

//배열  -> Number
// 빈배열은 0,
// 값이 한 개만 있는 배열은 일반 변수처럼 계산한다.
//값이 두개이상 들어있는 경우 배열은 NaN,
//객체는 NaN
console.log("[]",Number([])); // 0
console.log("[10]",Number([10])); // 10
console.log("['10']",Number(["10"])); // 10
console.log("[10,20]",Number([10,20]));// NaN
console.log("{}",Number({})); //NaN


//string형전환
//boolean --> string
//true는 'true',false는 'false'

console.log(true, String(true));
console.log(false, String(false));

//number --> string
//그대로 문자열로 바뀐다

console.log(17, String(17));

//strict 모드에서는 8진 표현을 허락하지 않는다.
console.log(null, String(null));
console.log(undefined, String(undefined));
console.log(NaN, String(NaN));
console.log("[]",String([]));
console.log("[10,20,30]",String([10,20,30]));
console.log("{}",String({}));

console.log("7" == 7); // 7 == 7
console.log("7" == 8); // 7 == 8
