package step02;

public class prac01 {

 static class Student {
    String name;
    int scores;
    int age;
    
    Student(String name, int scores, int age) {
      this.name = name;
      this.scores = scores;
      this.age = age;
       
    }
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Student s1 = new Student("홍길동", 20, 10);
\    System.out.println(s1.name + s1.age);
  }

}
