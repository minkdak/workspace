/* 스프링 사용법: 호출될 생성자 지정하기III
 */
package step27.ex2;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
  public static void main(String[] args) throws IOException {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex2/application-context-04.xml");
    
    // 객체의 scope이 singleton인 경우,
    // getBean()은 항상 존재하는 객체를 리턴한다.
    System.out.println(ctx.getBean("c1"));
    System.out.println(ctx.getBean("c2"));
  }
}

