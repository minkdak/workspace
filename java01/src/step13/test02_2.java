/* nested class: static nested class II
 */
package step13;

public class test02_2 {
  // static nested class를 주로 사용하는 경우
  // => 계층적 구조로 상수 값을 관리하고 싶을 때
  //    특히 안드로이드 프로그래밍에서 ID 값을 관리하기 위해 이 문법을 사용한다.
  static class Member {
    String name;
    String tel;
    int schoolLevel;
    int userType;
    int working;
    int language;
  }
  
  
  // static method
  public static void main(String[] args) { // static 선언하기 전.
    // static nested 클래스 대신 일반 클래스로 만든 상수 값을 사용해 보자!
    Member m = new Member();
    m.name = "홍길동";
    m.tel = "1111-1111";
    m.schoolLevel = CSCHOOL.BACHELOR;
    m.userType = CUserType.TEACHER;
    m.language = CLanguage.JAVA;
  }
}
