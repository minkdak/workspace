/* nested class: static nested class II
 */
package step13;

public class test02_3 {
  // static nested class로 정의된 상수 값 사용하기
  static class Member {
    String name;
    String tel;
    int schoolLevel;
    int userType;
    int working;
    int language;
  }
  
  public static void main(String[] args) { // static 선언하기 전.
    // static nested 클래스 대신 일반 클래스로 만든 상수 값을 사용해 보자!
    Member m = new Member();
    m.name = "홍길동";
    m.tel = "1111-1111";
    m.schoolLevel = Constants.school.BACHELOR;
    m.userType = Constants.userType.TEACHER;
    m.working = Constants.work.NOT_WORKING;
    m.language = Constants.lang.JAVA;
  }
}
