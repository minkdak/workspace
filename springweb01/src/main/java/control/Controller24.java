/* Spring WebMVC: JSON 콘텐츠로 응답하기 + 파일 업로드 
 * => AJAX?
 */
package control;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/control/controller24/")
public class Controller24 {
  
  // JSON 데이터 내보내기
  
  // 1) @Controller + @ResponseBody를 사용한 방법
  @RequestMapping(path="upload1")
  @ResponseBody
  public Object upload1() throws Exception {
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("filename",  "test..ok");
    resultMap.put("filesize",  12345);
    return resultMap; // 
  }
}

