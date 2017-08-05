/* 문장: 반복문 for II */
package step04;

public class Test03_9 {

  public static void main(String[] args) {
    // for (변수 선언: 배열) 오직 이렇게 쓴다. 바깥에서 변수선언 할 수 없다.
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (int value : arr) { // javascript: for (var value of arr) {...}
      System.out.print(value + ",");
    }
    System.out.println();
    System.out.println("------------------------");
    
    // for (변수 선언 : Collection 타입)
    // 객체임
    java.util.ArrayList arr2 = new java.util.ArrayList(); // int값이 List에 들어간다.
    arr2.add(10);
    arr2.add(20);
    arr2.add(30);
    
    for (Object value : arr2) { // 단점 : 어디서 어디까지 반복할지 지정할 수 없다.
      System.out.print(value + ",");
    }
  }
}

