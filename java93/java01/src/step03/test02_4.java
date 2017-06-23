/* 증가/감소 연산자 - 전위 및 후위 연산자의 차이점
 */
package step03;

public class test02_4 {

  public static void main(String[] args) {
    int i = 3;
    int r = ++i + ++i * ++i; // r = 4 + 5 * 6 = 4 + 30 = 34
    System.out.printf("i = %d, r = %d\n", i, r);
    
    
    i = 3;
    r = i++ + i++ * i++; // r = 3 + 4 * 5 = 3 + 20 = 23
    System.out.printf("i = %d, r = %d\n",i , r);
    
    i = 3;
    r = ++i + ++i * i++; // r = ++i + ++i * 3 = 5 + 6 * 3 = 5 + 18 => 이게아니다.
                         // r = 4 + 5 * 5 = 4 + 5 * 5 = 4 + 25 = 29 // i++는 i값을 먼저놓고 i 값을 증가시킨다.
                         // 전위 연산자와 후위 연산자는 섞어쓰지 않는다.
    System.out.printf("i = %d, r = %d\n",i , r);
    
  }
}
