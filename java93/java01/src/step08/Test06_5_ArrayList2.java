/* 목록을 다루는 클래스 구현 : 제네릭 적용
 */
package step08;

import java.lang.reflect.Array;

class Test06_5_ArrayList<T> {
  public static final int DEFAULT_SIZE = 3;
  public static final int GROW_SIZE = 3;
  
  private T[] list;
  private int length;
  
  public Test06_5_ArrayList() {
    list = (T[])new Object[DEFAULT_SIZE];
  }
  
  public Test06_5_ArrayList(int capacity) {
    if (capacity < DEFAULT_SIZE || capacity > GROW_SIZE) {
      list = (T[])new Object[DEFAULT_SIZE];
    } else {
      list = (T[])new Object[capacity];
    }
  }
  
  public void add(T obj) {
    list[length++] = obj;
    
    if (length  == list.length) {
      increaseList();
    }
  }
  
  public void add(int index, T obj) {
    if (length == list.length) {
      increaseList();
    }
    
    if (index < 0 || index > length) {
      throw new RuntimeException("인덱스 번호가 범위를 넘어갑니다.");
    }
    
    if (index < length) { // 값들 사이에 새 값을 꼽는다면,
      // 맨 마지막 값부터 index가 가리키는 방의 값까지 반복하면서 뒤로 한 칸씩 미룬다.
      for (int i = length; i > index; i--) {
        list[i] = list[i - 1];
      }
    }
    list[index] = obj;
    length++;
  }

  // ArrayList 클래스 내부에서만 사용할 메서드라면 굳이 공개하지 말라!
  // => 메서드 선언 앞에 private을 붙인다.
  private void increaseList() {
    T[] newList = (T[])new Object[list.length + GROW_SIZE];
    for (int i = 0; i < list.length; i++) {
      newList[i] = list[i];
    }
    list = newList;
  }
  
  public int size() {
    return length;
  }
  
  public T get(int index) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다.");
    }
    
    return list[index];
  }
  
  public T remove(int index) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다.");
    }
    T removedObj = list[index];
    
    if (index < (length - 1)) {
      for (int i = index; i < (length - 1); i++) {
        list[i] = list[i+1];
      }
    }
    length--;
    return removedObj;
  }
  
  public T set(int index, T obj) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("배열 인덱스의 범위를 벗어났습니다.");
    }
    
    T oldObj = list[index];
    list[index] =obj;
    return oldObj;
  }
}







