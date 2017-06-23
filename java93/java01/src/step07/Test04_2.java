/* 인스턴스 메서드와 this 변수
 * => 모든 인스턴스 메서드는 this 변수를 내장하고 있다.
 * => this 변수에는 메서드를 호출할 때 받은 인스턴스 주소가 들어있다.
 * => 로컬 변수와 헷갈리지 않는다면 this를 생략할 수 있다.
 */
package step07;

public class Test04_2 {
  static class Calculator {
    int result;
    
    Calculator(int value) {
      result = value; // this 생략
    }
    public void plus(int value) {
      result += value;
    }
    
    public void minus(int value) {
      result -=value;
    }
    
  }
  
  public static void main(String[] args) {
    Calculator c1 = new Calculator(10); // 기본 생성자를 만들지 않아서 반드시 값을 받는 생성자를 호출
    c1.plus(10);
    c1.plus(20);
    System.out.println(c1.result);
    
  }


}
