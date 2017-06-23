/*
주제: 흐름제어문 - 조건문
- 조건에 따라 실행할 명령어를 선택하고 싶을 때 사용
- 문법
1) if 문만 사용한 경우
if(식)<----식(expression)의 결과값은 true 또는 false이다.
  명령문;

2) if ~ else ~ 문 사용:
if(식)
  명령문 1;
else
  명령문 2;

3) 블록({})을 사용하면 여러개의 명령도 하나로 묶을 수 있다.

"use strict"

var value = 10;

// 조건이 참이면, 한 문장을 실행한다.
if ((value % 2) == 0) console.log("짝수입니다.");
console.log('---------------------------------');

// if와 문장을 두 개의 줄에 작성할 수 있다.
if((value % 2) == 0)
  console.log("짝수입니다.");
  console.log('---------------------------------');

value = 11;
if((value % 2) == 0)
  console.log("짝수");
  console.log("입니다.");
  console.log('---------------------------------');

value = 11;
if ((value % 2) == 0);
  console.log("짝수입니다.1");
console.log('---------------------------------');

 value = 10
if ((value % 2) == 0){
  console.log("짝수");
  console.log("입니다2");
}
var value;
//else 도입전
value = 11;
if((value) == 0)
  console.log("짝수입니다.");
if((value) != 0)
  console.log("홀수입니다.");
console.log("-----------------");

//else 도입후
value = 11;

if((value % 2) == 0)
  console.log("짝수입니다.");
else
  console.log("홀수입니다.");
  console.log("-----------------");

//오류
/*if((value % 2) == 0)
  console.log("짝수입니다.");
console.log("-----------------");
else
  console.log("홀수입니다.");


value = 11;
if((value % 2) == 0){
  console.log("짝수입니다.zz");
  console.log("-----------------");
}
else
  console.log("홀수입니다.xxx");
  console.log("-----------------");



"use strict"

var age;

age = 15;
if (age < 8)
  console.log("유아")
else {
  if (age >= 8 && age < 14)
    console.log("어린이");
  else //<-- >= 14
    console.log("청소년 이상입니다.");
}

// if ~ else ~ 는 한그룹으로 취급한다.
age = 40;
if (age < 8)
  console.log("유아");
else// <-- >= 8
  if (age >= 8 && age < 14)
    console.log("어린이");
  else// <-- >=14
    console.log("청소년 이상입니다.");
console.log("-----------------------------");
age = 65;
if (age < 8)
  console.log("유아");
else // <-- age >= 8,
  if (age >= 8 && age < 14)
    console.log("어린이");
  else
    if(age >= 14 && age < 20)
      console.log("청소년");
    else
      if (age >= 20 && age < 65)
        console.log("성인");
      else
        console.log("노인");
console.log("-----------------------------");

age = 65;
if (age < 8)
  console.log("유아");
else if (age >= 8 && age < 14)
  console.log("어린이");
else if(age >= 14 && age < 20)
  console.log("청소년");
else if (age >= 20 && age < 65)
  console.log("성인");
else
  console.log("노인");
"use strict"

var age;

age = 50;
if(age > 19)
  if(age >= 65)
    console.log("노인");
else
  console.log("미성년");
console.log("------------");

age = 50;
if (age > 19){
  if (age >= 65)
    console.log("노인");
  }
else
  console.log("미성년");
console.log("------------");

"use strict"

var level = "팀장";

if (level == "사원"){
 console.log("워드 자격증 소지자");
 }

if (level == "개발자"){
  console.log("워드 자격증 소지자");
  console.log("정보처리기사 자격증 소지자");

}
if (level == "팀장"){
  console.log("워드 자격증 소지자");
  console.log("정보처리기사 자격증 소지자");
  console.log("석사 학위자");
}
console.log("------------------");
//switch문 사용

level = "팀장";

switch(level) {
case "팀장":
  console.log("석사 학위자");
case "개발자":
  console.log("정보처리기사 자격증 소지자");
case "사원":
  console.log("워드 자격증 소지자");
}

"use strict"

var level;
level = "팀장";

switch(level){
case "팀장":
  console.log("석사 학위자");
  break;
case "개발자":
  console.log("정보처리기사 자격증 소지자");
  break;
case "사원":
  console.log("워드 자격증 소지자");
}
"use strict"

var level;

level = "경비원";
switch(level){
case "팀장":
  console.log("석사 학위자");
  break;
case "개발자":
  console.log("정보처리기사 자격증 소지자");
  break;
case "사원":
  console.log("워드 자격증 소지자");
  break;
default:
  console.log("자격증이 필요 없습니다");
}
"use strict"

var a = NaN;
switch (isNaN(a)){
  case "문자열":
    console.log("문자열가능");
    break;
  case 1:
    console.log("숫자 가능");
    break;
  case 3.14195:
    console.log("부동소수점 가능");
    break;
  case true:
    console.log("boolean 값 가능");
    break;
  case undefined:
    console.log("undefined 가능");
    break;
  case null:
    console.log("null가능");
    break;
  case NaN:
    console.log("NaN?");
    break;
}
"use strict"

var count = 1
while (count <=10)
  console.log(count ++);
console.log("--------------------");

//while 중첩하기
var a = 2;
while (a <= 9){
  var b = 1;

  while (b <= 9){
    console.log( a + "*" + b + "=" + (a * b));
    b++;
  }
    a++;
}

"use constrict"

var count = 1;

do
  console.log(count++);
while (count <= 10);
console.log("---------------------");

do {
  console.log(count++);
  console.log(">");
} while (count <= 10);

"use strict"

for (var count = 1; count <= 10; count++) {
  console.log(count);
}
console.log("---------------------------");

var names = ["홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"];

for (var i = 0; i < names.length; i++){
  console.log(names[i]);
}
console.log("---------------------------");

"use strict"

var names = ["홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"];

for (var key in names){
  console.log(names[key]);
}

for (var i = 0; i < names.length; i++){
  console.log(names[i]);
}

var student = {
  name: "홍길동",
  age: 20,
  tel: "1111-1111",
  eail: "test@test.com"
};

for (var key in student){
  console.log(student[key]);
};

"use strict"

var names = ["홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"];

for (var index in names){
  console.log(names[index]);
}
console.log("------------------------------");

for (var value of names) {
  console.log(value);
}
*/
var prompt = require('prompt');

prompt.start();

prompt.get(['step']), function(err, result) {
  var step = parseInt(result.step);
   for (var i = 1; i <=9; i++)
    console.log(step + " * " + i + " = " + (step * i));
});
