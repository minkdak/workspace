/* File I/O - 바이트 스트림 클래스 - File OutputStream II
 * 
 */
package step16;

import java.io.FileOutputStream;

public class Test02_3_out {

  public static void main(String[] args) throws Exception {
    //1) FileOutputStream 객체
    FileOutputStream out = new FileOutputStream("Test02_3.data");
    
    byte[] bytes = {0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77};
    out.write(bytes, 2, 3);
    out.close();
    System.out.println("파일 출력 완료");
  }
}
