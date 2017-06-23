/* 소켓 프로그래밍 : connectionful 서버 만들기
 * => 한 번 서버와 연결되면 명시적으로 연결이 끊을 때까지 데이터를 주고 받는 방법
 * => 장점
 *    계속 연결된 상태로 있기 때문에, 
 *      - 바로 데이터를 주고 받을 수 있어 편리하다.
 *      - 작업 상태를 계속 유지할 수 있다.
 * => 단점
 *    계속 연결된 상태로 있기 때문에,
 *      - 사용 중이지 않을 때도 연결을 유지한다. 메모리 낭비!
 *      - 많은 클라이언트의 요청을 처리할 수 없다.
 *      
 * => 대표적인 프로토콜: HTTP, 메신저 등
 */
package messenger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class msg {
  class Value {
    String chat;
    String nick;
  }

  class bitMessanger implements Runnable {
    Socket socket ;
    
    public bitMessanger(Socket socket) {
      this.socket = socket;
      System.out.println("=> 클라이언트와 연결되었음!");
    }
    
    public void run() {
      try (
        Socket socket = this.socket;
        BufferedReader in = new BufferedReader(
                              new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
      ) {
        // 연결되어 있는 동안 계속 클라이언트와 통신하기 - connectionful
        while (true) {
          String json = in.readLine();
          if (json == null)
            break;
          System.out.println(json);
          
          Gson gson = new Gson();
          Value value = gson.fromJson(json,Value.class);// file 명이 아니라 class라는 변수
          System.out.println(value.chat);
//          System.out.println(value.nick);
//          out.println(value.nick + "님이 접속하셨습니다.\n");
          out.println("[minkdak]: " + value.chat);
          out.flush();
        }
        System.out.println("=> 클라이언와 연결 끊김!");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  public void listen(int port) throws Exception {
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new Thread(new bitMessanger(serverSocket.accept())).start();
    }
    
  }
  
  public static void main(String[] args) throws Exception {
    msg server = new msg();
    server.listen(8888);
    
  }
}








