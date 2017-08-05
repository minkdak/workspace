/* 스프링 사용법: java.sql.Date.valueOf("2017-06-21") 호출하기 
 */
package step27.ex3;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {
  public static void main(String[] args) throws IOException {
    // 7) Spring IoC 컨테이너를 이용하여 팩토리 메서드 사용하기
    // => 스프링에서 제공하는 규칙에 따라 팩토리 메서드를 만들 때
    //    보통 그 클래스의 이름은 "FactoryBean"으로 끝난다.
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step27/ex3/application-context-07.xml");
    
    // 제조일이 지정된 Tire 객체를 꺼내 출력한다.
    System.out.println(ctx.getBean("t1"));
  }
}
