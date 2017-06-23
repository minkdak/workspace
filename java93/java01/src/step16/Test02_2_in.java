/* File I/O - 바이트 스트림 클래스 - FileInputStreamII
 * => 바이트 배열 읽기
 */
package step16;

import java.io.FileInputStream;

public class Test02_2_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test02_2.data");
    byte[] bytes = new byte[1024];
    int len = 0;
    
    len = in.read(bytes);
    
    for (int i = 0; i < len; i++) {
      System.out.printf("%x\n", bytes[i]);
    }
    
    in.close();
  }
}
