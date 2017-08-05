/* JDBC 프로그래밍: try ~ catch ~ 를 이용하여 자원해제시키기 II
 * => try () 블록에서 자동으로 자원해제시키기
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test03_2 {
  public static void main(String[] args) throws Exception{
    
    try {
    com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();
    DriverManager.registerDriver(mysqlDriver);
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
    
    try(
     Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/webappdb", 
        "webapp", 
        "1111"); 
    
    Statement stmt = con.createStatement();

    ResultSet rs= stmt.executeQuery("select * from memb");
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
}
