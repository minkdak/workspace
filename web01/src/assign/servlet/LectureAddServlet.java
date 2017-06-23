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

import assign.dao.LectureDao;
import assign.domain.Lecture;


@WebServlet(urlPatterns="/lecture/add")
public class LectureAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    Lecture l = new Lecture();
    
    l.setTitle(req.getParameter("titl"));
    l.setSdt(req.getParameter("sdt"));
    l.setEdt(req.getParameter("edt"));
    l.setDscp(req.getParameter("dscp"));
    l.setThrs(Integer.parseInt(req.getParameter("thrs")));
    l.setPric(Integer.parseInt(req.getParameter("pric")));
    l.setQty(Integer.parseInt(req.getParameter("qty")));
    System.out.println(req.getParameter("mrno"));
    System.out.println(req.getParameter("crmno"));
    l.setMrno(Integer.parseInt(req.getParameter("mrno")));
    l.setCrmno(Integer.parseInt(req.getParameter("crmno")));

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>"); // HTML 파일의 경우 필요하지만, 이미 위에서 알려주고있기 때문에 필요없다.
    out.println("<title>강의관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의등록</h1>");
    
    
    try{
      
      LectureDao lectureDao = (LectureDao)this.getServletContext().getAttribute("lectureDao");
    
      lectureDao.insert(l);
      out.println("<p>등록 성공입니다.</p>");
      res.sendRedirect("list");
    
    } catch (Exception e) {
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    rd = req.getRequestDispatcher("/footer");
    rd.include(req,res);
    
    out.println("<a href='Servlet02'>목록</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
