/* 다형성 - 다형적 변수
 * => 어떤 레퍼런스 변수는 그 타입의 인스턴스 뿐만 아니라,
 *    그 타입의 서브 클래스의 인스턴스까지 저장할 수 있다.
 */
package step10.ex2;

public class Test01 {
  public static void main(String[] args) {
    //참조 변수가 있는데 이 참조변수가 해당되는 객체 주소를 담을 수 있다.
    //자식 주소도 잠을 수 있고 자식의 자식 주소도 담을 수있다.
    // 그 동안 많이 본 형식
    Member m = new Member();
    Member m2 = new Student();
    FreeStudent f1 = new FreeStudent();
    Student s1 = new Student();
    
    
    // "다형적 변수(polymorphic variable)" - 다형성(polymophism)
    // => 한 개의 레퍼런스 변수가 다양한 종류의 객체 주소를 담을 수 있다.
    // 물론 Sub Class의 객체 주소만 담을 수 있다는 제약이 있다.
    Student s2 = new FreeStudent();
    Member m3 = new Teacher();
    Member m4 = new FreeStudent();
    // Student s2 = new Member(); 모든 학생이 멤버는 아니잖아?
    // FreeStudent s3 = new Student();
    
    // 구체적으로 지정하면 운신의 폭이 줄어들고, 유지보수가 어려워 진다.
  }
  
}
