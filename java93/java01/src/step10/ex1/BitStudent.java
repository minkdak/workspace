package step10.ex1;

public class BitStudent extends Student{
  String school;
  
  void print() { // 재정의
    // 수퍼 클래스의 메서드를 재정의할 때 
    // 기존 코드를 복사/붙여넣기 하는 대신
    // 재정의하기 전의 기존 메서드를 호출하는 것이 편하다.
    /*
    System.out.printf("이름: %s\n", name); 
    System.out.printf("나이: %d\n", age);
    System.out.printf("학교: %s\n", school);
    */
    // 재정의하기 전의 메서드를 가리키기 위해
    // (주의! 수퍼 클래스라는 의미가 아니다.-Student라는 수퍼 클래스가 아니다. 추후 설명)
    // super라는 키워드를 사용하여 메서드를 호출한다.
    super.print(); // 이 클래스에서 재정의하기 전의 print() 메서드를 호출하라!
    System.out.printf("학교: %s\n", school);
    // print();// 이렇게 해야 되는데 이렇게 해봤자 원래 지거임
    
  }
}
