/* 웹 애플리케이션 실행하기
 * 1) 클라이언트가 요구하는 자원의 경로를 알아내기
 */

package step23.ex7;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
  int port;
  public HttpServer(int port) {
    this.port = port;
  }
  
  public void listen() throws Exception{
    ServerSocket serverSocket = new ServerSocket(this.port); // 포트번호가 사용중이면 에러가 뜨는데,(예외발생)
    System.out.println("서버 실행 중...");
    
    while (true) {
      new HttpProcessor(serverSocket.accept()).start();
  }
}
  
  public static void main(String[] args) throws Exception { 
    HttpServer server = new HttpServer(8888);
    server.listen();
  }
  
  class HttpProcessor extends Thread {
    Socket socket;
    public HttpProcessor (Socket socket) {
      this.socket = socket;
    }
    
    public void run() {
      try (
      Socket socket = this.socket;      
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));) 
      {
      String line = null;
      boolean requestLine = true;
      
            while (true) {
              line = in.readLine();
              if (line.isEmpty())
                break;
              
              if (requestLine) {
              System.out.println(line);
            
              
              System.out.printf("url: '%s'\n", extractUrl(line));
              requestLine = false;
              }
            }
            
        out.println("HTTP/1.1 200 OK");
        out.println("Sever: Bit Server");
        out.println();
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>hello</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("  <h1>ㅎㅇ</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      
      
  } // run
    private String extractUrl(String requestLine) {
      String url = requestLine.substring(requestLine.indexOf(" ") + 1, requestLine.lastIndexOf(" "));
      return url;

    }
}
  
}
