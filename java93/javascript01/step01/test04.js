/* 주제: 변수 선언과 strict 모드
- 변수를 사용하기 전에 변수를 선언하도록 강요한다.
- 이유? 변수의 오용을 막기 위해서 엄격히 변수를 선언한 다음에 쓰도록 유도한다.
- 문법
"use strict"   <--- 문자열을 명령어 첫 줄에 선언하면 된다.

 */
 "use strict" // 반드시 명령어 첫줄에 선언해야 한다.
name = "홍길동";
 //"use strict" // 
age = 30;
console.log(name, age);
