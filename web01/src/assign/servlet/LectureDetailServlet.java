/* 회원 관리 만들기 : 조회하기
 * => MemberDao를 이용하여 클라이언트가 보낸 번호에 해당하는 회원 정보를 찾아
 *    HTML로 만들어 출력한다.  
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



@WebServlet(urlPatterns="/lecture/detail")
public class LectureDetailServlet extends GenericServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>"); 
    out.println("<title>강의관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 조회</h1>");
    
    try{
      LectureDao lectureDao = (LectureDao)this.getServletContext().getAttribute("lectureDao");
      int no = Integer.parseInt(req.getParameter("no"));
      
      Lecture lecture = lectureDao.selectOne(no);
      if (lecture == null) {
        throw new Exception(no + "번 회원이 없습니다.");
      }
      ManagerDao managerDao = (ManagerDao)this.getServletContext().getAttribute("managerDao");
      List<Manager> managerList= managerDao.selectList();

      ClassRoomDao croomDao = (ClassRoomDao)this.getServletContext().getAttribute("croomDao");
      List<ClassRoom> croomList= croomDao.selectList(1, 100);
      
      
      out.printf("<form action='update' method='POST'>"); 
      out.printf("번호:<input type='text' name='no' value='%d' readonly"
          + "><br>\n", lecture.getNo());
      out.printf("강의명:<input type='text' name='titl' value='%s'><br>\n", lecture.getTitle());
      out.printf("설  명:<textarea type='text' name='dscp' value='%s' rows='4'>%s</textarea><br>\n", lecture.getDscp(), lecture.getDscp());
      out.printf("강의기간:<input type='date' name='sdt' value='%s' placeholder='시작일'> ~ "
          + "<input type='date' name='edt' value='%s' placeholder='종료일'><br>\n", lecture.getSdt(), lecture.getEdt());
      out.printf("최대수강인원:<input type='number' name='qty' value='%d'><br>\n", lecture.getQty());
      out.printf("강의시간:<input type='number' name='thrs' value='%d'><br>\n", lecture.getThrs());
      out.printf("수업료:<input type='number' name='pric' value='%d'><br>\n", lecture.getPric());
      out.printf("매니저:<select name='mrno'><option value='0'>매니저를 선택하세요!</option>");
      for (Manager m : managerList) {
        if (lecture.getMrno() == m.getNo()){
          System.out.println("들");
          out.printf("<option value=%d selected>%d, %s</option>",m.getNo(), m.getNo(), m.getName());}
        else out.printf("<option value=%d>%d, %s</option>",m.getNo(), m.getNo(), m.getName());
      }
      out.printf("</select><br>\n");
      out.printf("강의실:<select name='crmno'><option value='0'>강의실을 선택하세요!</option>");
      for (ClassRoom c : croomList) {
        if (lecture.getCrmno() == c.getNo())
          out.printf("<option value=%d selected>%d, %s</option>",c.getNo(), c.getNo(), c.getName());
        else out.printf("<option value=%d>%d, %s</option>",c.getNo(), c.getNo(), c.getName());
      }
      out.printf(    "</select><br>\n");
      
      
      
      out.println("<button>변경</button>");
      out.println("<button type='button' onclick='doDelete()'>삭제</button>");
      out.println("<button type='button' onclick='doList()'>목록</button>");
      out.println("</form>");
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/error");
      rd.forward(req,res);
      out.println("<a href='list'>목록</a>");
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
