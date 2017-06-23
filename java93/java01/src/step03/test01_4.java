/* 명시적 형변환(explicit type conversion) - 유니코드 char타입 
 */
package step03;

public class test01_4 {

  public static void main(String[] args) {
    int i = '가'; // 작은 따옴표 '가' 문자 유니코드 값을 리턴한다 = 44032
    System.out.println(i);
    System.out.println((char)i); // println() 함수에게 어떤 종류의 값인지 알린다.
  }
}
