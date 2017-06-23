/* 작업을 나눠서 처리하기: 인클루딩
 * 1) 포워딩(forwarding)
 *    - 실행을 완전히 위임한다.
 *    - 포워딩을 이용하여 Chain of Responsibility 설계를 구현할 수 있다.
 *      체인처럼 기능을 확장하는 방법이다.
 *      즉 체인처럼 기능을 넣고 빼기 쉽고, 순서를 바꾸기 쉽다.
 * 2) 인클루딩(including)
 *    - 잠시 실행을 위임한 후 작업이 끝나면 다시 들아온다.
 *    - 기존의 출력은 계속 유효하다.
 */
package step05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/step05/Servlet02")
public class Servlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>"); // HTML 파일의 경우 필요하지만, 이미 위에서 알려주고있기 때문에 필요없다.
    out.println("<title>인클루딩</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Servlet02에서 출력함!</h1>");
    
    // Servlet02_a 서블릿의 실행을 포함시킨다.
    RequestDispatcher rd = req.getRequestDispatcher("/step05/Servlet02/a");
    rd.include(req, res);
    
    rd = req.getRequestDispatcher("/step05/Servlet02/b");
    rd.include(req, res);
    
    out.println("</body>");
    out.println("</html>");
    
  }
}
