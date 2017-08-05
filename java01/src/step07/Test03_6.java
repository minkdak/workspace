/* 초기화 블록: 생성자 IV
 * => 클래스는 여러 개의 생성자를 가질 수 있다.
 * => 파라미터의 개수나 파라미터 타입, 파라미터 순서로 구분된다.
 * => 그러나 변수 이름하고는 상관없다.
 * => 인스턴스를 생성할 때 반드시 여러 개의 생성자 중에서 호출될 생성자를 지정해야 한다.
 * => 문법
 *    new()?
 */
package step07;

public class Test03_6 {
  static class Student {
    int age = 20;

    Student(int a) {
      System.out.println("Student(int)...호출");
      this.age = a;
    }

    Student(int a, String n) {
      System.out.println("Student(int, Stirng)...호출");
      this.age = a;
    }
    
    Student(String n, int a) {
      System.out.println("Student(Stirng, int)...호출");
      this.age = a;
    }

  }
  
  public static void main(String[] args) {
    // new Student(); // 기본 생성자 
    new Student(20); 

    new Student("홍길동", 20);
    new Student(20, "홍길동");
    
  }


}
