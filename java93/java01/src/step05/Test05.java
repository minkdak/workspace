/* 메서드 : 여러 개의 값을 리턴하고 싶을 때III*/
package step05;

public class Test05 {
  // 3) Map을 사용하면 값을 저장할 때 숫자가 아닌 문자열로 라벨을 붙일 수 있다.
  public static java.util.HashMap getStudent(int studentNo) {
    java.util.HashMap arr = new java.util.HashMap();
    arr.put("이름", "홍길동");
    arr.put("국어", 100);
    arr.put("영어", 90);
    arr.put("수학", 80);
    arr.put("총점", 100 + 90 + 80);
    arr.put("평균", (100 + 90 + 80) / 3f);
    return arr;
  }
  public static void main(String[] args) {
    java.util.HashMap map= getStudent(100);
    
    // Map에서 값을 꺼낼 때는 숫자가 아닌, 라벨을 사용해야 한다.
    System.out.println(map.get("이름"));
    System.out.println(map.get("국어"));
    System.out.println(map.get("영어"));
    System.out.println(map.get("수학"));
    System.out.println(map.get("총점"));
    System.out.println(map.get("평균"));
    // 자바스크립트의 프로퍼티 명처럼 이름(라벨)으로 꺼내 쓸 수 있다.
  }
}

