/* Spring WebMVC: 파라미터의 존재 유무로 요청을 구분한다.
 * => @RequestMapping의 params 속성에 지정된 값과 일치하는 
 *    요청 파라미터가 있을 경우에 호출된다.
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
@RequestMapping("/control/controller07/")
public class Controller07 {
  
  @RequestMapping(path="ok", params="name") // {"name"} 값이한개면 "{}" 생략가능 
  public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/plain;charset=UTF-8");  
    PrintWriter out = response.getWriter();
    out.println("name 있어요!");
  }
  
  @RequestMapping(path="ok", params={"age", "tel"}) 
  public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/plain;charset=UTF-8");  
    PrintWriter out = response.getWriter();
    out.println("age와 tel 있어요!");
  }
  
}