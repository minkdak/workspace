/* File I/O - 바이트 스트림 클래스 - FileInputStreamII
 * => 바이트 배열 읽기
 */
package step16;

import java.io.FileInputStream;

public class Test02_3_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test02_2.data");
    byte[] bytes = new byte[1024];
    int len = 0;
    // read(배열주소 offset, length)
    // => 배열주소: 데이터를 저장할 배열
    // => offset: 저장할 위치(index; 0부터 ~ )
    // => length: "희망"하는 읽을 바이트수
    // => 리턴 값: 실제 읽은 바이트수
    len = in.read(bytes, 5, 2);
    
    for (int i = 0; i < 10; i++) {
      System.out.printf("%x", bytes[i]);
    }
    
    in.close();
  }
}
