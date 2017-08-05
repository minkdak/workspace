package step14;

// 클래스 선언부에 이 클래스가 다룰 타입이 무엇인지 
// 타입 정보를 받을 변수를 선언한다.
// 보통 그 변수의 이름은 T (Type의 약자)를 사용한다.
public class Bucket2<T> {
  T value;
  
  public void setValue(T value) { // 자바의 모든 객체를 담을 수 있다.
    this. value = value;
  }
  
  public T getValue() {
    return value;
  }
}
