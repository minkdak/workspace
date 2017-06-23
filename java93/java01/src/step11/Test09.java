/* 캡슐화(encapsulation): 필드와 프로퍼티
 */
package step11;

public class Test09 { 
  
  static class Student {
    public static final int HIGH_SCOOL = 1;
    public static final int BACHELOR = 2;
    public static final int MASTER = 3;
    public static final int DOCTOR = 4;

    // 필드 선언 - 보통 접근을 막는다.
    private String name;
    private int age;
    private int level;
    
    // 프로퍼티 선언
    // => 필드의 값을 넣거나 꺼내는 메서드.
    // => setXxx()/getXxx() 이름으로 메서드를 정의한다.
    // => 그래서 setXxx() 메서드를 셋터(setter)라고 부른다.
    // => 그래서 getXxx() 메서드를 겟터(getter)라고 부른다.
    
    // 보통 필드명과 필드명과 프로퍼티명은 같게 한다.
    // 필드명: "name"
    // 프로퍼티명: "fullName"
    public void setFullName(String fullName) {// 보통 공개한다.
      this.name = fullName;
    }
    public String getFullName() {
        return name;
      
    }
    
    // 필드명: "age"
    // 프로퍼티명: "age"
    public void setAge(int age) {
      if (age > 5 && age < 100) {
        this.age = age;
      }
      throw new RuntimeException("나이는 6에서 99살까지 가능합니다.");
    }
    public int getAge() {
      return age;
    }
    
    public void setSchoolLevel(int level) {
      if(level >= 1 && level <=4) {
        this.level = level;
      }
      throw new RuntimeException("학위 정보는 1에서 4까지 가능합니다.");
    }
    public int getSchoolLevel() {
      return level; 
    }
  public static void main(String[] args) {
    Student s = new Student();
    s.setFullName("홍길동");
    s.setAge(20);
    s.setSchoolLevel(Student.DOCTOR); // 4라고 쓰는 것보단 이렇게.
  }
  
}
}

