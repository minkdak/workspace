package step14;

public class Bucket {
  Object value;
  
  public void setValue(Object value) { // 자바의 모든 객체를 담을 수 있다.
    this. value = value;
  }
  
  public Object getValue() {
    return value;
  }
}
