/* File I/O - 바이트 스트림 클래스 - 
 * => ByteArrayInputStrea/ByteArrayOutputStream을 상속받아
 *    다양한 타입의 데이터를 읽고 쓰도록 기능을 추가한다.
 */
package step16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Test03_4 {

  public static void main(String[] args) throws Exception {
    ByteArrayOutputStream out0 = new MyArrayOutputStream();
    DataOutputStream out = new DataOutputStream(out0);
    
    byte b = 0x11;
    out.writeByte(b);
    
    short s = 0x2233;
    out.writeShort(s);
    
    int i = 0x44556677;
    out.writeInt(i);

    String str = "ABC가각간";
    out.writeUTF(str);
    
    // 출력 스트림 객체에 부관된 데이터를 배열로 뽑아낸다.
    byte[] buf = out0.toByteArray();
    out.close();
    
    ByteArrayInputStream in0 = new ByteArrayInputStream(buf);
    DataInputStream in = new DataInputStream(in0);
    
    byte b2 = in.readByte();
    
    short s2 = in.readShort();
    
    int i2 = in.readInt();
    String str2 = in.readUTF();
    in.close();
    
    System.out.println();
    
    System.out.printf("%x, %x, %x, %s\n", b2, s2, i2, str2);
    
    
  }
}
