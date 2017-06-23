/* 컬렉션(Collection) 클래스 II : java.util.HashSet V   
 */
package step08;

import java.util.HashMap;
import java.util.Iterator;

public class Test07_8 {
  
  static class Book {
    String title;
    String press;
    int page;
    
    public Book(String title, String press, int page) {
      this.title = title;
      this.press = press;
      this.page = page;
    }
    
    public String toString() {
      return String.format("%s,%s,%d", title, press, page);
    }

    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + page;
      result = prime * result + ((press == null) ? 0 : press.hashCode());
      result = prime * result + ((title == null) ? 0 : title.hashCode());
      return result;
    }

    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Book other = (Book) obj;
      if (page != other.page)
        return false;
      if (press == null) {
        if (other.press != null)
          return false;
      } else if (!press.equals(other.press))
        return false;
      if (title == null) {
        if (other.title != null)
          return false;
      } else if (!title.equals(other.title))
        return false;
      return true;
    }
    
    
  }
  
  public static void main(String[] args) {
    HashMap map = new HashMap ();
    
    /* put(key, value)
     * key 객체:
     *    => key 객체: key 객체의 hashCode() 리턴 값을 사용하여
     *       value를 저장할 때 사용 위치를 계산한다.
     *    => 그래서 key 객체는 같은 값을 가진 객체인 경우 같은 
     *       hashCode()를 리턴하는 클래스를 사용한다.
     *       예) String, 랩퍼 클래스(Byte, Short, Integer, Long,
     *                               Float, Double, Boolean, Character)
     * value 객체: Map 컬렉션에 보관될 값
     */
    map.put(new String("key1"), new Book("aaaa", "비트출판사", 100));
    map.put("key2", new Book("bbbb", "비트출판사", 200));
    map.put("key3", new Book("cccc", "비트출판사", 300));
    map.put("key4", new Book("dddd", "비트출판사", 400));
    map.put(new Integer(1), new Book("eeee", "비트출판사", 500));
    map.put(2,new Book("ffff", "비트출판사", 600)); // autoboxing
    map.put(3, new Book("ffff", "비트출판사", 600)); 
    
    // 값을 꺼내는 방법
    // => 값을 저장할 때 사용한 key를 가지고 꺼낸다.
    // => 반드시 같은 key 객체일 필요는 없다.
    //    저장할 때 사용한 key의 hashCode() 리턴 값과
    //    같은 hash value를 가진다면 값을 꺼내는 key로 사용할 수 있다.
    //    물론, equals()의 결과도 true여야한다.
    System.out.println(map.get(new String("key1")));
    System.out.println(map.get(1));
    
    /* Key로 사용할 수 있는 객체?
     * => 인스턴스 변수에 같은 값을 갖고 있으면 같은 hash 값을 리턴하는 클래스
     *    물론 equals()로 true를 리턴한다.
     * => 예) String, Wrapper classes
     */
    
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    if (s1 == s2) 
      System.out.println("s1 == s2");
    else
      System.out.println("s1 != s2");
    System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode());
    System.out.println(s1.equals(s2));
  }
}







