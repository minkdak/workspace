/* 변수 선언 - 정수 리터럴과 2진수, 8진수, 10진수, 16진수
 */

package step01;

public class Test03 {
  
  public static void main(String[] args) {
    //1) 그냥 숫자를 작성하는 것은 4바이트 크기의 정수 값을 의미한다.
    System.out.println(-10);
    System.out.println(10);
    System.out.println(2147483647); // 4바이트 양의 정수 최대 값 // 1을 더하면 바로 에러 4바이트로 표현할 수 있는 정수의 범위를 넘었다.
    System.out.println(-2147483648); // 4바이트 음의 정수 최대 값
 // javascript는 숫자에 대한 고민이 별로 없었다.
    
   
    //2) 8바이트 정수 값을 표현할 때는 숫자 뒤에 'L'또는 'l'을 붙인다.
    System.out.println(-10L); // 대문자 'L'을 붙여도 되고
    System.out.println(10l); // 소문자 'l'을 붙여도 된다. 글너데 숫자 1과 소문자 'l'을 구분하기 어렵기 때문에 주로 대문자를 사용한다.
    System.out.println(2147483648L); // 4바이트 양의 정수 최대 값을 넘어도 괜찮다.
    System.out.println(-2147483649L); // 8바이트 음의 정수 값
   
    System.out.println(9223372036854775807L);
    System.out.println(-9223372036854775808L);
  }
}
