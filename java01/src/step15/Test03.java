/* 상수 값 다루기: enum 타입과 객체 그리고 메서드들
 * 
 */
package step15;

public class Test03 {
  public static void main(String[] args) {
    // enum 객체의 기본 값
    SchoolLevel[] values = SchoolLevel.values();
    
    for (SchoolLevel value: values) {
    System.out.printf("name() = %s\n",value.DOCTOR.name());
    System.out.printf("toString() = %s\n",value.DOCTOR.toString());
    System.out.printf("ordinal() = %s\n",value.DOCTOR.ordinal()); // 인덱스 값을 리턴하는 함수.
    System.out.println("----------------------------------");
    }
  }
}
