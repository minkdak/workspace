package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {
  @RequestMapping("/control/controller01")
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
response.setContentType("text/plain;charset=UTF-8");
PrintWriter out = response.getWriter();
out.println("Hello, world");
  }
}
