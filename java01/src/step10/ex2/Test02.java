/* 다형성 - 다형적 변수 II
 * => 왜 수퍼 클래스의 인스턴스를 저장할 수 없는가?
 */
package step10.ex2;

public class Test02 {
  public static void main(String[] args) {
    // Member m = new Member(); OK
    // new Member()로 찾아가면
    // name/id/password/email/tel 이 5개를 사용할 수 있다.
    
    // Member m = new Student(); //OK
    // new Student()로 찾아가면 Member 변수 + Student변수
    // name/id/password/email/tel 이 5개를 사용할 수 있다.
    // +schoolName/grade/
    
    Member m = new FreeStudent(); //OK
    // new Student()로 찾아가면 Member 변수 + Student변수 + FreeStudent변수
    m.name = "홍길동";
    m.id = "hong";
    m.password = "1111";
    m.tel = "1111-1111";
    m.email = "hong@test.com";
    
    // Student s = new Student(); //OK // Member 변수 + Student 변수
    Student s = new FreeStudent(); // OK // Member 변수 + Student 변수 + FreeStudent 변수
    //Student s = new Member(); // Error// Member 변수 
    // 상위 클래스의 인스턴스에는 이 클래스가 원하는 변수나 메서드가 없기 때문에 에러
    
    s.name = "홍길동";
    s.id = "hong";
    s.password = "1111";
    s.tel = "1111-1111";
    s.email = "hong@test.com";
    s.schoolName = "비트대학교";
    s.grade = 4;
  }
  
}
