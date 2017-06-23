/* JDBC 프로그래밍: try ~ catch ~ 를 이용하여 자원해제시키기 I
 * => finally 블록을 이용하여 자원을 해제한다.
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test03_1 {
  public static void main(String[] args) throws Exception{
    
    Connection con = null; // finall에서 사용하려면 이렇게 밖에서 import해서 변수 정의
    Statement stmt  = null;
    ResultSet rs = null;
    
    try {
      com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();
      
      DriverManager.registerDriver(mysqlDriver); // 인풋 스트림 아웃풋 스트림 안됨.
      
    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/webappdb", 
        "webapp", 
        "1111"); 
    
    stmt = con.createStatement();

    rs= stmt.executeQuery("select * from memb");
    
      while (rs.next()) {
        System.out.printf("%d, %s, %s, %s\n", 
            rs.getInt("mno"), 
            rs.getString("name"), 
            rs.getString("tel"), 
            rs.getString("email"));
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {rs.close();} catch (Exception e) {} 
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
