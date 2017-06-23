/* 회원 관리 만들기: 회원 삭제하기
 * => MemberDao를 이용하여 클라이언트로부터 받은 회원 정보를 변경한다.
 */
package assign.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dao.ClassRoomDao;



@WebServlet(urlPatterns="/classroom/delete")
public class ClassRoomDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 삭제</h1>");
    
    
    try{
      ClassRoomDao classroomDao = (ClassRoomDao)this.getServletContext().getAttribute("croomDao");    
      int no = Integer.parseInt(req.getParameter("no"));
      int count = classroomDao.delete(no);
      if (count < 1) {
        throw new Exception(no + "번 회원을 찾을 수 없습니다.");
      }
      out.println("<p>삭제 성공입니다.</p>");
      res.setHeader("Refresh", "1;url=list");
    } catch (Exception e) {
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    rd = req.getRequestDispatcher("/footer");
    rd.include(req,res);
    
    out.println("<a href='list'>목록</a>");
    
    out.println("</body>");
    out.println("</html>");
  }
}
