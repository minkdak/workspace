/* 기타 연산자 : 조건 연산자(? :)
 */
package step03;

public class test03_3 {
  public static void main(String[] args) {
    String s = (5 % 2) == 0 ? "짝수" : "홀수"; // 0이면 짝수 아니면 홀수
    System.out.println(s);
  }
}