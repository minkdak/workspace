/* 상속문법을 사용한 후I
 * => BasicCalculaotr 클래스를 이용하여 더하기, 빼기를 수행한다.
 */
package step09.ex2;

public class BasicCalculator {
  int result;
  
  void plus(int value) {
 // 주어진 인스턴스(this)에 result라는 변수에서 파라미터로 주어지 value값을 저장한다
    this.result += value;  
  }
  
  void minus(int value) {
    this.result -= value;
  }
}
