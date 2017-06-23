/* 회원 관리 만들기 : 조회하기
 * => MemberDao를 이용하여 클라이언트가 보낸 번호에 해당하는 회원 정보를 찾아
 *    HTML로 만들어 출력한다.  
 *  
 */
package assign.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import assign.dao.ClassRoomDao;
import assign.domain.ClassRoom;
import assign.util.DBConnectionPool;



@WebServlet(urlPatterns="/classroom/detail")
public class ClassRoomDetailServlet extends GenericServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>"); 
    out.println("<title>강의실관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의실 조회</h1>");
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try{
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      ClassRoomDao classroomDao = new ClassRoomDao(conPool);
      
      int no = Integer.parseInt(req.getParameter("no"));
      
      ClassRoom classroom = classroomDao.selectOne(no);
      if (classroom == null) {
        throw new Exception(no + "번 회원이 없습니다.");
      }
      
      out.printf("<form action='update' method='POST'>"); 
      out.printf("번호:<input type='text' name='crmno' value='%d' readonly"
          + "><br>\n", classroom.getNo());
      out.printf("이름:<input type='text' name='name' value='%s'><br>\n", classroom.getName());
      out.println("<button>변경</button>");
      out.println("<button type='button' onclick='doDelete()'>삭제</button>");
      out.println("<button type='button' onclick='doList()'>목록</button>");
      out.println("</form>");
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/error");
      rd.forward(req,res);
      return;
    }
    rd = req.getRequestDispatcher("/footer");
    rd.include(req,res);
    
    
    out.println("<script>");
    out.println("function doDelete() {");
    out.printf("  location.href = 'delete?no=%s'\n", req.getParameter("no"));
    out.println("}");
    
    out.println("function doList() {");
    out.println("  location.href = 'list?'\n");
    out.println("}");
    out.println("</script>");
    
    out.println("</body>");
    out.println("</html>");
  }
}
