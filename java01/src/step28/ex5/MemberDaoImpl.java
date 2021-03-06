package step28.ex5;
/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *    사용한 후에는 반납한다.
 */

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDaoImpl implements MemberDao{
  @Autowired SqlSessionFactory sqlSessionFactory;
  
  public List<Member> selectList(int pageNo, int pageSize, String search, String value) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
    HashMap<String, Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    valueMap.put("search", search);
    valueMap.put("value", value);
    
    return sqlSession.selectList("step28.ex4.MemberDao.selectList", valueMap);
    } finally {
      sqlSession.close();
    }
  }
  
  public List<Member> selectListByNames(int pageNo, int pageSize, String[] names) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
    HashMap<String, Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    valueMap.put("names", names);
    
    return sqlSession.selectList("step28.ex4.MemberDao.selectListByNames", valueMap);
    
    } finally {
      sqlSession.close();
    }
  }
  
  
  public Member selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      // SqlSession.selectOne()을 실행할 때는 반드시 결과를 한 개만 만드는 select문을 지정해야 한다.
      return sqlSession.selectOne("step28.ex4.MemberDao.selectOne", no);
    } finally {
      sqlSession.close();
    }
  /*
    Connection con = conPool.getConnection();
    
    try ( 
        PreparedStatement stmt = con.prepareStatement(
            "select mno, name, tel, email from memb where mno=?");) {
      
        stmt.setInt(1, no);
        
        try (ResultSet rs = stmt.executeQuery();) {
        
        if (!rs.next())  
          return null;
          
        Member member = new Member();
        member.setNo(rs.getInt("mno")); 
        member.setName(rs.getString("name")); 
        member.setTel(rs.getString("tel"));
        member.setEmail(rs.getString("email"));
        return member;

        }
      } finally {
        conPool.returnConnection(con);
      }
*/
  }
  
  public Member selectOneByEmailPassword(String email, String password) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      HashMap<String, Object> valueMap = new HashMap<>();
      valueMap.put("email", email);
      valueMap.put("password", password);
      return sqlSession.selectOne("step28.ex4.MemberDao.selectOneByEmailPassword", valueMap);
    } finally {
      sqlSession.close();
    }
  }
  
  public int insert(Member member) throws Exception{
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      // insert 문을 실행할 때는 insert() 메서드를 호출하라!
      // SqlSession.insert()의 리턴 값은 내부적으로 호출한 executeUpdate()의 리턴 값이다.
      int count = sqlSession.insert("step28.ex4.MemberDao.insert", member);
      
      // insert(), update(), delete()을 호출한 후에는
      // DBMS에 최종적으로 확정하는 명령을 보내야 실행 완료된다.
      sqlSession.commit();
          
      
      /* insert(), update(), delete()을 호출한 후
       * DBMS에 자동으로 최종적으로 확정하는 명령을 보내고 싶다면,
       * SqlSession을 얻을 때 미리 설정해야 한다.
       * 코드:
       * SqlSession sqlSession = sqlSessionFactory.openSession(true);
       */
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.delete("step28.ex4.MemberDao.delete", no);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
    /*
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "delete from memb where mno=?");) {
          stmt.setInt(1, no);
          return stmt.executeUpdate();
          // 데이터를 삭제할 넘버를 받아서 sql문에 인파라미터에 그 숫자를 적재하고 delete하고 delete된 갯수를 리턴한다.
          
        } finally {  
          conPool.returnConnection(con);
        }
    */
  }
  
  public int update(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.update("step28.ex4.MemberDao.update", member);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }

  }  
}
