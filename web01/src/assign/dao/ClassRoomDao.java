/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *    사용한 후에는 반납한다.
 */
package assign.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assign.domain.ClassRoom;
import assign.util.DBConnectionPool;


public class ClassRoomDao {
  DBConnectionPool conPool;
  
  public ClassRoomDao(DBConnectionPool conPool) {
    this.conPool = conPool;
  }
  
  public List<ClassRoom> selectList(int pageNo, int pageSize) throws Exception {
    Connection con = conPool.getConnection();
    
    try ( 
        PreparedStatement stmt = con.prepareStatement("select crmno, name from croom limit ?, ?");) {
      
        stmt.setInt(1, (pageNo - 1) * pageSize /* 시작 인덱스 */);
        stmt.setInt(2, pageSize /* 꺼낼 레코드 수 */); 
        
        ArrayList<ClassRoom> list = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery();) {
        ClassRoom croom = null;
        
        while (rs.next()) { 
          croom = new ClassRoom();
          croom.setNo(rs.getInt("crmno")); 
          croom.setName(rs.getString("name")); 
              
          list.add(croom);
          }
        }
        return list;
        
      } finally {
        conPool.returnConnection(con);
      }

  }
  
  public ClassRoom selectOne(int no) throws Exception {
    Connection con = conPool.getConnection();
    
    try ( 
        PreparedStatement stmt = con.prepareStatement(
            "select crmno, name from croom where crmno=?");) {
      
        stmt.setInt(1, no);
        
        try (ResultSet rs = stmt.executeQuery();) {
        
        if (!rs.next())  
          return null;
          
        ClassRoom croom= new ClassRoom();
        croom.setNo(rs.getInt("crmno")); 
        croom.setName(rs.getString("name")); 
        return croom;

        }
      } finally {
        conPool.returnConnection(con);
      }

  }
  public int insert(ClassRoom classroom) throws Exception{
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "insert into croom(name) values(?)");) {
      
        stmt.setString(1, classroom.getName());
        
        return stmt.executeUpdate();
        } finally {  
       conPool.returnConnection(con);
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "delete from croom where crmno=?");) {
          stmt.setInt(1, no);
          return stmt.executeUpdate();
          // 데이터를 삭제할 넘버를 받아서 sql문에 인파라미터에 그 숫자를 적재하고 delete하고 delete된 갯수를 리턴한다.
          
        } finally {  
          conPool.returnConnection(con);
        }
  }
  
  public int update(ClassRoom croom) throws Exception {
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "update croom set name=? where crmno=?");) {
        stmt.setString(1, croom.getName());
        stmt.setInt(2, croom.getNo());
        
        return stmt.executeUpdate();

        
        } finally {  
          conPool.returnConnection(con);
        }
    
  }  
}
