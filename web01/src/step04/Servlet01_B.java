/* 화면 전환하기: Refresh 헤더를 이용한 화면 전환 (화면B)
 * => 
 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns="/step04/Servlet01/b")
public class Servlet01_B extends GenericServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>"); // HTML 파일의 경우 필요하지만, 이미 위에서 알려주고있기 때문에 필요없다.
    out.println("<title>리프레시</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>화면B</h1>");
    out.println("</body>");
    out.println("</html>");
    
  }
}
