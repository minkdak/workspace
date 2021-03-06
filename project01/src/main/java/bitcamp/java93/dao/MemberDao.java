package bitcamp.java93.dao;
/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *    사용한 후에는 반납한다.
 */

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import bitcamp.java93.domain.Member;

@Component
public interface MemberDao {
   List<Member> selectList(Map<String,Object> valueMap);  
   List<Member> selectListByNames(Map<String,Object> valueMap);
   
   Member selectOne(int no);
   Member selectOneByEmailPassword(Map<String,Object> valueMap);
   
   int insert(Member member);
   int update(Member member);  
  
   int delete(int no);
}
