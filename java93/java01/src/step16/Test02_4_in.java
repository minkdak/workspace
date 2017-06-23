/* File I/O - 바이트 스트림 클래스 - FileInputStreamII
 * => 바이트 배열 읽기
 */
package step16;

import java.io.FileInputStream;

public class Test02_4_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test02_4.data");
    
    byte b;
    b = (byte)in.read();
    
    short s;
    s = (short)(in.read() << 8);
    s |= (short)(in.read());

    int i;
    i = (int)(in.read() << 24);
    i |= (int)(in.read() << 16);
    i |= (int)(in.read() << 8);
    i |= (int)(in.read());
    
    int len;
    len = (int)(in.read() << 24);
    len |= (int)(in.read() << 16);
    len |= (int)(in.read() << 8);
    len |= (int)(in.read());
    
    byte[] buf = new byte[len];
    
    // 
    String str = new String(buf, "UTF-8");
   
    System.out.printf("%x, %x, %x, %s", b, s, i, str);
    
    in.close();
  }
}
