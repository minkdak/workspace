/* 웹 서버 만들기
 * 1) 기본 클래스 골격 준비
 * 2) 클라이언트 연결 받기
 * 3) 소켓을 통해 입출력을 할 수 있게 스트림 객체를 준비한다.
 */

package step23.ex4;

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
      try (
      Socket socket = serverSocket.accept();      
      // 입출력 스트림 준비: 소켓이 연결되면 소켓으로 부터. 
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          // inputStream을 리턴하는데 바이트 스트림 타입이다. 그래서 캐릭터 스트림으로 바꿔줘야된다.
          // Reader가 어댑터 역할을 한다. ㅇㅋ??
      PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));) { // 그냥 써도됨.
        System.out.println("클라이언트가 연결되었습니다.");
      }
    }
  }
  
  public static void main(String[] args) throws Exception { // 리슨이 던지는 예외
    HttpServer server = new HttpServer(8888);
    server.listen();
  }
}
