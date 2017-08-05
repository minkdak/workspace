/* 스프링 사용법: @Autowired 애노테이션 사용하기 I
 * => XML 설정 파일에서 직접 의존 객체를 주입하기
 */
package step27.ex5;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) throws IOException {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step27/ex5/application-context-01.xml");
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기
    
    System.out.println("--------------------------------");
    String[] names = ctx.getBeanDefinitionNames(); 
    for (String name : names) {
      System.out.println(ctx.getBean(name));
    }
  }
}
