/* 예외 처리 서블릿
 * => 다른 서블릿을 실행하는 중에 예외가 발생하면 이 서블릿으로 위임할 것이다.
 *    방법?
 *    포워딩을 사용하여 위임할 것이다.
 * => 포워딩을 사용하는 예이다.
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(urlPatterns="/init", loadOnStartup=1)
public class InitServlet extends HttpServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void init() throws ServletException {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try{
    DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    
    MemberDao memberDao = new MemberDao(conPool); // 가비지 아니다. ServletContext 에서 보관하니까.
    
    // 모든 서블릿이 사용할 수 있도록 memberDao 객체를 ServletContext에 보관한다.
    ServletContext sc = this.getServletContext();
    sc.setAttribute("memberDao",  memberDao);
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
