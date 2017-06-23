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

@WebServlet(urlPatterns="/assignment/DeleteLecture")
public class DeleteLecture  extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>강의관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 삭제</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(
          jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      LectureDao lectureDao = new LectureDao(conPool);
      int no = Integer.parseInt(req.getParameter("no"));
      
      int count = lectureDao.delete(no);
      if(count < 1) throw new Exception( no + "번 강의를 찾을 수 없습니다.");
      out.println("<p>삭제 성공했습니다.</p>");
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    
    out.println("<a href = 'SelectLectures'>목록</a>");
  
    out.println("</body>");
    out.println("</html>");
  }
}









