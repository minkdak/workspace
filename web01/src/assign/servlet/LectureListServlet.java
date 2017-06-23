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

import assign.dao.LectureDao;
import assign.domain.Lecture;


@WebServlet(urlPatterns="/lecture/list")
public class LectureListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    /* 페이지 번호와 페이지당 출력 개수 파라미터 받기*/
    int pageNo = 1;
    int pageSize = 100;
    
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
    out.println("<title>강의실 관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의실 목록</h1>");
    
    try{
    LectureDao lectureDao = (LectureDao)this.getServletContext().getAttribute("lectureDao");    
    List<Lecture> list = lectureDao.selectList(pageNo, pageSize);
    
    out.println("<a href='addform'>새 강의</a>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("<tr><th>번호</th><th>제목</th><th>시작일</th><th>종료일</th><th>강의시간</th><th>수강료</th>");
    out.println("</thead>");
    out.println("<tbody>");
    for (Lecture l : list) {
      out.println("<tr>");
      out.printf("  <td>%d</td>", l.getNo());
      out.printf("  <td><a href='detail?no=%d'>%s</a></td>", l.getNo(), l.getTitle());
      out.printf("  <td>%s</td>", l.getSdt());
      out.printf("  <td>%s</td>", l.getEdt());
      out.printf("  <td>%d</td>", l.getThrs());
      out.printf("  <td>%d</td>", l.getPric());
      out.println("</tr>");
    }
    
    out.println("</tbody>");
    out.println("</table>");
    
    } catch (Exception e) {
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/error");
      rd.forward(req,res);
      return;
    }
    rd = req.getRequestDispatcher("/footer");
    rd.include(req,res);
    
    out.println("</body>");
    out.println("</html>");
  }
}
