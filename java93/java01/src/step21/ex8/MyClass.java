package step21.ex8;

// 인터페이스는 다중 구현이 가능하다.
// 인터페이스에 선언된 메서드는 모두 구현되지 않은 메서드이기 때문이다.
// 단 E 인터페이스 처럼 같은 이름과 같은 파라미터 타입을 가지지만,
// BC와 다르게 리턴 타입이 다른 경우
// 구현 클래스에서 도저히 BCE를 모두 만족시킬 수 없다.
// 이런 경우 다중 구현이 불가능하다.
public class MyClass implements B, C {
  public void m1() {}
  public void m2() {}
  public void m3() {}
  
  // B에 선언된 메서드 구현
  public void m4(){}
  public void m5(){}
  
  // C에 선언됨 메서드 구현
  // public void m5() // 이미 위에서 m6()를 구현했기 때문에 다시 구현할 필요가 없다.
  public void m6() {}
}