/* 회원 관리 만들기: 회원 목록 출력하기
 *  
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
import assign.dao.LectureDao;
import assign.dao.ManagerDao;
import assign.domain.ClassRoom;
import assign.domain.Lecture;
import assign.domain.Manager;
import assign.util.DBConnectionPool;



@WebServlet(urlPatterns="/lecture/addform")
public class AddFormServlet extends GenericServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    Lecture l = new Lecture();
    
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
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try{
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      LectureDao lectureDao = new LectureDao(conPool);
      ManagerDao managerDao = new ManagerDao(conPool);
      ClassRoomDao croomDao = new ClassRoomDao(conPool);
      
      List<Lecture> lectureList = lectureDao.selectList(1, 100);
      List<Manager> managerList= managerDao.selectList();
      
      List<ClassRoom> croomList= croomDao.selectList(1, 100);
      
      out.printf("<form action='add' method='POST'>"); 
      out.printf("강의명:<input type='text' name='titl'><br>\n");
      out.printf("설  명:<textarea type='text' name='dscp' rows='4'></textarea><br>\n");
      out.printf("강의기간:<input type='date' name='sdt' placeholder='시작일'> ~ "
          + "<input type='date' name='edt' placeholder='종료일'><br>\n");
      out.printf("최대수강인원:<input type='number' name='qty'><br>\n");
      out.printf("강의시간:<input type='number' name='thrs'><br>\n");
      out.printf("수업료:<input type='number' name='pric'><br>\n");
      out.printf("매니저:<select name='mrno'><option value='0'>매니저를 선택하세요!</option>");
      
      for (Manager m : managerList) {
        out.printf("<option value=%d>%d, %s</option>",m.getNo(), m.getNo(), m.getName());
      }
      
      out.printf("</select><br>\n");
      out.printf("강의실:<select name='crmno'><option value='0'>강의실을 선택하세요!</option>");
      
      for (ClassRoom c : croomList) {
        out.printf("<option value=%d>%d, %s</option>",c.getNo(), c.getNo(), c.getName());
      }
      
      out.printf(    "</select><br>\n");
      out.println("<button>등록</button>");
      out.println("<button type='button' onclick='doDelete()'>삭제</button>");
      out.println("<button type='button' onclick='doList()'>목록</button>");
      out.println("</form>");
      
    } catch (Exception e) {
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    out.println("<script>");
    out.println("function doDelete() {");
    out.printf("  location.href = 'delete?no=%s'\n", req.getParameter("no"));
    out.println("}");
    
    out.println("function doList() {");
    out.println("  location.href = 'list'\n");
    out.println("}");
    out.println("</script>");
    rd = req.getRequestDispatcher("/footer");
    rd.include(req,res);
    out.println("</body>");
    out.println("</html>");
  }
}
