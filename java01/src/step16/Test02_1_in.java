/* File I/O - 바이트 스트림 클래스 FileInputStream
 */
package step16;

import java.io.FileInputStream;

public class Test02_1_in {

  public static void main(String[] args) throws Exception {
    //1) FileOutputStream 객체
    FileInputStream in = new FileInputStream("Test02_1.data");
    
    // read():int 
    // => 무조건 1 바이트만 읽는다.
    // => 하지만 리턴 타입이 int이기 때문에 int 타입 변수로 값을 받아야 한다.
    
    int b = in.read();
    System.out.printf("%x ", b);
    
    b = in.read();
    System.out.printf("%x ", b);
    
    b = in.read();
    System.out.printf("%x ", b);
    
    
    // 출력 스트림을 다 사용했으면 파일을 닫아라.
    // => 파일을 다루기 위해 준비했던 메모리를 해제시킨다.
    // => OS s파일 시스템과의 연결도 끊는다.
    in.close();
  }
}
