package bitcamp.java93.filter;
/* 페이지 상단에 HttpSession 보관소에 꺼낸 로그인 정보
 * 
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Member;

@WebFilter({"/member/*", "/classroom/*", "/lecture/*"})
public class AuthCheckFilter implements Filter{

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    Member loginMember = (Member)httpRequest.getSession().getAttribute("loginMember");
    if (loginMember == null) { // 쿠키에 세션ID가 없다면 로그인 화면으로 보낸다.
      httpResponse.sendRedirect("../auth/login.do");
      return;      
    }
    
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    
  }

}
