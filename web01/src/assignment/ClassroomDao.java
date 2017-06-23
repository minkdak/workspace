/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *    사용한 후에는 반납한다.
 * => DAO는 커넥션을 관리하지 않는다.
 */
package assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDao {
  DBConnectionPool conPool;
  
  public ClassroomDao(DBConnectionPool conPool) {
    this.conPool = conPool;
  }
  
  public List<Classroom> selectNameList() throws Exception {
    Connection con = conPool.getConnection();
    
    try ( 
        Statement stmt = con.createStatement();
        
          ) {
        ArrayList<Classroom> list = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery("select crmno, name from croom"
            + " order by name asc");
            ) {
          Classroom classroom = null;
          while (rs.next()) { 
            classroom = new Classroom();
            classroom.setNo(rs.getInt("crmno"));
            classroom.setName(rs.getString("name"));
            
            
            list.add(classroom);
          }
        }
        return list;
        
      } finally { 
        conPool.returnConnection(con);
      }
  }
  
}
