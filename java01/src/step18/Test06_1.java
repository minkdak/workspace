/* 소켓 프로그래밍: Echo 서버 만들기 
 */
package step18;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test06_1 {
  static class EchoThread extends Thread {
    Socket socket;
    
    public EchoThread(Socket socket) {
      this.socket = socket;
    }
    
    public void run() {
      try (
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
       ) {
        String message = in.nextLine();
        out.println("[밍그닥] : " + message);
      } catch (Exception e) {}
      
    }
  }
  public static void main(String[] args) throws Exception{
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("서버 실행 중ㅇ......ㅇ......");
    
    while (true) {
      new EchoThread(serverSocket.accept()).start(); // 만약 클라이언트가 연결되면.
    }
  } 
}
    

