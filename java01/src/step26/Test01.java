/* 클래스 정보를 다루는 도구 얻기 */

package step26;

public class Test01 {
  
  public static void main(String[] args) throws Exception{
    // 1) 인스턴스를 통해서 얻기
    String obj = new String("Hello"); // 이 스트링클래스에서 얻을 수 있다.
    Class<?> c1 = obj.getClass(); // ? -> 어떤 종류의 클래스든 다 가르킬 수 있다.
    // 인스턴스만 있으면 그 인스턴스가 어떤 클래스의 객체인지 쉽게 알아낼 수 있다
    
    //2) Class.forName() 메서드를 통해서 얻기
    Class<?> c2 = Class.forName("java.lang.String"); // 이 경우는 예외를 발생시킬 수 있다.
    // 주어진 문자열이 가르키는 클래스가 없을 수 있다. throws ㄱㄱ
    // => 클래스 이름을 문자열로 받을 수 있기 때문에 유지보수가 쉽다.
    
    // 3) 모든 클래스에 내장된 "class" 스태틱 변수를 통해서 얻기
    Class<?> c3 = String.class;
    // => 코딩이 쉽다. 그러나 클래스 이름을 코드로 명시하기 때문에 유지보수가 쉽다.
    
  }
}
