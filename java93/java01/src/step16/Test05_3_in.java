/* 데이터 프로세싱 스트림 클래스 - ObjectInputStream 도입 후
 * => 직렬화(serialize)를 통해 출력된 데이터의 경우,
 *    역직렬화(deserialize)를 통해 객체로 복원시킬 수 있다.
 */
package step16;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test05_3_in {

  public static void main(String[] args) throws Exception {
    
    FileInputStream in0 = new FileInputStream("temp/test05_3.data");
    ObjectInputStream in = new ObjectInputStream(in0);
    Student3 s = (Student3)in.readObject();
    
    
    in.close();
    in0.close();
    // 직렬화된 데이터를 읽어 드린 후에 계산을 수행한다.
    // 그러면 transient로 설정된 변수의 값이 계산될 것이다.

    System.out.println(s);
    
    s.compute();
    
    System.out.println(s);
  }
}
