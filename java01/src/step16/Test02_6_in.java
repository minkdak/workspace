/* File I/O - 바이트 스트림 클래스 - MyDataInputStream
 * => FileInputStream을 상속받아 다양한 타입의 데이터를 읽을 수 있도록 기능 추가.
 *    이 클래스를 사용하여 데이터를 읽어보자
 */
package step16;

import java.io.FileInputStream;

public class Test02_6_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in0 = new FileInputStream("test02_6.data");
    DataInputStream in = new DataInputStream(in0);
    byte b = in.readByte();
    
    short s = in.readShort();
    
    int i = in.readInt();
    
    String str = in.readUTF();
   
    System.out.printf("%x, %x, %x, %s", b, s, i, str);
    
    in.close();
  }
}
