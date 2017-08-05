/* File I/O - 바이트 스트림 클래스:
 * => 바이트 배열 메모리를 출력하는 클래스이다.
 */
package step16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Test03_1_out {

  
    
    // 스트리ㅣㅇ API 이용:
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    /* 일반 방식으로 바이트 배열에 데이터 
     * 
     */
    // 이 출력 스트림 객체는 파일이 아니라 내부에서 따로 관리하는
    // 바이트 배열 메모리로 출력한다.
    out.write(0x66778899); 
    out.write(0x77665544);
    out.write(0x12345678);
    
    // 이 출력 스트림 객체가 관리하는 바이트 배열 얻기
    byte[] buf = out.toByteArray();
    
    
    /* 일반 방식으로 바이트 배열에서 직접 데이터 읽기.
    for (byte b : buf) {
      System.out.printf("%x ", b);
    }
    */
    
    // 스트리밍 API를 사용해서 바이트 배열이서 값을 읽어보자!
    ByteArrayInputStream in = new ByteArrayInputStream(buf);
    
    int b = 0;
    while (true) {
      b = in.read();
      if (b == -1 )
      break;
      System.out.printf("%x", b);

    }
    out.close();
  }
}
