/* 문장: 반복문 for */
package step04;

public class Test03_8 {

  public static void main(String[] args) {
    // 정석 , 나머지는 권장하지 않음. 문법적 오류는 아니다.
    for (int i = 2; i <= 9; i++) { // int i =2 는 딱한번 실행; 참이면 i출력 -> i++ 참이면 출력 ->반복
      System.out.print(i + ",");
    }
    System.out.println();
    //i = 20; // for 문 안에 선언된 변수는 블록을 벗어나면 사용수할  없다.
    System.out.println("--------------------");
    
    
    int i = 2;
    for (; i <= 9; i++) {
      System.out.print(i + ",");
    }
    System.out.println();
    i = 2; // for 문 밖에 선언했기 때문에 변수를 사용할 수 있다.
    System.out.println("--------------------");
    
    i = 2;
    for (; i <= 9;) {
      System.out.print(i + ",");
      i++;
    }
    System.out.println();
    System.out.println("--------------------");
    
    i = 2;
    for (;;) {
      System.out.print(i + ",");
      i++;
      if (i > 9) 
        break;
    }
    System.out.println();
    System.out.println("--------------------");
  }
}

