/* 애노테이션 배열 속성 값추출하기
 * => RUNTIME 레벨의 애노테이션만 추출할 수 있다.
 */
package step25;

public class Test03 {
  public static void main(String[] args) throws Exception{
    Class clazz = Class03.class; 
    
    Annotation05 anno= (Annotation05)clazz.getAnnotation(Annotation05.class);
    
    // 애노테이션의 속성 값을 꺼낼 때는 메서드를 호출한다.
    System.out.printf("v1=%s\n", anno.v1()[1]);
    System.out.printf("v2=%s\n", anno.v2()[0]);
    System.out.printf("v3=%s\n", anno.v3()[0]);
    System.out.printf("v4=%s\n", anno.v4()[1]);
    System.out.printf("v5=%s\n", anno.v5()[0]);
    System.out.printf("v6=%s\n", anno.v6()[0]);
  }
}

