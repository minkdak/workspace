/* nested class(=inner class)
 * => 클래스나 메서드 안에 클래스를 정의하는 문법
 * => 특정 클래스 안에서만 사용되는 클래스 안에 정의 한다.
 * => 특정 메서드 안에서만 사용되는 메서드 안에 정의 한다.
 * => 종류!
 *    1) static nested class
 *    2) none static nested class (= inner class)
 *    3) local inner class
 *    4) anonymous nested class
 */
package step13;

// package member class
public class test01 {

  // static nested class (=top level nested class)
  static class A {}
  
  // none static nested class (member inner class)
  class B {}
  
  public static void main(String[] args) {
    // local class
    class C {}
    
  // anonymous class  
  Object obj = new Object() {}; // 이름이없어서 바로 레퍼런스 선언
  
  // lamda로 nested 클래스 표현
  Runnable obj2 = () -> {};
  }

}
