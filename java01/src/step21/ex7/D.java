/* 추상 클래스 4
 * => 상속 받은 메서드 중에서 추상 메서드가 있다면,
 *    무조건 구현해야만 일반 클래스가 된다.
 *    일반 클래스만이 인스턴스를 만들 수 있다.
 */

package step21.ex7;

// C는 상속 받은 메서드 중에서 추상 메서드 m2()를 구현하지 않았기 때문에
// 추상 클래스로 선언해야 한다.
public class D extends C {
  public void m2() {
    System.out.println("D.m2()...");
  }
  public void m4() {
    System.out.println("D.m4()...");
  }
 }
