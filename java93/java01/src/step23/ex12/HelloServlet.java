package step23.ex12;

import java.io.PrintStream;

@WebServlet(url="/hello")
public class HelloServlet implements Command{ // 커맨드 규칙에 따라 만듦
  // http프로세서가 클라이언트가 요청이 들어올 때마다 그 규칙에 따라 처리한다.

  public void service(PrintStream out) throws Exception {
    out.println("HTTP/1.1 200 OK");
    out.println("Sever: Bit Server");
    out.println();
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>hello</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>ㅎㅇ!</h1>");
    out.println("</body>");
    out.println("</html>");
  }

}
