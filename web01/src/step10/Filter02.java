/*
 * Filter?
 * - 요청이 들어왔을 때 서블릿에 전달하기 전에 작업을 수행
 * - 서블릿이 요청을 처리한 후에 작업을 수행
 
 */
package step10;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/step10/Servlet02")
public class Filter02 implements Filter{

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // 필터 객체가 생성될 때 호출된다.
    // 웹 애플리케이션이 시작된 후 필터가 적용될 때 딱 한 번만 호출된다.
    // 필터가 작업을 하는데 필요한 자원을 준비시키는 코드를 여기에 둔다.
    System.out.println("########### Filter02.init() ###########");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.out.println(" Filter02.doFilter() 시작 {{{{{{{{{{{{{{");
    
    chain.doFilter(request, response);
    
    System.out.println(" }}}}}}}}}Filter02.doFilter() 끝!");
  }

  @Override
  public void destroy() {
    // 필터 객체가 소멸될 때 호출된다.
    // 웹 애플리케이션이 종료되기 전에 딱 한 번만 호출된다.
    // init()에서 준비한 자원을 해제시키는 코드를 여기에 둔다.
    System.out.println("########### Filter02.destroy() ###########");
  }
  
}
