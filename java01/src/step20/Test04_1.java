/* JDBC 프로그래밍: 특정 DBMS의 드라이버 클래스에 종속되는 것을 막기
 * => 기존 코드에서는 java.sql.Driver 구현체(이 규칙에 따라 만든 클래스)
 *    인스턴스를 만들기 위해 직접 클래스 명을 언급하였다.
 *    예) com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
 * => 이렇게 하면 코드가 특정 DBMS에 종속되는 문제가 발생한다.
 *    즉 다른 DBMS에 접속하려면  코드를 변경한 후 컴파일 해야하는 번거로움이 발생한다.
 * => 해결 방법!
 *    java.sql.Driver 구현체의 이름을 변수로 받아서 처리한다.
 * => 실행하는 법
 *    프롬프트> java -cp bin:xxx.jar -Djdbc.driver=com.mysql.jdbc.Driver step20.Test04_1
 * => 이클립스에서 실행하는 법
 *    1) 일단 그냥 실행한다. 그러면 실행 정보가 이클립스에 기록된다.
 *    2) Run > Run Configurations... >
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test04_1 {
  public static void main(String[] args) throws Exception{
    
    Connection con = null; // finall에서 사용하려면 이렇게 밖에서 import해서 변수 정의
    Statement stmt  = null;
    ResultSet rs = null;
    
    try {
      // com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();
      // DriverManager.registerDriver(mysqlDriver); // 인풋 스트림 아웃풋 스트림 안됨.
      
      // JVM 아규먼트로 java.sql.Driver 구현체의 이름을 받는다.
      String driverClassName = System.getProperty("jdbc.driver");
      
      
      // 아규먼트로 넘겨준 문자열로 지정된 클래스를 찾아 로딩한다.
      // => Class.forName("com.mysql.jdbc.Driver")라면,
      //    com.mysql.jdbc.Driver 클래스를 찾아서 로딩한다.
      // => java.sql.Driver 구현 클래스(=com.mysql.jdbc.Driver)를 메모리(Method Area)에 로딩한다.
      // => 객체를 만들어서 DriverManager에 등록하지 않아도 자동으로 인식한다.
      Class.forName(driverClassName);
      /* 참고!
       * 클래스가 로딩되는 경우, (조건: 클래스가 로딩되어 있지 않을 때)
       * 1) 인스턴스를 만들 때
       * 2) 스태틱 멤버(변수나 메서드)를 사용할 떄
       * 3) Class.forName()을 호출할 때
       */
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
