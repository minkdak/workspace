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

public class ManagerDao {
  DBConnectionPool conPool;
  
  public ManagerDao(DBConnectionPool conPool) {
    this.conPool = conPool;
  }
  
  public List<Manager> selectNameList() throws Exception {
    Connection con = conPool.getConnection();
    
    try ( 
        Statement stmt = con.createStatement();
        
          ) {
        ArrayList<Manager> list = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery("select mr.mrno , m.name "
            + "from mgr mr inner join memb m on mr.mrno=m.mno "
            + "order by m.name asc");
            ) {
          Manager manager = null;
          while (rs.next()) { 
            Member member = new Member();
            manager = new Manager();
            manager.setNo(rs.getInt("mrno"));
            member.setName(rs.getString("name"));
            manager.setMember(member);
            
            list.add(manager);
          }
        }
        return list;
        
      } finally { // 다 쓴 커넥션을 반납하기 위해서
        // finally 블록은 try 블록을 벗어나기 전에 반드시 실행되는 블록이다. 
        // try 블록에서 return 문을 실행하기 전에 이 블록을 실행한다.
        conPool.returnConnection(con);
      }
  }
  
  /*
  public List<Manager> selectList(int pageNo, int pageSize) throws Exception {
    // 사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();

    try ( 
      PreparedStatement stmt = con.prepareStatement("select lno, titl, sdt, edt, thrs, pric from lect order by titl asc limit ?, ?");
        ) {
      stmt.setInt(1, (pageNo - 1) * pageSize);
      stmt.setInt(2, pageSize);
      
      ArrayList<Manager> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery();) {
        Manager Manager = null;
        while (rs.next()) { 
          Manager = new Manager();
          Manager.setNo(rs.getInt("lno"));
          Manager.setTitle(rs.getString("titl"));
          Manager.setStartDate(rs.getString("sdt"));
          Manager.setEndDate(rs.getString("edt"));
          Manager.setTotalHours(rs.getInt("thrs"));
          Manager.setPrice(rs.getInt("pric"));
          
          
          list.add(Manager);
        }
      }
      return list;
      
    } finally { // 다 쓴 커넥션을 반납하기 위해서
      // finally 블록은 try 블록을 벗어나기 전에 반드시 실행되는 블록이다. 
      // try 블록에서 return 문을 실행하기 전에 이 블록을 실행한다.
      conPool.returnConnection(con);
    }
  }
  
  public Manager selectOne(int no) throws Exception {
    // 사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();

    try ( 
      PreparedStatement stmt = con.prepareStatement("select lno, titl, dscp, sdt, edt, qty, thrs, pric from lect where lno=?");
        ) {
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery();) {
        if (!rs.next()) return null;
         
        Manager Manager = new Manager();
        Manager.setNo(rs.getInt("lno"));
        Manager.setTitle(rs.getString("titl"));
        Manager.setDescription(rs.getString("dscp"));
        Manager.setStartDate(rs.getString("sdt"));
        Manager.setEndDate(rs.getString("edt"));
        Manager.setQuantity(rs.getInt("qty"));
        Manager.setTotalHours(rs.getInt("thrs"));
        Manager.setPrice(rs.getInt("pric"));
        
        return Manager;
      }
      
    } finally { // 다 쓴 커넥션을 반납하기 위해서
      // finally 블록은 try 블록을 벗어나기 전에 반드시 실행되는 블록이다. 
      // try 블록에서 return 문을 실행하기 전에 이 블록을 실행한다.
      conPool.returnConnection(con);
    }
  }
  
  public int insert(Manager Manager) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "insert into memb(name,tel,email,pwd) values(?,?,?,password(?))");) {
      
      stmt.setString(1, Manager.getName());
      stmt.setString(2, Manager.getTel());
      stmt.setString(3, Manager.getEmail());
      stmt.setString(4, Manager.getPassword());
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "delete from memb where mno=?");) {
      
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  public int update(Manager Manager) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "update memb set name=?, tel=?, email=?, pwd=password(?) where mno=?");) {
      
      stmt.setString(1, Manager.getName());
      stmt.setString(2, Manager.getTel());
      stmt.setString(3, Manager.getEmail());
      stmt.setString(4, Manager.getPassword());
      stmt.setInt(5, Manager.getNo());
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
  }
  */
  
  
}
