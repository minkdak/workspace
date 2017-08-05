/* Spring WebMVC: Request Handler의 파라미터 IV - 커스텀 프로퍼티 에디터II
 * => 커스텀 프로퍼티 에디터를 등록하는 방법
 * 1) 각각의 페이지컨트롤러에 @InitBinder 애노테이션이 붙은 메서드 만들기
 *    => controller13.java 참고
 *      @InitBinder
    protected void initBinder(WebDataBinder binder) { // 한번 등록하고 끝이 아니라 매번 호출된다.
      ....
    }
 * 2) WebBindingInitializer 인터페이스를 구현한 클래스를 만들어 설정 파일 등록하기
 *    => MyWebBindingInitializer.java와 application-context.xml 참고
 * 3) 페이지 컨트롤러가 작업하기 전에 충고를 하는 클래스 만들기
 *    => spring 3.2 부터는 @ControlAdvice가 붙은  클래스에 등록한다.
 *    => @ControlAdvice가 붙은 클래스를 만든다.
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller14/")
public class Controller14 {

  // 모든 페이지 컨트롤러가 사용할 프로퍼티 변환기 설치하기
  @RequestMapping("ok1")
  public void ok1(
      String name, // @RequestParam이 붙이지 않으면, 기본이 선택항목이다.
      java.util.Date date, 
      boolean working,
      HttpServletResponse response) throws Exception {
  response.setContentType("text/plain;charset=UTF-8");
  PrintWriter out = response.getWriter();
  out.println("ok1()");
  out.println(name);
  out.println(date);
  
 }
}