/* JDBC 프로그래밍: Statement 객체 - INSERT 실행
 * => Statement.executeUpdate()
 *    - INSERT, UPDATE, DELETE 등 DML, DDL 을 실행한다.
 *      리턴 값은 명령어의 영향을 받은 레코드 갯수이다.
 *      예) INSERT -> 등록된 레코드 개수,
 *          UPDATE -> 변경된 레코드 개수,
 *          DELETE -> 삭제된 레코드 개수 
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test05_1 {
  public static void main(String[] args) throws Exception{
    // 원래는 값을 JVM 아규먼트나 프로그램 아규먼트 등 외부로부터 받아야 하지만,
    // 테스트를 원활하게 하기 위해서 변수에 값을 담아 놓자!
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    String name = "홍길동103";
    String email = "hong103@test.com";
    String tel = "1111-1111";
    String password = "1111";
    
    
    try {
    Class.forName(jdbcDriver);
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    try (
    Connection con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    Statement stmt = con.createStatement();
    ) {
    int count = stmt.executeUpdate("insert into memb(name,tel,email,pwd) values('" + 
        name + "', '"+ 
        tel + "', '" + 
        email + "', password('" + 
        password + "'))");
    
    System.out.println(count);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
