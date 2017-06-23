package step15;

public class Student2 {

  private String name;
  private int age;
  private SchoolLevel schoolLevel;
  
  
  
  @Override
  public String toString() {
    return "Student2 [name=" + name + ", age=" + age + ", schoolLevel=" + schoolLevel + "]";
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public SchoolLevel getSchoolLevel() {
    return schoolLevel;
  }
  public void setSchoolLevel(SchoolLevel schoolLevel) {
    // SchoolLevel 이 넘어오기 때문에 유효한지 검사할 필요가 없다.    
    this.schoolLevel = schoolLevel;
    return;
  }
  
}
