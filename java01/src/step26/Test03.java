/* Class 도구 사용법: 클래스의 메서드 알아내기 */

package step26;

import java.lang.reflect.Method; // 메서드 정보를 알고 싶으면 이기능을 써라 여기에 그기능이 있다.

public class Test03 {
  
  public static void main(String[] args) throws Exception{
//    test1(); // 스태틱 환경, 인스턴스 메서드라면 인스턴스 주소가 붙어야 한다.
    // static 메서드는 this가 내장되어있지 않다.
    test2();
  }
  
  private static void test1() throws Exception {
    Class<?> clazz = MyClass.class;
    
    
    // 상속받은 메서드를 포함하여 모든 public 메서드만 추출한다.
    Method[] methodList = clazz.getMethods();// 메서드 목록을 리턴한다. 메서드 정보를 담은객체
    for (Method m : methodList) {
      System.out.println(m.getName());
    }
  }
  
  private static void test2() throws Exception {
    Class<?> clazz = MyClass.class;
    
    // 해당 클래스에 선언된 모든 메서드를 추출한다. 상속받은 메서드 제외
    Method[] methodList = clazz.getDeclaredMethods(); 
    for (Method m : methodList) {
      System.out.println(m.getName());
    }
  }
}
