/* 스프링 사용법: 셋터 호출하기VII
 */
package step27.ex2;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test10 {
  public static void main(String[] args) throws IOException {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex2/application-context-10.xml");
    
    System.out.println(ctx.getBean("c1"));
  }
}


