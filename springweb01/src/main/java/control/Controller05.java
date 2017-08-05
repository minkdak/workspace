/* Spring WebMVC: 요청 http mehtod 구분하여 처리하기
 * 요청 URL = class에 붙은 URL + 메서드에 붙은 URL
 * => 실행 방법
 *    http://localhost:8080/springweb01/controller05.html
 * => WEB-INF 밑에 어떤 파일을 놓아도 웹브라우저에서 출력할 수없다. 하나의 보안 구역이라고 보면 된다.
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
@RequestMapping("/control/controller05/ok")
public class Controller05 {
  
  @RequestMapping(method=RequestMethod.GET) // OK요청 중에서 GET요청이 들어왔을 때 호출되는 메서드
  public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/plain;charset=UTF-8");  
    PrintWriter out = response.getWriter();
    out.println("get!");
  }
  
  @RequestMapping(method=RequestMethod.POST) // OK요청 중에서 POST들어왔을 때 호출되는 메서드
  public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/plain;charset=UTF-8");  
    PrintWriter out = response.getWriter();
    out.println("post!");
  }
  
}