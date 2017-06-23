package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 보내기1
 * => 쿠키(Cookie)?
 *    - 웹서버가 웹브라우저에게 보내는 데이터이다.
 *    - 웹브라우저는 웹서버로 받은 쿠키 데이터를 내부 메모리 또는 별도의 폴더에 저장한다.
 *    - 그리고 그 웹서버를 방문할 때 마다 쿠키를 요청 헤더에 담아 다시 전달한다.
 */

@WebServlet("/step12/CookieReader01")
public class CookieReader01 extends HttpServlet{
  private static final long serialVersionUID = 1L;
    
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /* 1) 요청 헤더에서 쿠키 정보를 추출하기
     * 
     */
    
    Cookie[] cookies = req.getCookies();
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    // 2) 읽은 쿠키 정보 출력하기
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        out.printf("%s=%s, %s, %s, %d\n", 
            cookie.getName(),  // 쿠키 이름
            cookie.getValue(),  // 쿠키 값
            cookie.getDomain(),  // 쿠키의 사용 범위(도메인)
            cookie.getPath(),  // 쿠키의 사용 범위(경로) 
            cookie.getMaxAge());  // 쿠키의 생존 기간(초)
        
      }
    } else {
      out.println("쿠키가 한 개도 없습니다.");
    }
  }
}