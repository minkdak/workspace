/* 웹 애플리케이션 실행하기
 * 1) 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) 
 * 3) 
 */

package step23.ex9;

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
  
  
  
}