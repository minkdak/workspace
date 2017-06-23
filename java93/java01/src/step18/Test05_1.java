/* 소켓 프로그래밍: HTTP 클라이언트 만들기
 */
package step18;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Test05_1 {
  public static void main(String[] args) throws Exception{
    if (args.length < 1) {
      System.out.println("[사용법] > java -cp bin step18.Test05_1 URL");
      return;
    }
    
    // URL에서 host 주소, 포트 번호를 분리하고 자원경로를 분리한다.
    // 예) http://www.google.com:80/test.html
    // => host : www.google.com
    // => port : 80
    // => path : /test.html
    String url = args[0].replace("http://", "");
    
    // url에 콜론(:)이 있다면 포트 번호가 있다는 것이다.
    String host = null;
    int port = 80;
    int colonIndex = url.indexOf(":");
    int firstSlashIndex = url.indexOf("/");
    String path = url.substring(firstSlashIndex); // 첫 번째 슬래시부터 끝까지.
    
    if (colonIndex >= 0) {
      host = url.substring(0, colonIndex);
      port = Integer.parseInt(url.substring(colonIndex + 1, firstSlashIndex));
    } else {
      host = url.substring(0, firstSlashIndex);
    }
    
    System.out.println(url);
    System.out.println(host);
    System.out.println(port); // 포트번호 지정하지 않으면 기본이 80번
    System.out.println(path);
    
    
    
    try (
    Socket socket = new Socket(host, port);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintStream out = new PrintStream(
                        new BufferedOutputStream(socket.getOutputStream()));) {   
    
    // [HTTP 서버에게 요청 데이터를 보낸다.]
    // 1) request line : 예) GET /test/ok/index.html HTTP/1.1 CRLF
    out.printf("GET %s HTTP/1.1\n", path);
    
    // 2) header(general + request + entity) - 예) Host: www.daum.net
    // => 최소 Host 헤더 데이터를 보내야 한다.
    out.printf("Host: %s\n", host);
    
    // 3) 요청 데이터의 끝을 의미하는 줄 바꿈 코드를 보낸다.
    out.println();
    out.flush(); // bufferedoutputstream을 썻기 때문에
        
    // [HTTP 서버가 응답한 데이터를 읽는다.]
    String str = null;
    while (true) {
      str = in.readLine();
      System.out.println(str);
      if (str.length() == 0) {
        break;
      }
    }
    
    int ch;
    while ((ch = in.read()) != -1) { //캐릭터 문 출력 
      System.out.print((char)ch);
    }
    } catch (Exception e) {
      e.printStackTrace();
    }
  } 
}
    

