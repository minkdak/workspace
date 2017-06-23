package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 읽기
 * => 사용 범위에 속하지 않은 URL인 경우,
 *    웹 브라우저는 쿠키를 보내지 않는다.
 *    그 URL에 속한 쿠키만 보낸다. 
 */

@WebServlet("/other/CookieReader02")
public class CookieReader02 extends HttpServlet{
  private static final long serialVersionUID = 1L;
    
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    Cookie[] cookies = req.getCookies();
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        out.printf("%s=%s, %s, %s, %d\n", 
            cookie.getName(),  
            cookie.getValue(), 
            cookie.getDomain(),
            cookie.getPath(),   
            cookie.getMaxAge()); 
        
      }
    } else {
      out.println("쿠키가 한 개도 없습니다.");
    }
  }
}