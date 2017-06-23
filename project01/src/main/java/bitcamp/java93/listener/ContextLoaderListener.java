package bitcamp.java93.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  HashMap<String,Object> objMap = new HashMap<>(); // 객체를 담을 바구니

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext sc = sce.getServletContext(); // 페이지 컨트롤러를 담을 보관소
    
    
    try {
      // 1) Spring IoC 컨테이너 객체 생성
      // => Spring IoC 컨테이너는 지정한 경로의 파일을 읽어서 객체를 준비한다.
      ApplicationContext appCtx = new ClassPathXmlApplicationContext("bitcamp/java93/application-context.xml");
          
      
      
      // 2) 프론트 컨트롤러에서 Spring IoC 컨테이너를 사용할 수 있도록
      //    ServletContext 보관소에 저장한다.
      sc.setAttribute("beanContainer", appCtx);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }

}