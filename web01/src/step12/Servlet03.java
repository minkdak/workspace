package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 보내기 III
 * => 사용 기간 지정하기
 *    사용 기간을 지정하지 않으면, 웹브라우저가 실행되는 동안만 보관된다.\
 *    웹 브라우저를 **모두** 사용 기간을 지정하지 않은 쿠키는 버려진다.
 * => 사용 기간을 지정하면,
 *    - 컴퓨터를 껏다 켜도 그 기간 동안 유지된다.
 *    - 웹 브라우저는 보낼 쿠키를 검사할 때 사용 기간이 지난 쿠키는 제거한다.
 */

@WebServlet("/step12/Servlet03")
public class Servlet03 extends HttpServlet{
  private static final long serialVersionUID = 1L;
    
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = new Cookie("c3", "cccc");
    // 쿠키의 사용 범위를 현재 웹애플리케이션 전체로 지정한다.
    cookie.setPath(req.getContextPath()); // getContextPath() --> "/web01"
    
    cookie.setMaxAge(60); // 단위: 초
    resp.addCookie(cookie);
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Servlet: 쿠키 보냈음");
  }
}

/* URL 인코딩?
 * HTTP/1.1 200
Set-Cookie: c3=cccc; Max-Age=60; Expires=Mon, 12-Jun-2017 05:41:12 GMT; Path=/web01
Content-Type: text/plain;charset=UTF-8
Content-Length: 27
Date: Mon, 12 Jun 2017 05:40:12 GMT
 */
