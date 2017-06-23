package step16;

import java.io.Serializable;

// 이 클래스의 인스턴스 값을 직렬화하여 출력하는 것을 허락하자!
public class Student3 implements Serializable {
  private static final long serialVersionUID = 1L;
  
  String name;
  int kor;
  int eng;
  int math;
  transient int sum;
  transient float aver;
  boolean working;
  
  
  public Student3(String name, int kor, int eng, int math, boolean working) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = kor + eng + math;
    this.aver = this.sum/3f;
    this.working = working;
  }
  public Student3() {}

  @Override
  public String toString() {
    return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", aver="
        + aver + ", working=" + working + "]";
  }
  
  public void compute() {
    this.sum = kor + eng + math;
    this.aver = this.sum/3f;
  }
  
  
}
