/* 회원 관리 만들기: 회원 목록 출력하기II
 * => 회원 목록을 HTML로 만들어 출력한다. 
 */
package assign.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import assign.dao.ClassRoomDao;
import assign.domain.ClassRoom;
import assign.util.DBConnectionPool;



@WebServlet(urlPatterns="/classroom/list")
public class ClassRoomListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    /* 페이지 번호와 페이지당 출력 개수 파라미터 받기*/
    int pageNo = 1;
    int pageSize = 5;
    
    try { 
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
    } catch (Exception e) {}
    
    try { 
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    } catch (Exception e) {}
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>"); // HTML 파일의 경우 필요하지만, 이미 위에서 알려주고있기 때문에 필요없다.
    out.println("<title>강의실 관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의실 목록</h1>");
    
    
    try{
    
    ClassRoomDao classroomDao = (ClassRoomDao)this.getServletContext().getAttribute("croomDao");    
    List<ClassRoom> list = classroomDao.selectList(pageNo, pageSize);
    
    out.println("<a href='form.html'>새회원</a>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("<tr><th>번호</th><th>이름</th>");
    out.println("</thead>");
    out.println("<tbody>");
    for (ClassRoom c : list) {
      out.println("<tr>");
      out.printf("  <td>%d</td>", c.getNo());
      out.printf("  <td><a href='detail?no=%d'>%s</a></td>", c.getNo(), c.getName());
      out.println("</tr>");
    }
    
    out.println("</tbody>");
    out.println("</table>");
    
    } catch (Exception e) {
      req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    rd = req.getRequestDispatcher("/footer");
    rd.include(req,res);
    
    out.println("</body>");
    out.println("</html>");
  }
}
