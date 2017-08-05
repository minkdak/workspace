/* Spring WebMVC: 요청 http mehtod 구분하여 처리하기
 * 요청 URL = class에 붙은 URL + 메서드에 붙은 URL
 * => 실행 방법
 *    http://localhost:8080/springweb01/controller05.html
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/control/controller06/")
public class Controller06 {
  
  // @RequestMapping(value="ok", method=RequestMethod.GET) // 파라미터 값이 두가지 이상인 경우 value 값을 생략할 수 없다. path로 대체 가능
  @RequestMapping(path="ok", method=RequestMethod.GET) 
  public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/plain;charset=UTF-8");  
    PrintWriter out = response.getWriter();
    out.println("get!");
  }
  
  @RequestMapping(path="ok",method=RequestMethod.POST) 
  public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/plain;charset=UTF-8");  
    PrintWriter out = response.getWriter();
    out.println("post!");
  }
  
}