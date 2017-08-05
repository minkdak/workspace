package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller02 {
  @RequestMapping("/control/controller02/a")
  public void a(HttpServletRequest request, HttpServletResponse response) throws IOException {
	response.setContentType("text/plain;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("aaaaa");
  }
  
  @RequestMapping("/control/controller02/b")
  public void b(HttpServletRequest request, HttpServletResponse response) throws IOException {
	response.setContentType("text/plain;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("bbbbb");
  }
	@RequestMapping("/control/controller02/c")
	  public void c(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("ccccc");
  }
}
