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

public class LectureDao {
  DBConnectionPool conPool;
  
  public LectureDao(DBConnectionPool conPool) {
    this.conPool = conPool;
  }
  
  public List<Lecture> selectList(int pageNo, int pageSize) throws Exception {
    // 사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();

    try ( 
      PreparedStatement stmt = con.prepareStatement("select lno, titl, sdt, edt, thrs, pric from lect order by titl asc limit ?, ?");
        ) {
      stmt.setInt(1, (pageNo - 1) * pageSize);
      stmt.setInt(2, pageSize);
      
      ArrayList<Lecture> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery();) {
        Lecture Lecture = null;
        while (rs.next()) { 
          Lecture = new Lecture();
          Lecture.setNo(rs.getInt("lno"));
          Lecture.setTitle(rs.getString("titl"));
          Lecture.setStartDate(rs.getString("sdt"));
          Lecture.setEndDate(rs.getString("edt"));
          Lecture.setTotalHours(rs.getInt("thrs"));
          Lecture.setPrice(rs.getInt("pric"));
          
          
          list.add(Lecture);
        }
      }
      return list;
      
    } finally { // 다 쓴 커넥션을 반납하기 위해서
      // finally 블록은 try 블록을 벗어나기 전에 반드시 실행되는 블록이다. 
      // try 블록에서 return 문을 실행하기 전에 이 블록을 실행한다.
      conPool.returnConnection(con);
    }
  }
  
  public Lecture selectOne(int no) throws Exception {
    // 사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();

    try ( 
      PreparedStatement stmt = con.prepareStatement("select lno, crmno, mrno, titl, dscp, sdt, edt, qty, thrs, pric from lect where lno=?");
        ) {
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery();) {
        if (!rs.next()) return null;
         
        Lecture Lecture = new Lecture();
        Lecture.setNo(rs.getInt("lno"));
        Lecture.setCrmno(rs.getInt("crmno"));
        Lecture.setMrno(rs.getInt("mrno"));
        Lecture.setTitle(rs.getString("titl"));
        Lecture.setDescription(rs.getString("dscp"));
        Lecture.setStartDate(rs.getString("sdt"));
        Lecture.setEndDate(rs.getString("edt"));
        Lecture.setQuantity(rs.getInt("qty"));
        Lecture.setTotalHours(rs.getInt("thrs"));
        Lecture.setPrice(rs.getInt("pric"));
        
        return Lecture;
      }
      
    } finally { // 다 쓴 커넥션을 반납하기 위해서
      // finally 블록은 try 블록을 벗어나기 전에 반드시 실행되는 블록이다. 
      // try 블록에서 return 문을 실행하기 전에 이 블록을 실행한다.
      conPool.returnConnection(con);
    }
  }
  
  public int insert(Lecture lecture) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "insert into lect(crmno, mrno, titl, dscp, sdt, edt, qty, thrs, pric) values(?,?,?,?,?,?,?,?,?)");) {
      
      stmt.setInt(1, lecture.getCrmno());
      stmt.setInt(2, lecture.getMrno());
      stmt.setString(3, lecture.getTitle());
      stmt.setString(4, lecture.getDescription());
      stmt.setString(5, lecture.getStartDate());
      stmt.setString(6, lecture.getEndDate());
      stmt.setInt(7, lecture.getQuantity());
      stmt.setInt(8, lecture.getTotalHours());
      stmt.setInt(9, lecture.getPrice());
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "delete from lect where lno=?");) {
      
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  
  public int update(Lecture lecture) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "update lect set crmno=?, mrno=?, titl=?, dscp=?, sdt=?, edt=?, qty=?, thrs=?, pric=? where lno=?");) {
      
      stmt.setInt(1, lecture.getCrmno());
      stmt.setInt(2, lecture.getMrno());
      stmt.setString(3, lecture.getTitle());
      stmt.setString(4, lecture.getDescription());
      stmt.setString(5, lecture.getStartDate());
      stmt.setString(6, lecture.getEndDate());
      stmt.setInt(7, lecture.getQuantity());
      stmt.setInt(8, lecture.getTotalHours());
      stmt.setInt(9, lecture.getPrice());
      stmt.setInt(10, lecture.getNo());
      
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  
  
}
