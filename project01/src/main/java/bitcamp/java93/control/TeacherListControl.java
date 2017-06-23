package bitcamp.java93.control;
/* 회원 관리 만들기: 회원 목록 출력
 * => 포워드 적용: 오류 처리 부분
 * => 인클루딩 적용: 웹페이지의 꼬리말 출력 부분 
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@Component("/teacher/list")
public class TeacherListControl implements Controller {
  @Autowired
  TeacherService teacherService;
  


  @Override
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {    
    /* 페이지 번호와 페이지당 출력 개수 파라미터 받기*/
    int pageNo = 1;
    int pageSize = 5;
    
    try { // pageNo 파라미터 값이 있다면 그 값으로 설정한다.
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
    } catch (Exception e) {}
    
    try { // pageSize 파라미터 값이 있다면 그 값으로 설정한다.
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    } catch (Exception e) {}
    
      List<Teacher> list = teacherService.list(pageNo, pageSize);
      req.setAttribute("list", list);
      return "/teacher/list.jsp";
  }
}