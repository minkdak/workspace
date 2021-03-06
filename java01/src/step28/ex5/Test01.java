/* Mybatis 퍼시스턴스 프레임워크: Mybatis를
 * => 동적(dynamic) SQL?
 *    - 조건에 따라 SQL문이 변경되는 것을 말한다.
 * => 특정 조건에 따라 SQL문이 약간씩 변경되어야 하는 경우,
 *    1) 각각의 조건에 해당하는 SQL문을 만든다.
 *       예) step28.ex2 패키지의 memberDao.xml
 *    2) 조건에 따라 SQL문에 자동으로 바뀌도록 만든다.
 *  
 */
package step28.ex5;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) throws Exception {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step28/ex5/application-context.xml");
    
    System.out.println("--------------------------------");
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기
    String[] names = ctx.getBeanDefinitionNames(); 
    for (String name : names) {
      System.out.printf("%s ===> %s\n", name, ctx.getBean(name));
    }
    
    System.out.println("--------------------------------");
    
    TeacherDao teacherDao = ctx.getBean(TeacherDao.class);
    List<Teacher> list = teacherDao.selectList(1, 100);
    for (Teacher t : list) {
      System.out.printf("%d, %s, %s, %s, %s\n", t.getNo(), t.getName(), t.getEmail(), t.getTel(), t.getHomepage());
    }
    /*
    InputStream inputStream = Resources.getResourceAsStream("step28/ex4/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    TeacherDaoImpl teacherDao = new TeacherDaoImpl();
    teacherDao.setSqlSessionFactory(sqlSessionFactory);
    
    List<Teacher> list = teacherDao.selectList(1, 100);
    for (Teacher t : list) {
      System.out.printf("%d, %s, %s, %s, %s\n", t.getNo(), t.getName(), t.getEmail(), t.getTel(), t.getHomepage());
    }
    System.out.println("------------------------");
    */
  }
}
