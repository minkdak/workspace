/* JDBC 프로그래밍: Statement 객체
 * => SQL문 중에서 DBMS에 전달하고, 그 결과를 다루는 객체를 리턴한다.
 * => Connection 객체로부터 얻는다.
 * => SELECT 문을 실행한 경우, 그 결과를 다루는 객체를 리턴한다.
 * 
 * java.sql 패키지의 주요 인터페이스(규칙)
 * 1) java.sql.Driver ( => com.mysql.jdbc.Driver 클래스
 *   => JDBC Driver 정보를 제공하는 기능
 *   => DBMS와의 연결을 관리하는 객체를 리턴하는 기능
 * 2) java.sql.Connection (=> com.mysql.jdbc.ConnecctionImpl 클래스) =>: 위 클래스에서 connect하게되면 이 객체 리턴
 *    => DBMS와 연결을 수행하는 긴으
 *    => DBMS에 SQl을 전달할 객체를 리턴하는 기능
 * 3) java.sql.Statement ( => com.mysql.jdbc.StatementImpl 클래스)
 *    => SQL을 MySQL 형식에 맞춰서 변환한 다음 서버에 보내는 기능.
 *    => 서버가 보낸 결과를 다룰 객체를 리턴하는 기능.
 *    => executeQuery() : Select 문 실행
 *    => executeUpdate() : INSERT, UPDATE, DELETE 등을 DML DDL 명령문 실행
 *                         SELECT, INSERT, UPDATE, DELETE 등 모든 SQL 명령문 실행가능
 * 4) java.sql.ResultSet ( => com.mysql.jdbc.ResultSetlImpl) 클래스)
 *    => DBMS 서버에서 SELECT를 실행한 후 생성된 결과를 가져오는 기능.
 *    => next() : 
 *            서버에서 한 개의 레코드를 가져온다.
 *            정상적으로 가져왔으면 treu를 리턴,
 *            가져올 레코드가 없으면 false를 리턴한다.
 *    => getXxx() : 
 *            서버에서 가져온 레코드의 컬럼 값을 꺼내는 메서드.
 *            컬럼의 타입에 따라 호출하는 메서드가 다르다.
 *            숫자 -> getInt()
 *            문자열 -> getString()
 *            날짜 -> getDate()
 *            등... 
 *
 * 자원의 해제
 *   => 파일 I/O(HDD)나 소켓(랜카드)이나 DBMS API(랜카드와 연결된 서버) 처럼 컴퓨터에 붙어 있는 장비를 다룰 때는
 *      항상 사용한 다음에는 다른 프로그램이 사용할 수 있도록 자원을 해제해야 한다.
 */
package step20;

import java.sql.DriverManager;

public class Test02_1 {
  public static void main(String[] args) throws Exception{
    // 1) MySQL JDBC 드라이버 관리 객체 생성
    //    => 이 객체가 있어야만 MySQL DBMS에 연결할 수 있다.
    com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();
    
    // 2) MySQL JDBC 드라이버를 "드라이버 관리자"에 등록한다.
    //    => 반드시 java.sql.Driver 규칙에 따라 만든 클래스여야한다.
    DriverManager.registerDriver(mysqlDriver); // 인풋 스트림 아웃풋 스트림 안됨.
    
    // 3) 드라이버 관리자를 통해 DBMS와 연결한다.
    //    => 직접 MySQL 드라이버를 사용하지 않고,
    //       이렇게 DriverManager 클래스를 통해 우회하여 DBMS와 연결한다.
    //    => 이렇게 우회하는 이유? 특정 DBMS에 종속되지 않기 위해서.
    //       자바 코드를 작성할 때 특정 DBMS에서만 유효한 코드를 작성하게 되면,
    //       그 DBMS에 종속되게 되고 유지보수가 힘들어진다.
    //    => DriverManager의 getConnection()을 호출하여 DBMS와 연결한다.
    //       리턴 값은 DBMS와의 연결 정보를 갖고 있는 
    //       java.sql.Connection 규격에 따라 만든 객체이다.
    java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/webappdb", /* 연결할 DBMS와 데이터베이스 정보*/ 
        "webapp", /* 사용자 아이디 */
        "1111"); /* 사용자 암호 */
    
    // 4) SQL을 실행할 Statement 객체 얻기
    //    => java.sql.Statement 규격에 따라 만든 객체를 리턴한다.
    java.sql.Statement stmt = con.createStatement();
    System.out.println("DBMS와 연결되었습니다.");
    
    // 5) SELECT SQL문을 DBMS에 보낸다.
    //    => Statement 객체가 SELECT 문을 DBMS에 보내는 일을 한다.
    //    => SQL을 문자열 그대로 보내는 것이 아니라,
    //       DBMS가 처리하기 쉬운 형태로 변환(컴파일)하여
    //       그 변환된 SQL을 DBMS에 보낸다.
    //    => 물론 DBMS 마다 그 형식이 다를 것이다.
    //       변환하는 일은 각 DBMS의 Statement 객체를 할 것이다.
    //       Statement 객체를 할 것이다.
    //    => 주요함수
    //       executeQuery() : select 문을 보낼 때
    //       executeUpdate() : insert, update, delete 등 기타 SQL을 보낼 때
    //    => executeQuery()의 리턴 값
    //       서버가 SELECT를 실행한 후 준비한 결과 값을 가져오는 도구를 리턴한다.
    //    => 그 도구는 java.sql.ResultSet 규격에 따라 만든 객체이다.
    java.sql.ResultSet rs= stmt.executeQuery("select mno, name, tel, email from memb");
    // 문자열 그대로 DBMS 서버에 보내는게 아니라 DBMS에서 원하는 형식으로 변환해서 보낸다..(parse)
    // ResultSet 리턴ㄷ
    
    // 6) ResultSet 객체를 통해 서버에 결과를 한 개씩 가져온다.
    //  => 한꺼번에 다 가져오는 것이 아니라, 한 개씩 가져온다.
    //  => next() : 서버에서 결과를 한 개 가져온다.
    while (rs.next()) {
      // 서버에서 가져온 한 개의 레코드 값은 ResultSet 객체에 보관되어 있다.
      // 꺼내보자!
      System.out.printf("%d, %s, %s, %s\n", 
          rs.getInt("mno"), rs.getString("name"), rs.getString("tel"), rs.getString("email"));
    }
    
    // 7) 지금까지 사용한 JDBC 관련 객체의 자원을 해제한다.
    //  => 생성된 역순으로 자원을 해제해야 한다.
    //  => ResultSet을 더이상 사용하지 않으면 자원을 해제하라!
    rs.close();
    //  => Statement를 더이상 사용하지 않으면 자원을 해제하라!
    stmt.close();
    //  => DBMS와 연결을 끊고 싶다면 Connection의 close()를 호출하라!
    con.close();
    
    // => DriverManager는 close() 메서드가 없다
  }
}
