/* Class 도구 사용법: 클래스의 메서드 알아내기 */

package step26;

import java.lang.reflect.Method; // 메서드 정보를 알고 싶으면 이기능을 써라 여기에 그기능이 있다.

public class Test04 {
  
  public static void main(String[] args) throws Exception{
    Class<?> clazz = MyClass.class;
    
    Method m = clazz.getMethod("m1"); // 문자열로 메서드 이름 찾음
    System.out.println(m);
    
    // 일치하는 메서드를 찾지 못했을 때? null을 리턴하는 것이 아니라 예외가 발생한다.
    // m = clazz.getMethod("m1", String.class); // m1이름을 가진 String 타입의 파라미터 값을 가지는 메서드를 찾아라
    // System.out.println(m); //응 없어~
    
    Method m2 = clazz.getMethod("m2", int.class);
    System.out.println(m2);
    
    Method m3 = clazz.getMethod("m3", String.class, int.class);
    System.out.println(m3);
  }
  
}
