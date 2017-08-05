/* 초기화 블록: 인스턴스 블록
 * => 인스턴스가 생성된 후 자동으로 실행하는 블록
 * => 한 클래스 안에 여러 개의 인스턴스 블록을 넣을 수 있다.
 * => 인스턴스를 생성한 후, 생성자가 호출되기 전에
 *    인스턴스 블록은 선언된 순서대로 실행된다.
 * => 문법
 *    {...}
 * => 용도
 *    클래스 변수를 초기화시키는 코드를 둔다.
 *    어떤 생성자가 호출되든 그 전에 공통으로 초기화시키고 싶은
 *    작업이 있다면 인슽너스 블록에서 처리하면 된다.
 */
package step07;

public class Test03_2 {
  static class Student {
    static String name = "홍길동";
    int age = 20;
    static { 
      System.out.println("static...1");
    }
    { // 인스턴스 블록
      // 인스턴스 블록은 인스턴스 주소를 보관한 this라는 변수가 내장되어 있다.
      System.out.println(age);
      System.out.println("{인스턴스 블록 실행...1}");
      this.age = 30;
    }
    
    {
      System.out.println("{인스턴스 블록 실행...2}");
    }
  }
  
  public static void main(String[] args) {
    new Student(); // 주소를 안받아도 에러가 아니다.
    // 인스턴스 생성된 후에 일어나는 일을 알기 위해 사용한것이기 때문에 굳이 주소를 안받았다
    System.out.println("--------------------");
    new Student();
    // static 블록은 한번만 실행한다.
    // 이미 클래스 메모리가 생성되어 있기 때문에.
  }


}
