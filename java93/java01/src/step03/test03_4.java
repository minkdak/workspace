/* 기타 연산자 : 비트 논리 연산자(&, |, ^, ~)
 */
package step03;

public class test03_4 {
  public static void main(String[] args) {
    int a = 0b1100_1010;
    int b = 0b0101_0101;
    
    int r = a & b; // 0100_0000
    String str = Integer.toBinaryString(r);
    System.out.println(str);
    
    // r = a || b;//둘중하나라도 1이면 1이다. 1101_1111;
    
    r = a | b; // 1101_1111; 오로지 정수값에 대해서만 의미가 있다.
              //(float)a | 이런식으로 할 수 없다.
    System.out.println(Integer.toBinaryString(r));
    
    r = a ^ b; //1001_1111; // 배타적 or : 둘의 값이 다를 때만 1이다.
    System.out.println(Integer.toBinaryString(r));
    
    r = ~a; // 0011_0101
    System.out.println(Integer.toBinaryString(r));
  }
}
