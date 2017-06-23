/* HttpServlet 추상 클래스를 상속받아 서블릿 만들기 I
 * => Servlet 인터페이스의 오리지널 service() 메서드 구현하기
 */
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/step11/Servlet01")
public class Servlet01 extends HttpServlet {
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("안녕하세요");
  }
}
