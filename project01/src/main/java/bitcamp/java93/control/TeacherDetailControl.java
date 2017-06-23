package bitcamp.java93.control;
/* 회원 관리 만들기 : 조회하기
 * => MemberDao를 이용하여 클라이언트가 보낸 번호에 해당하는 회원 정보를 찾아
 *    HTML로 만들어 출력한다.  
 *  
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@Component("/teacher/detail")
public class TeacherDetailControl implements Controller {
  @Autowired
  TeacherService teacherService;
  
  @Override
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {

      
    int no = Integer.parseInt(req.getParameter("no"));
    
    Teacher teacher = teacherService.get(no);
    
    if (teacher == null) {
      throw new Exception(no + "번 회원이 없습니다.");
    }
    
    req.setAttribute("teacher", teacher);
    return"/teacher/detail.jsp";
  }
    
}
