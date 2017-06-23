/* 다형성 - 다형적 변수와 형변화
 * => 인스턴스 주소를 원래의 타입으로 변환할 수 있다.
 */
package step10.ex2;

public class Test05 {
  public static void main(String[] args) {
    Member m = new FreeStudent(); // name/id/password/email/tel/schoolname/grade/account/?/working
    // 여기 들어있는 것도 200번지
    m.name = "홍길동";
    m.id = "hong";
    m.password = "1111";
    m.email = "hong@test.com";
    m.tel = "1111";
    /* 아래 필드는 Member 클래스에 선언된 것이 아니기 떄문에 컴파일 오류가 난다.
    m.schoolname = "비트대학교"; // Error. 분명히 있는데 안된다. 왤까? 컴파일러는 융통성 없이 원칙대로한다.
    m.grade = 4;
    m.account ="111-11-1111-111";
    m.bank = "비트은행";
    m.working = true;
    */
    
    FreeStudent s = (FreeStudent)m; // 여기 s에 들어있는것도 200번지 
    // 이렇게하는 이유는 컴파일러에게 정확히 전달하기 위해서
    s.schoolName = "비트대학교";
    s.grade = 4;
    s.account = "111-11-1111-111";
    s.bank = "비트은행";
    s.working = true;
    
    System.out.println(s.name);
    System.out.println(s.id);
    System.out.println(s.password);
    System.out.println(s.email);
    System.out.println(s.tel);
    System.out.println(s.schoolName);
    System.out.println(s.grade);
    System.out.println(s.account);
    System.out.println(s.bank);
    System.out.println(s.working);
  }
}
