/* File I/O - 바이트 스트림 클래스 - java.io.DataOutputStream
 * => 상속이 아닌 위임이라는 방버을 사용해서 기능 확장하기
 */
package step16;

import java.io.FileOutputStream;
import java.io.DataOutputStream;

public class Test02_7_out {

  public static void main(String[] args) throws Exception {
    FileOutputStream out0 = new FileOutputStream("Test02_7.data");
    java.io.DataOutputStream out = new java.io.DataOutputStream(out0);
    
    byte b = 0x11;
    out.writeByte(b);
    
    short s = 0x2233;
    out.writeShort(s);
    
    int i = 0x44556677;
    out.writeInt(i);

    String str = "ABC가각간";
    out.writeUTF(str);
    
    
    out.close();
  }
}
