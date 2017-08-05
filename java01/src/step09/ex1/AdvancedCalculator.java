package step09.ex1;

public class AdvancedCalculator {
  int result;
  
  void plus(int value) {
 // 주어진 인스턴스(this)에 result라는 변수에서 파라미터로 주어지 value값을 저장한다
    this.result += value;  
  }
  
  void minus(int value) {
    this.result -= value;
  }
  
  // 새 곱하기 기능 추가.
  void multiple(int value) {
    this.result *= value;
  }
}
