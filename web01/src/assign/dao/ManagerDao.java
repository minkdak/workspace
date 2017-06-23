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

import assign.domain.Manager;
import assign.util.DBConnectionPool;

public class ManagerDao {
  DBConnectionPool conPool;
  
  public ManagerDao(DBConnectionPool conPool) {
    this.conPool = conPool;
  }
  
  public List<Manager> selectList() throws Exception {
    Connection con = conPool.getConnection();
    
    try ( 
        PreparedStatement stmt = con.prepareStatement(
            "select mr.mrno, m.name, mr.posi, mr.fax, mr.path from mgr mr inner join memb m on mr.mrno=m.mno");) {
      
/*        stmt.setInt(1, (pageNo - 1) * pageSize  시작 인덱스 );
        stmt.setInt(2, pageSize  꺼낼 레코드 수 ); */
        
        ArrayList<Manager> list = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery();) {
        Manager manager = null;
        
        while (rs.next()) { 
          manager = new Manager();
          manager.setNo(rs.getInt("mrno")); 
          manager.setName(rs.getString("name"));
          manager.setPosi(rs.getString("posi")); 
          manager.setFax(rs.getString("fax"));
          manager.setPath(rs.getString("path"));
              
          list.add(manager);
          }
        }
        return list;
        
      } finally {
        conPool.returnConnection(con);
      }

  }
  
  public Manager selectOne(int no) throws Exception {
    Connection con = conPool.getConnection();
    
    try ( 
        PreparedStatement stmt = con.prepareStatement(
            "select m.name, mr.posi, mr.fax, mr.path from mgr mr inner join memb m on mr.mrno=m.mno where mrno=?");) {
      
        stmt.setInt(1, no);
        
        try (ResultSet rs = stmt.executeQuery();) {
        
        if (!rs.next())  
          return null;
          
        Manager manager= new Manager();
        manager.setNo(rs.getInt("mrno")); 
        manager.setName(rs.getString("name")); 
        manager.setPosi(rs.getString("posi")); 
        manager.setFax(rs.getString("fax"));
        manager.setPath(rs.getString("path"));
        return manager;

        }
      } finally {
        conPool.returnConnection(con);
      }

  }
  public int insert(Manager manager) throws Exception{
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "insert into mgr(mrno,posi,fax,path) values(?,?,?,?)");) {
      
        stmt.setString(1, manager.getName());
        stmt.setString(2, manager.getPosi());
        stmt.setString(3, manager.getFax());
        stmt.setString(4, manager.getPath());
        
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
  
  public int update(Manager croom) throws Exception {
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
