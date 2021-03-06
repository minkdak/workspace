package step28.ex6;
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

@Component
public interface MemberDao {
  //Mybatis에서 DAO 구현체를 자동으로 만들게 하려면,
  // 메서드의 파라미터 타입이 SQL 맵퍼에 선언된 parameterType 속성의 값과 같아야한다.
   List<Member> selectList(Map<String,Object> valueMap) throws Exception;
   List<Member> selectListByNames(Map<String,Object> valueMap) throws Exception;
   Member selectOne(int no) throws Exception;
  
   Member selectOneByEmailPassword(Map<String,Object> valueMap) throws Exception;
   int insert(Member member) throws Exception;
  
   int delete(int no) throws Exception;
   int update(Member member) throws Exception;  
}
