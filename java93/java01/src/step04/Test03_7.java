/* 문장: 반복문 do ~ while - 반복문 중첩 + break + label*/
package step04;

public class Test03_7 {

  public static void main(String[] args) {
    int i = 2;
    
    while (i < 2) {
      System.out.println(i);
    }
    System.out.println("--------------------");
    
    i = 2;
    do { // 실행한다음에 계속할지 말지 묻는다.
      System.out.println(i);
    } while (i < 2); // i 가 2이하이면 반복하라.
  }
}

