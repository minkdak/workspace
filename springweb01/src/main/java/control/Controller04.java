/* Spring WebMVC: 요청 URL 계산하기 II
 * 요청 URL = class에 붙은 URL + 메서드에 붙은 URL  
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller04/ok")
public class Controller04 {
  
  @RequestMapping // 보이는건 메서드가 하나이지만 object 를 상속받았기 때문에 메서드가 한두가지가 아니다.
  // 반드시 붙여줘야한다.
  public void a(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/plain;charset=UTF-8");  
    PrintWriter out = response.getWriter();
    out.println("ok");
  }
  
}