/* character stream 클래스 : FileWriter vs FileOutputStream
 * => 객체 출력하기!
 * => 
 * Student.class
 */
package step16;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class Test06_1_out {

  public static void main(String[] args) throws Exception {    
    FileOutputStream out = new FileOutputStream("temp/test06_1_data.data");
   
    out.write('A'); // 0x0041
    out.write('B'); // 0x0042
    out.write('C'); // 0x0043
    out.write('a'); // 0x0061
    out.write('b'); // 0x0062
    out.write('c'); // 0x0063
    out.write('가'); // 0xac00
    out.write('각'); // 0xac01
    out.write('간'); // 0xac04
    
 
    out.close();
    
    FileWriter out2 = new FileWriter("temp/test06_1_.char.data");
    // CHARACTER stream 클래스 유니코드를 OS 기본 문자집합의 코드 값으로 벼노한하여 출력한다.
    // 만약 출력할 때 사용할 문자집합을 지정한다면, JVM은 그 문자 집합의 코드 값으로 변환하여 출력할 것이다.
    // 방법?
    // 예) > java -Dfile.encoding-utf8 step16.Test06_1_out
    out2.write('A'); // 0x0041 --> 41
    out2.write('B'); // 0x0042 --> 42
    out2.write('C'); // 0x0043 --> 43 
    out2.write('a'); // 0x0061 --> 61
    out2.write('b'); // 0x0062 --> 62
    out2.write('c'); // 0x0063 --> 63
    out2.write('가'); // 0xac00 --> eab080
    out2.write('각'); // 0xac01 --> eab081
    out2.write('간'); // 0xac04 --> eab084
 

    out2.close();
  }
}
