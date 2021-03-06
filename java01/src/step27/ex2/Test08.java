/* 스프링 사용법: 호출될 생성자 지정하기III
 */
package step27.ex2;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {
  public static void main(String[] args) throws IOException {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex2/application-context-08.xml");
    
    System.out.println(ctx.getBean("c1"));
    System.out.println(ctx.getBean("c2"));
  }
}


