/* 변수 선언 - 기본 데이터 타입의 리터럴(literal) 표현
 */
package step01;

public class Test02 {

  public static void main(String[] args) {
    // 기본 데이터 타입
    //1) 정수 데이터 형
    System.out.println('가'); // 문자 값. 2byte 크기. 문자열이 아니다 문자이다. (왜 정수 데이터 형인가?)
    System.out.println(100); // 정수 값. 4byte 크기 정수
    System.out.println(100L); // 정수 값. 8byte 크기 (L의 뜻)
    
    //2) 부동소수점 데이터 형
    System.out.println(3.14f); // 부동소수점 값. 4byte 크기. (차이점?)
    System.out.println(3.14); // 부동소수점 값. 8byte 크기.
    
    //3) 논리 데이터 형
    System.out.println(true); // 논리 값. 4byte 크기.
    
    //4) 객체 데이터 형
    System.out.println("문자열"); // 문자열
  }

}

/* 리터럴(literal)?
 * => 코드에서 값을 표현한 것. // 사전적 의미는 글자 그대로의 
 * => 
 */