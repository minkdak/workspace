package step10.ex1;

public class Student {
  String name;
  int age;
  
  void print() {
    System.out.printf("> 이름: %s\n", name);// Student.this.name 이게 정석이지만 충돌하는 것이 없다면 생략할 수 있도록 
    System.out.printf("> 나이: %d\n", age);//자바에서 이해하는 것이다.
  }
}
