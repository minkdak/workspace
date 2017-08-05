/* Class 도구 사용법: nested class 로딩 */

package step26;

import java.util.Date;

public class Test09 {
  static class My {}
  
  public static void main(String[] args) throws Exception{
    Class<?> c1 = My.class;
    Class<?> c2 = step26.Test09.My.class; // .으로 처리가능 
    Class<?> c3 = Class.forName("step26.Test09$My"); // 문자열로 지정할 때는 $를 사용한다.
    
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
  }
  
}
