/* 스프링 사용법: Spring IoC 컨테이너 준비 I
 * => 스프링 IoC 컨테이너를 사용하기 위한 라이브러리 준비
 *    1) mvnrepository.com에서 "spring-context" 검색
 *    2) build.gradle에 의존 라이브러리 정보 추가
 *    3) "gradle eclipse" 실행하여 관련 설정파일을 갱신
 *    4) 이클립스 프로젝트를 "refresh"
 */
package step27.ex1;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) throws IOException {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex1/application-context-02.xml");
    
    // getBean(빈의 ID)
    Car obj1 = (Car)ctx.getBean("c1");
    System.out.println(obj1);
    
    Car obj2 = (Car)ctx.getBean("c2");
    Car obj3 = (Car)ctx.getBean("c3");
    Car obj4 = (Car)ctx.getBean("c4");
    Car obj5 = (Car)ctx.getBean("c5");
    
    if (obj2 == obj5) {
      System.out.println("c2나 c5 모두 같은 객체이다.");
    }
    
    System.out.println(ctx.getBean("c6"));
    System.out.println(ctx.getBean("c7"));
    System.out.println(ctx.getBean("c8"));
    
    String[] aliases = ctx.getAliases("c7");
    for (String alias : aliases) {
      System.out.println(alias);
    }
    
    System.out.println(ctx.getBean("c10 c11 c12")); // 해당 빈이 없다. 예외 발생!
  }
}
