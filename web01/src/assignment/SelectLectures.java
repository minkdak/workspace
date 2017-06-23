/* 회원 관리 만들기 : 회원 목록 출력하기
 * => LectureDao, Lecture, DBConnectionPool 클래스 준비
 * => LectureDao를 이용하여 회원 목록을 가져온 다음, 
 *    HTML 문을 생성하여 출력한다.
 */
package assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/assignment/SelectLectures")
public class SelectLectures  extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    int pageNo = 1;
    int pageSize = 100;
    
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
    out.println("<title>강의관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 목록</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(
          jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      LectureDao LectureDao = new LectureDao(conPool);
      
      List<Lecture> list = LectureDao.selectList(pageNo, pageSize);
      
      out.println("<a href='AddLectureForm'>새강의</a><br>");
      
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr><th>번호</th><th>제목</th><th>시작일</th><th>종료일</th><th>강의시간</th><th>수업료</th></tr>");
      out.println("</thead>");
      out.println("<tbody>");
      for (Lecture l : list) {
        out.println("<tr>");
        out.printf("<td>%s</td>\n", l.getNo());
        out.printf("<td><a href='LectureView?no=%d'>%s</a></td>\n", l.getNo(), l.getTitle());
        out.printf("<td>%s</td>\n", l.getStartDate());
        out.printf("<td>%s</td>\n", l.getEndDate());
        out.printf("<td>%s</td>\n", l.getTotalHours());
        out.printf("<td>%s</td>\n", l.getPrice());
        out.println("</tr>");
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      out.println("오류 발생!");
      e.printStackTrace(out);
    }
    
  }
}









