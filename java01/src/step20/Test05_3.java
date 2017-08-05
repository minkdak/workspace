/* JDBC 프로그래밍: PrentStatment 객체 사용 후
 * => 더하기 연산자를 사용하여 SQL문을 만드는 대신,
 *    in-parameter '?'를 사용하여 SQL문을 만든다.
 *    
 * => Statement와 PreparedStatement
 * 1) 보안
 *    Statement
 *    - SQL사용자가 입력한 값을 가지고 SQL문을 만들기 때문에 보안에 취약하다.
 *    - 즉 악의적으로 SQL의 일부를 포함하는 값을 입력할 수 있다.
 *               
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test05_3 {
  public static void main(String[] args) throws SQLException{
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    // 이렇게 사용자가 값을 입력할 때 SQL 코드를 삽입할 수 있다.
    String email = "hong102@test.com' or email like('hong10%') or email='ㅋㅋ";
    
    try {
    Class.forName(jdbcDriver);
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    try (
    Connection con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    Statement stmt = con.createStatement();// 옛날방식 create
    ) {
    // + 연산자를 이용하여 SQL문을 만드는 경우 값에 교묘하게 포함된 SQL 코드를
    // 제거하지 못한다.
    int count = stmt.executeUpdate("delete from memb where email='" + email + "'");    
    System.out.println(count);
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
