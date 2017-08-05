/* class 문법의 용도: 관련된 메서드를 묶는 용도 VI
 * => 값을 개별적으로 관리하고 싶다면, 클래스에 선언된 변수 앞에 static을 붙이지 마라!
 * => static이 붙지 않은 변수를 "인스턴스 변수"라 부른다.
 *    이 변수는 new라는 명령에 의해 생성된다.
 * => 즉 static이 붙은 변수는 클래스를 사용하는 순간 자동으로 생성되고,
 *    static이 붙지 않은 변수를 new 명령을 사용하여 명시적으로 생성해야 한다.
 */
package step06;


public class Test02_7 {
  public static void main(String[] args) {
    Member3 m1 = new Member3();
    Member3 m2 = new Member3();
    Member3 m3 = new Member3();
    

    m1.init("홍길동", 100, 100, 100);
    m2.init("임꺽정", 90, 90, 90); 
    m3.init("유관순", 80, 80, 80); 
    
    m1.compute(); // 현재 유관순의 성적을 계산한다.
    m2.compute();
    m3.compute();
    
    m1.print(); // 현재 유관순의 성적을 출력한다.
    m2.print();
    m3.print();
  }

}


