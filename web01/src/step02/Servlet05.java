/* 게시판 만들기: 게시물 목록 출력하기
 * 
 */
package step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step02/Servlet05")
public class Servlet05 extends GenericServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // 이렇게 출력스트림을 얻기 전에 먼저 호출해야 한다.
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    // 출력 스트림을 얻은 후에 호출해 봐야 소용없다.
    // res.setContentType("text/plain;charset=UTF-8");
    out.println("Hello, Wrold!");
    out.println("안녕하세요!");
  }
}
