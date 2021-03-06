/* Mybatis 퍼시스턴스 프레임워크: 사용
 * 1) mybatis 라이브러리 파일 가져오기
 *  - mvnrepository.com "mybatis" 검색
 *  - build.gradle 파일에 의존 라이브러리 설정 추가
 *  - "gradle eclipse" 실행하여 이클립스 설정 갱신
 *  -  프로젝트 "refresh"
 * 2) mybatis 사용자 안내 문서 확인
 *  - www.mybatis.org 방문
 * 3) sqlSessionFactory 객체를 준비한다
 * 4) MemberDao SqlSessionFactory
 * 
 */
package step28.ex2;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {
  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex2/mybatis-config.xml");
    // FileInputStream inputStream = new FileInputStream("./src/step28/ex2/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    MemberDaoImpl memberDao = new MemberDaoImpl();
    memberDao.setSqlSessionFactory(sqlSessionFactory);
    
    Member m = memberDao.selectOne(122);
    System.out.println(m);
  }
}
