/* 회원 관리 만들기: 회원 목록 출력
 * => 포워드 적용: 오류 처리 부분
 * => 인클루딩 적용: 웹페이지의 꼬리말 출력 부분 
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns="/member/list")
public class MemberListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    /* 페이지 번호와 페이지당 출력 개수 파라미터 받기*/
    int pageNo = 1;
    int pageSize = 5;
    
    try { // pageNo 파라미터 값이 있다면 그 값으로 설정한다.
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
    } catch (Exception e) {}
    
    try { // pageSize 파라미터 값이 있다면 그 값으로 설정한다.
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    } catch (Exception e) {}
    
    // 이렇게 출력스트림을 얻기 전에 먼저 호출해야 한다.
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>"); // HTML 파일의 경우 필요하지만, 이미 위에서 알려주고있기 때문에 필요없다.
    out.println("<title>회원관리</title>");
    RequestDispatcher rd1 = req.getRequestDispatcher("/style/core");
    rd1.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원목록</h1>");
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try{
    DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    
    MemberDao memberDao = new MemberDao(conPool);
    
    List<Member> list = memberDao.selectList(pageNo, pageSize);
    
    out.println("<a href='form.html'>새회원</a>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("<tr><th>번호</th><th>이름</th><th>전화</th><th>이메일</th></tr>");
    out.println("</thead>");
    out.println("<tbody>");
    for (Member m : list) {
      out.println("<tr>");
      out.printf("  <td>%d</td>", m.getNo());
      out.printf("  <td><a href='detail?no=%d'>%s</a></td>", m.getNo(), m.getName());
      out.printf("  <td>%s</td>", m.getTel());
      out.printf("  <td>%s</td>", m.getEmail());
      out.println("</tr>");
    }
    
    out.println("</tbody>");
    out.println("</table>");
    
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req,res);
      return;
    }
    
    // including 기법을 사용하여 각 페이지마다 꼬리말을 붙인다.
    RequestDispatcher rd = req.getRequestDispatcher("/footer");
    rd.include(req,res);
    
    out.println("</body>");
    out.println("</html>");
  }
}
