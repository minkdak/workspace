/* 추상 클래스 2
 * => 추상 클래스는 추상 메서드를 가질 수 있다.
 * => 일반 클래스는 추상 메서드를 가질 수 없다.
 *    이유? 일반 클래스에서 추상 메서드를 갖는게 가능하다면,
 *          호출할 때 어떻게 되겠는가
 */

package step21.ex7;

public abstract class B {
  public static void sm1() {
    System.out.println("A.sm1()...");
  }
  
  public abstract void m2();
  
  // public abstract void m3() {} // 컴파일 오류!
 }
