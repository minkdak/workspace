/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 */
package step22.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
  Connection con;
  public MemberDao(String driver, String url, String username, String password) 
    throws Exception {

    Class.forName(driver);
    con = DriverManager.getConnection(url, username, password);
  }
  
  // ArrayList 는 list라는 규칙에 따라서 만든 자식 클래스이다. 그래서 List를 던지면 모든 리스트 클래스를 리턴할 수 있다.
  public List<Member> selectList() throws Exception {
    try ( // 이 괄호 안에 선언하는 변수는 오직 java.lang.AutoCloseable 구현체 만이 가능하다.
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select mno, name, tel, email from memb");) {
      
        ArrayList<Member> list = new ArrayList<>();
        Member member = null;
        while (rs.next()) { 
          member = new Member();
          member.setNo(rs.getInt("mno")); 
          member.setName(rs.getString("name")); 
          member.setTel(rs.getString("tel"));
          member.setEmail(rs.getString("email"));
              
          list.add(member);
        }
        return list;
      } /* catch (Exception e) { // 예외가 발생하면 단순히 호출자에게 보고하기 때문에,
        throw e;                 // 여기서는 catch 블록이 필요 없다.
        */
  }
  
  public int insert(Member member) throws Exception{
    try (
        PreparedStatement stmt = con.prepareStatement(
            "insert into memb(name,tel,email,pwd) values(?,?,?,password(?))");) {
      
        stmt.setString(1, member.getName());
        stmt.setString(2, member.getTel());
        stmt.setString(3, member.getEmail());
        stmt.setString(4, member.getPassword());
        
        return stmt.executeUpdate();
        }
  }
  
  public int delete(int no) throws Exception {
    try (
        PreparedStatement stmt = con.prepareStatement(
            "delete from memb where mno=?");) {
          stmt.setInt(1, no);
          return stmt.executeUpdate();
          // 데이터를 삭제할 넘버를 받아서 sql문에 인파라미터에 그 숫자를 적재하고 delete하고 delete된 갯수를 리턴한다.
          
        }
  }
  
  public int update(Member member) throws Exception {
    try (
        PreparedStatement stmt = con.prepareStatement(
            "update memb set name=?, tel=?, email=?, pwd=password(?) where mno=?");) {
        stmt.setString(1, member.getName());
        stmt.setString(2, member.getTel());
        stmt.setString(3, member.getEmail());
        stmt.setString(4, member.getPassword());
        stmt.setInt(5, member.getNo());
        
        return stmt.executeUpdate();

        
        }
  }  
}
