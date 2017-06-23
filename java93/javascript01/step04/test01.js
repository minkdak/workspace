/* 주제: 함수 - 정의와 사용
 - 함수? 반복적으로 사용할 명령어들을 기능 단위로 묶어 놓은 것.
 - 문법
 1) 함수 정의
 function 함수명(변수, 변수, 변수,...) {명령어들...}
- 변수 = 파라미터
  외부에서 값을 받는 변수를 "파라미터"라 부른다.
- 파라미터 변수를 선언할 때는 var, let, const를 붙이지 않는다.
  붙이면 오류!

 2) 함수 사용 = "함수 호출(function call)"
  함수명(값, 값, 값, ...);
- 값  = "아규먼트(argument)"
  함수를 호출할 때 넘겨주는 값을 "아규먼트"라 부른다.

그러나 실무에서는 파라미터나 아규먼트를 구분하지 않고 사용하고 있다.
*/
//함수정의 : 화면에 구분선을 출력하는 기능을 수행한다.
function hr() {
  console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
}

var a = 10;
if((a % 2) == 0)
  console.log("짝수입니다.");
hr(); // hr() 함수를 사용 = "hr() 호출"

a = 11;
if((a % 2) != 0)
  console.log("홀수입니다.");
hr();
