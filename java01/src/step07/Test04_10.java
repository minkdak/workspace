/* 인스턴스 메서드들 끼리 호출하기
 * => 인스턴스에서 다른 인스턴스 메서드를 호출하는 것은 당연히 가능하다.
 */
package step07;

public class Test04_10 {
  static class Calculator {
    int value;
    
    Calculator(int value) {
      // Calculator.this.value = value;// 보통은 클래스 명을 생략한다
      this.value = value; // 어느게 로컬인지 인스턴스변수인지 구분할 수 없다. this생략하면안됨
                          // 인스턴스 변수의 이름과 같은  로컬 변수가 있기 때문에,
                          // this는 생략할 수 없다.
    }
    public void m1() {
      // 메서드 호출할 때 this를 안 붙이면, 자동으로 붙인다.
      /*Calculator.this.*/m2();
    }
    
    public void m2(){
      // 물론 우리가 직접 붙여도 된다.
      Calculator.this.m3();
      
      //클래스 이름을 생략할 수도 있고,
      //this.m3()
    }
    
    public void m3(){
      System.out.println(value); // value -> local변수를 찾아보고 없으면 this.를 붙인다.
    }
    
  }
  
  public static void main(String[] args) {
    // 인스턴스 메서드를 호출하려면 반드시 인스턴스가 있어야한다.
    Calculator c1 = new Calculator(100);
    Calculator c2 = new Calculator(200);
    Calculator c3 = new Calculator(300);
    
    c1.m1();
    c2.m1();
    c3.m1();
  }


}
