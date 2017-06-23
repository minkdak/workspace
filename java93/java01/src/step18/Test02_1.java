/* 소켓 프로그래밍: 서버 소켓 대기열
 * => 서버 소켓을 생성할 때 대기열의 최대 개수를 지정할 수 있다.
 *    그 개수 만큼만 클라이언트의 연결 요청을 허락한다.
 * => 대기열이 꽉 찬 상태에서 다른 클라이언트 요청이 들어올 때,
 *    그 클라이언트는 timeout시간만큼 기다리다가
 *    그 때 까지 대기열에 자리가 나지 않으면 즉시 예외를 던진다.
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
// ServerSocket(port, backlog)
// => port: 포트번호
// => backlog: 대기열의 크기

public class Test02_1 {
  public static void main(String[] args) throws Exception{
    System.out.println("서버 실행 중...");
    
    
    ServerSocket serverSocket = new ServerSocket(8888, 3); // 백로그 개수 3개 지정.
    System.out.println("=> 서버 소켓 생성 완료");
    // 대기열에 기다리고 있는 클라이언트가 없다면, 리턴하지 않는다.
    Socket socket = serverSocket.accept();
    InputStream in0 = socket.getInputStream();
    OutputStream out0 = socket.getOutputStream();
    
    Scanner in = new Scanner(in0);
    PrintStream out = new PrintStream(out0);
    
    String str = in.nextLine(); // 클라이언트로부터 문자열을 한 줄 읽는다.
    out.println(str); // 클라이언트가 보낸 문자열을 그대로 돌려준다.
    
    in.close();
    in0.close();
    out.close();
    out0.close();
    socket.close();
    serverSocket.close();
    
  }
}
