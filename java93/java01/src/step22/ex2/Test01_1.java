/* JDBC 프로그래밍 II: DAO에서 출력 기능 제거, 데이터 처리만 하도록 변경
 * => memb 테이블의 값을 저장할 새로운 데이터 타입을 정의한다.
 * => 작업
 *    1) Member 클래스 정의
 *    2) MemberDao 클래스를 변경
 *    3) Member 사용 
 */
package step22.ex2;

import java.util.List;

public class Test01_1 {
  public static void main(String[] args) throws Exception{
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    MemberDao memberDao = new MemberDao(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    List<Member> list = memberDao.selectList();
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getTel(), m.getEmail());
    }
    System.out.println("-----------------------");
    
    /*
    System.out.println(memberDao.delete(59));
    System.out.println("-----------------------------------------");
    
    Member member = new Member();
    member.setName("홍길동104");
    member.setTel("1111-1111");
    member.setEmail("hong104@test.com");
    member.setPassword("1111");
 
    System.out.println(memberDao.insert(member));
    System.out.println("-----------------------------------------");
    */
   
    Member member = new Member();
    member.setNo(61); // 변경하려는 데이터의 mno이어야 한다.
    member.setName("홍길동 변경");
    member.setTel("1111-2221");
    member.setEmail("hong105@test.com");
    member.setPassword("1111");
    
    memberDao.update(member);
    System.out.println("-----------------------------------------");
    
    list = memberDao.selectList();
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getTel(), m.getEmail());
    }
    System.out.println("-----------------------------------------");

    /* 이 예제의 문제점?
     * => DAO 객체가 커넥션 객체 한 개를 완전히 독점한다.
     * => 만약 DAO 객체가 여러 개일 경우,
     *    각각의 DAO 객체가 커넥션을 한 개 독점하는 문제가 발생한다.
     *    즉 자원 낭비이다.
     * => 해결책?
     *    커넥션 객체가 필요할 떄 마다 빌려서 쓴다.
     *    다 쓴 다음에는 반납한다.
     */
  }
}
