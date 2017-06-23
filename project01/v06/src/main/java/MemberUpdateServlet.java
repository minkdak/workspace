/* 회원 관리 만들기: 회원 변경하기
 * => MemberDao를 이용하여 클라이언트로부터 받은 회원 정보를 변경한다.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/member/update")
public class MemberUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    
    Member m = new Member();
    m.setNo(Integer.parseInt(req.getParameter("no")));
    m.setName(req.getParameter("name"));
    m.setTel(req.getParameter("tel"));
    m.setEmail(req.getParameter("email"));
    m.setPassword(req.getParameter("password"));

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원관리</title>");
    RequestDispatcher rd1 = req.getRequestDispatcher("/style/core");
    rd1.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원등록</h1>");
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try{
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      MemberDao memberDao = new MemberDao(conPool);
    
      int count = memberDao.update(m);
      if (count < 1) {
        throw new Exception(m.getNo() + "번 회원을 찾을 수 없습니다.");
      }
      out.println("<p>변경 성공입니다.</p>");
      
      // 버퍼의 내용물이 클라이언트에게 전달되기 전이라면
      // 언제든지 다음과 같이 헤더를 추가하거나 변경할 수 있다.
      res.setHeader("Refresh", "1;url=list");
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req,res);
      return;
    }
    
    RequestDispatcher rd = req.getRequestDispatcher("/footer");
    rd.include(req,res);
    
    out.println("</body>");
    out.println("</html>");
  }
}
