/* 회원 관리 만들기 : 회원 조회하기 
 * => LectureDao를 이용하여 클라이언트가 보낸 번호에 해당하는 회원 정보 찾아
 *    HTML로 만들어 출력한다. 
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

@WebServlet(urlPatterns="/assignment/LectureView")
public class LectureView  extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강의관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 조회</h1>");
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(
          jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      LectureDao LectureDao = new LectureDao(conPool);
      
      int no = Integer.parseInt(req.getParameter("no"));
      
      Lecture lecture = LectureDao.selectOne(no);
      if (lecture == null) throw new Exception(no + "번 강의가 없습니다.");
      
      int crmno = lecture.getCrmno();
      int mrno = lecture.getMrno();
      //System.out.printf("crmno: %d, mrno: %d", crmno, mrno);
      ManagerDao managerDao = new ManagerDao(conPool);
      List<Manager> managerList = managerDao.selectNameList(); 
      
      ClassroomDao classroomDao = new ClassroomDao(conPool);
      List<Classroom> classroomList = classroomDao.selectNameList();
      
      out.printf("<form action='UpdateLecture' method='POST'>\n");
      out.printf("번호:<input type='text' name='no' value='%d' readonly><br>\n", lecture.getNo());
      out.printf("이름:<input type='text' name='titl' value='%s'><br>\n", lecture.getTitle());
      out.printf("설명:<input type='text' name='dscp' value='%s'><br>\n", lecture.getDescription());
      out.printf("시작일:<input type='text' name='sdt' value='%s'><br>\n", lecture.getStartDate());
      out.printf("종료일:<input type='text' name='edt' value='%s'><br>\n", lecture.getEndDate());
      out.printf("수강인원:<input type='text' name='qty' value='%d'><br>\n", lecture.getQuantity());
      out.printf("강의시간:<input type='text' name='thrs' value='%d'><br>\n", lecture.getTotalHours());
      out.printf("수업료:<input type='text' name='pric' value='%d'><br>\n", lecture.getPrice());
      
      out.println("<select name='mrno'><option value='0'>매니저를 선택하세요!</option>");
      for (Manager m : managerList) {
        if(mrno == m.getNo()) out.printf("<option value='%d' selected>%s</option>\n", m.getNo(), m.getMember().getName());
        else out.printf("<option value='%d'>%s</option>\n", m.getNo(), m.getMember().getName());
      }
      out.println("</select><br>");
      
      out.println("<select name='crmno'><option value='0'>강의실 선택하세요!</option>");
      for (Classroom c : classroomList) {
        if(crmno == c.getNo()) out.printf("<option value='%d' selected>%s</option>\n", c.getNo(), c.getName());
        else out.printf("<option value='%d'>%s</option>\n", c.getNo(), c.getName());
      }
      out.println("</select><br>");
      
      out.printf("<button>변경</button>");
      out.printf("<button type='button' onclick='doDelete()'>삭제</button>");
      out.printf("<button type='button' onclick='doList()'>목록</button>");
      out.printf("</form>");
      
      
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("<a href='SelectLectures'>목록</a>");
    }
    
    out.println("<script>");
    out.println("function doDelete() {");
    out.printf("location.href = 'DeleteLecture?no=%s'\n", req.getParameter("no"));
    out.println("}");
    out.println("function doList() {");
    out.println("location.href = 'SelectLectures'");
    out.println("}");
    out.println("</script>");
    out.println("</body>");
    out.println("</html>");
  }
}









