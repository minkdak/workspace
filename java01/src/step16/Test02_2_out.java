/* File I/O - 바이트 스트림 클래스 - File OutputStream II
 * 
 */
package step16;

import java.io.FileOutputStream;

public class Test02_2_out {

  public static void main(String[] args) throws Exception {
    //1) FileOutputStream 객체
    FileOutputStream out = new FileOutputStream("Test02_2.data");
    
    byte[] bytes = {0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77};
    out.write(bytes); // write메소드 중에서 바이트 배열을 주는 메소드가 있다   
    out.close();
    System.out.println("파일 출력 완료");
  }
}
