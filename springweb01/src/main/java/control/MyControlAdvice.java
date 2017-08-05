// 요청 파라미터를 요청 핸들러의 아규먼트 타입으로 바꿔주는 변환기 등록하기
package control;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;


// 스프링 WebMVC 프레임워크에게 요청을 처리할 때 마다 이 클래스에게 조언을 구할 것을 요구한다.
@ControllerAdvice
public class MyControlAdvice {
  // 이 클래스에 페이지 컨트롤러를 위한 다양한 충고 작업을 수행하는 코드를 둔다.
  
  // @InitBinder라는 충고는,
  // => 요청 파라미터의 데이터를 요청 핸들러의 아규먼트 값으로 바꿀 때 마다 호출한다.
  @InitBinder
  protected void initBinder(WebDataBinder binder) {
      System.out.println("MyControlAdvice.InitBinder()....");
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      dateFormat.setLenient(false);
      
      binder.registerCustomEditor(
          java.util.Date.class,
          new CustomDateEditor(
              dateFormat,
              false));
  }
}
