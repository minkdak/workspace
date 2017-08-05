/* Spring WebMVC:
 *  
 */
package control;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/control/controller17/")
public class Controller17 {

  // ServletContext 객체는 Request Handler의 아규먼트로 받을 수 없다.
  // 대신에 주입시켜 달라고 요청하라!
  @Autowired ServletContext servletContext;
  
  // 1) 업로드 파일 받기
  //    => controller16_ok1_form.html 에서 요청할 것!
  @RequestMapping("ok1")
  @ResponseBody
  public String ok1(String[] name, int[] age) throws Exception {
    for (String n : name) {
      System.out.printf("name: %s\n", n);
    }
    
    for (int a : age) {
      System.out.printf("age: %d\n", a);
    }
    
    return "controller17_ok1";
 }
}

