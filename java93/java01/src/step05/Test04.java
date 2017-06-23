/* 메서드 : 여러 개의 값을 리턴하고 싶을 때II*/
package step05;

public class Test04 {
  // 1) 다른 종류의 값이라면 Collection 이나 Map 객체에 담아서 그 주소를 리턴하라!
  public static java.util.ArrayList getStudent(int studentNo) {
    java.util.ArrayList arr = new java.util.ArrayList();
    arr.add("홍길동");
    arr.add(100);
    arr.add(90);
    arr.add(80);
    arr.add(100 + 90 + 80);
    arr.add((100 + 90 + 80) / 3f);
    return arr;
  }
  public static void main(String[] args) {
    java.util.ArrayList list = getStudent(100);
    // getStudent()의 호출이 끝나더라도, 이 메서드에서 만든 객체는 "힙"에 계속 유지되기 때문에,
    // 그 객체의 주소만 알고 있으면 언제든지 그 객체를 찾아가 값을 꺼내 쓸 수 있다.
    for (int i = 0; i < list.size(); i++){
      System.out.println(list.get(i));
    }
  }
}

/*
 * 자바의 배열은 같은 타입의 데이터만 담을 수 있다.
 * 자바스크립트의 배열은 모든 타입의 데이터를 담을 수 있다.
 * java.util.ArrayList가 자바스크립트의 배열의 역할과 비슷하다.
 * 다만, 차이는 사용법에 있다.
 */
