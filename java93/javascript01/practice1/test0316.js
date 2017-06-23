//"use strict"
/*
var name = "홍길동";
var tel = "1111-2222";
var kor = 100;
var eng = 100;
var math = 100;

console.log(name,tel,kor,eng,math);

var name2 = "임꺽정",
    tel2 = "222-2222",
    kor2 = 90,
    eng2 = 90,
    math2 = 90;
console.log(name2,tel2,kor2,eng2,math2);


"use strict"
var name = "홍길동";
var name = "임꺽정";
console.log(name);


var name = "홍길동";
{
  var name = "임꺽정";
  console.log(name);

}
console.log(name);

{
  var age = 20;
}
console.log(age);


var name = "홍길동";
{
  let name = "임꺽정";
  console.log(name);

}
console.log(name);

{
  let age = 20;
  console.log(age);

}

//console.log(age);

var name = "홍길동";
var name = "임꺽정";
console.log(name);

let name2 = "홍길동";
let name2 = "임꺽정";
console.log(name2);

var name = "홍길동";
name = "임꺽정";
console.log(name);

let name2 = "홍길동";
name2 = "임꺽정";
console.log(name2);

const name3 = "홍길동";
name3 = "임꺽정";
console.log(name3);

const name = "홍길동";
console.log(name);

const age;
age = 20;
console.log(age);

"use strict"
var a = 7;
var b = 2;

console.log(a + b);//9
console.log(a - b);//5
console.log(a * b);//14
console.log(a / b);//3.5
console.log(a % b);//1
//console.log(a ** b);

console.log(10 / 0);
console.log(-10 / 0);
var a = 7;
var b = 2;

console.log(a == b); //false
console.log(a > b); // true
console.log(a >= b); // true
console.log(a < b); // false
console.log(a <= b); //false
console.log(a != b); // true

console.log(a === b);
console.log(a !== b);

var a;

a = 10;
console.log(++a);

a = 10;
console.log(--a);

a = 10;
console.log(a++);

a = 10;
console.log(a--);
*/
/* "=" 연산자의 순서
- 항상 r-value를 모두 수행한 후 마지막으로 할당 연산
a = 10;
a = ++a;
console.log(a);//11

a = 10;
a = a++;
console.log(a);
*/
/*
var a = true,
    b = false;
    console.log(a && b);//false
    console.log(a || b);//true
    console.log(!a);//false

console.log(
  true && true,
  true && false,
  false && true,
  false && false);

console.log(
  true || true,
  true || false,
  false || true,
  false || false);

"user strict";

((10 % 2) == 0) && console.log("짝수입니다1");

((11 % 2) == 0) && console.log("짝수입니다2");

((10 % 2) == 0) || console.log("홀수입니다1");

((11 % 2) == 0) || console.log("홀수입니다2");

var a = 11;
((a % 2) == 0) && console.log("짝수입니다3");
((a % 2) == 0) || console.log("홀수입니다3");



"user strict"
var a = 10;

console.log(a << 1)//20
console.log(a << 2)//40
console.log(a << 3)//80
console.log(a << 4)//160

a = 175;
console.log(a >> 1)//87
console.log(a >> 2)//43
console.log(a >> 3)//21
console.log(a >> 4)//10

a = -65;
console.log(a >> 1);// -33

a = 65;
console.log(a >>>1);// 32

a = -65;
console.log(a >>>1);//
*/
"use strict"
var a = 11;
console.log((a % 2) == 0? "짝수입니다." : "홀수입니다.");

a = 20;
(a % 2)==0? console.log("짝수입니다.") : console.log("홀수입니다.");
