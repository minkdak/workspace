/* 회원 관리 만들기: 회원 목록 출력하기
 *  
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
import assign.dao.LectureDao;
import assign.domain.ClassRoom;
import assign.util.DBConnectionPool;


@WebServlet(urlPatterns="/classroom/add")
public class ClassRoomAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    ClassRoom c = new ClassRoom();
    
    c.setName(req.getParameter("name"));

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>"); // HTML 파일의 경우 필요하지만, 이미 위에서 알려주고있기 때문에 필요없다.
    out.println("<title>강의실관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의실등록</h1>");
    
    
    try{
      ClassRoomDao croomDao = (ClassRoomDao)this.getServletContext().getAttribute("croomDao");
      croomDao.insert(c);
      out.println("<p>등록 성공입니다.</p>");
      res.sendRedirect("list");
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
