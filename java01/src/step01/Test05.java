/* 리터럴 - 정수 리터럴과 2진수, 8진수, 10진수, 16진수
 */
package step01;

public class Test05 {

  public static void main(String[] args) {
    System.out.println(100); // 10진수//아무것도 안붙으면 10진수이다.
    System.out.println(0144); // 8진수 //앞에 0을 붙인다.
    System.out.println(0x64); // 16진수. 소문자 x를 더 많이 사용한다.
    System.out.println(0X64); // 16진수. 대문자 X를 써도 되지만
    System.out.println(0XA9); // 16진수의 숫자에서 a ~ f는 대.소문자 모두 가능
    System.out.println(0Xa9); // 16진수의 숫자에서 a ~ f는 대.소문자 모두 가능 169
    System.out.println(0b01100100); // 2진수. 소문자 b를 더 많이 사용.
    System.out.println(0B01100100); // 2진수. 대문자 사용 가능
  }
}
