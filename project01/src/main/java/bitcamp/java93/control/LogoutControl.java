/* 로그아웃 서블릿 : ServletContext에서 로그인 회원 정보를 제거하고, 로그인 페이지로 보낸다.*/

package bitcamp.java93.control;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component("/auth/logout")
public class LogoutControl implements Controller {
  
  @Override
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception  {
    req.getSession().invalidate(); // 요청한 클라이언트의 전용 HttpSession 객체를 무효화 시킨다.
    
    return "redirect:../auth/login.do";
  }
}
