/* Spring WebMVC: 세션 다루기II
 * => @SessionAttributes 애노테이션 사용하기
 * => @SessionAttributes?
 *    => Model 에 저장된 객체 중에서 세션 보관소에 저장될 객체를 지정하는 애노테이션이다.
 *    => @SessionAttributes에 설정된 이름의 객체는 세션에 따로 보관한다.
 * => ModelAttribute ?
 *    => 세션 객체로부터 값을 꺼내라는 의미
 */
package control;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/control/controller21/")
@SessionAttributes({"member2"})
/* 야~ 프론트 컨트롤러야. Model 객체에 저장된
 * 보통 너는 Model 객체에 저장된 값을 JSP 가 사용할 수 있도록
 * ServletRequest에 옮겨주는 것을 알고 있다. 고맙다! JSP에서 잘쓰고 있다.
 * 그런데, 혹시 Model에 저장된 객체 값 중에 이름이 "member2"인 것이 있다면,
 * 그 객체는 ServletRequest 뿐만 아니라 세션에도 보관해주렴! *****
 */
public class Controller21 {
  @Autowired ServletContext servletContext;
  
  @RequestMapping("ok1")
  public String ok1(Model model) throws Exception {
    return "controller21_ok1";
  }
  
  @RequestMapping("ok2")
  public String ok2(String name, Model model) throws Exception {
    Member member2 = new Member();
    member2.setName(name);
    model.addAttribute("member2", member2); // 잠깐 모델에 담아서.
    return "controller21_ok2"; // 여기서 잠깐 쓴거에 불과한거.
  }
  
  @RequestMapping("ok3")
  /* 프론트 컨트롤러야!
   * 혹시 세션 객체에 member2라는 이름으로 보관된 Member 객체가 있냐?
   * 있으면 그 것을 아규먼트로 넘겨 주세요~~
   * 없다고? 그러면 그냥 새 Member 객체를 만들어서 주세요~~
   */
  public String ok3(@ModelAttribute("member2") Member member2) throws Exception { // 매번 새 객체가 만들어져서 안됐던 것이다.
    return "controller21_ok3";
  }
  
  @RequestMapping("ok4")
  public String ok4(@ModelAttribute("member2") Member member2) throws Exception {
    return "controller21_ok4";
  }
  
  @RequestMapping("reset")
  @ResponseBody
  public String reset(SessionStatus status) throws Exception {
    // setComplete()
    // => 현재 페이지에서 @SessionAttributes에 설정된 객체만 세션에서 제거한다.
    status.setComplete();
    return "completed the HttpSession!";
  }
}

