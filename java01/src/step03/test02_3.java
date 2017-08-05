/* 증가/감소 연산자 - 전위 및 후위 연산자의 차이점
 */
package step03;

public class test02_3 {

  public static void main(String[] args) {
    //1) 전위(pre-ix) 연산자
    //=> 변수의 값을 먼저 증가시킨 다음에, 그 자리에 현재 변수의 값을 놓는다.
    int x = 0;
    int i = 10;
    
    
    i = ++i; 
    /* 실행순서
     * => i = i + 1 : 11
     * => i = 11
     * => i <== 11
     */
    System.out.printf("i = %d\n", i); // %s: 문자열 
    
    
    //2) 후위(post-fix) 연산자
    //=> 현재 자리에 변수의 값을 먼저 놓고, 변수의 값을 증가 시킨다.
    i = 10;
    
    i = i++; 
    /* 실행순서
     * => i = 10
     * => i = i + 1 : 11
     * => i <== 10 을 다시 집어넣는다.
     * i 는 11이 되었다가 아래에서 다시 10이 된다.
     */
     System.out.printf("i = %d", i);
    
  }
}
