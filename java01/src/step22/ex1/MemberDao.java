/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 */
package step22.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDao {
  Connection con;
  // 인스턴스를 호출할 때 자동으로 생성되는 것으로,
  // 인스턴스를 쓰기 전에 최소한의 유효한 값들로 셋팅할 수 있도록 기회를 갖게 하는 것을 말한다. 
  public MemberDao(String driver, String url, String username, String password) 
    throws Exception {

    Class.forName(driver);
    con = DriverManager.getConnection(url, username, password);
  }
  
  
  public void selectList() throws Exception {
    try ( // 이 괄호 안에 선언하는 변수는 오직 java.lang.AutoCloseable 구현체 만이 가능하다.
      
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select mno, name, tel, email from memb");
      ) {
        while (rs.next()) { 
          System.out.printf("%d, %s, %s, %s\n", 
              rs.getInt("mno"), 
              rs.getString("name"), 
              rs.getString("tel"), 
              rs.getString("email"));
        }
        
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
  
  public void insert(String name, String tel, String email, String password) throws Exception {
    try (
        PreparedStatement stmt = con.prepareStatement("insert into memb(name,tel,email,pwd)values(?,?,?,password(?))");
        ) {
        stmt.setString(1, name);
        stmt.setString(2, tel);
        stmt.setString(3, email);
        stmt.setString(4, password);
        
        int count = stmt.executeUpdate();
        } catch (Exception e) {
          e.printStackTrace();
        }
  }
  
  public void delete(int no) throws Exception {
    try (
        PreparedStatement stmt = con.prepareStatement("delete from memb where mno=?");
        ) {
          stmt.setInt(1, no);
          
          int count = stmt.executeUpdate();
          
          System.out.println(count);
        } catch (Exception e) {
          e.printStackTrace();
        }
  }
  
  public void update(int no, String name, String tel, String email, String password) throws Exception {
    try (
        PreparedStatement stmt = con.prepareStatement(
            "update memb set name=?, email=?, tel=?, pwd=password(?) where mno=?");
        ) {
        stmt.setString(1, name);
        stmt.setString(2, tel);
        stmt.setString(3, email);
        stmt.setString(4, password);
        stmt.setInt(5, no);
        
        int count = stmt.executeUpdate();
        System.out.println(count);
        
        } catch (Exception e) {
          e.printStackTrace();
        }
  }  
}
