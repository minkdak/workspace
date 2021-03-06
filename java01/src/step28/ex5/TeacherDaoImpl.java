package step28.ex5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherDaoImpl implements TeacherDao{

  @Autowired SqlSessionFactory sqlSessionFactory;
  
  public List<Teacher> selectList(int pageNo, int pageSize) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
    HashMap<String, Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    
    return sqlSession.selectList("step28.ex4.TeacherDao.selectList", valueMap);
    } finally {
      sqlSession.close();
    }
  }

  
  public List<String> selectPhotoList(int teacherNo) throws Exception {
    /*
    Connection con = conPool.getConnection();
    
    try ( 
        PreparedStatement stmt = con.prepareStatement(
            "select path from tch_phot where tno=?");) {
      
        stmt.setInt(1, teacherNo);
        
        ArrayList<String> list = new ArrayList<>();
        
        try (ResultSet rs = stmt.executeQuery();) {
        
        while (rs.next()) { 
          list.add(rs.getString("path"));
          }
        }
        return list;
        
      } finally {
        conPool.returnConnection(con);
      }
*/
    return null;
  }
  public Teacher selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {    
      return sqlSession.selectOne("step28.ex4.TeacherDao.selectOne", no);
      
    } finally {
      sqlSession.close();
    }
    /*
    Connection con = conPool.getConnection();
    try ( 
        PreparedStatement stmt = con.prepareStatement(
            "select m.mno, m.name, m.tel, m.email, t.hmpg, t.fcbk, t.twit" +
            " from tcher t inner join memb m on t.tno=m.mno " +
            " where t.tno=?");) {
      
        stmt.setInt(1, no);
        
        try (ResultSet rs = stmt.executeQuery();) {
        
        if (!rs.next())  
          return null;
          
        Teacher teacher = new Teacher();
        teacher.setNo(rs.getInt("mno")); 
        teacher.setName(rs.getString("name")); 
        teacher.setTel(rs.getString("tel"));
        teacher.setEmail(rs.getString("email"));
        teacher.setHomepage(rs.getString("hmpg"));
        teacher.setFacebook(rs.getString("fcbk"));
        teacher.setTwitter(rs.getString("twit"));
        return teacher;

        }
      } finally {
        conPool.returnConnection(con);
      }
*/
  }
  

  public int insert(Teacher teacher) throws Exception{
SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {    
      int count = sqlSession.insert("step28.ex4.TeacherDao.insert", teacher);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
  public void insertPhoto(int no, List<String> photoList) throws Exception{
    /*
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "insert into tch_phot(tno, path) values(?,?)");) {
      
        for (String path : photoList) {
          stmt.setInt(1, no);
          stmt.setString(2, path);
          stmt.executeUpdate();
          
        }
        
      } finally {  
       conPool.returnConnection(con);
    }
    */

  }
  
  public int delete(int no) throws Exception {
    /*
    Connection con = conPool.getConnection();
    
    try (
        PreparedStatement stmt = con.prepareStatement(
            "delete from tcher where tno=?");) {
          stmt.setInt(1, no);
          return stmt.executeUpdate();
          // 데이터를 삭제할 넘버를 받아서 sql문에 인파라미터에 그 숫자를 적재하고 delete하고 delete된 갯수를 리턴한다.
          
        } finally {  
          conPool.returnConnection(con);
        }
  }
  */
  
return 0;
  }
}
