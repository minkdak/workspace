/* 컬렉션(Collection) 클래스 II : java.util.HashMap II   
 */
package step08;

import java.util.HashMap;
import java.util.Iterator;

public class Test07_9 {
  
  // 사용자 정의 클래스를 Map 컬렉션의 key로 사용할 때!
  static class MyKey {
    String value;
    public MyKey(String value) {
      this.value = value;
    }
  }
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
    
    map.put(new MyKey("key1"), new Book("aaaa", "비트출판사", 100));
    map.put(new MyKey("key2"), new Book("bbbb", "비트출판사", 200));
    map.put(new MyKey("key3"), new Book("cccc", "비트출판사", 300));
    map.put(new MyKey("key4"), new Book("dddd", "비트출판사", 400)); 
    
    System.out.println(map.get(new String("key1")));
    System.out.println(map.get(new String("key3")));
    
    // 같은 값을 갖고 있는 MyKey를 사용했는데 값을 꺼낼 수 없었다. 이유는?
    // => 인스턴스 변수의 값이 중요한 게 아니라, hashCode()의 리턴 값과,
    //  equals()의 리턴 값이 중요하다.
    // => 같은 값을 갖고 있는 객체임에도 다른 hashCode()를 리턴하는 클래스는
    //  Map컬렉션의 key로 사용할 수 없다.
    // => 개발자가 정의한 클래스를 Map 컬렉션의 key로 쓰고 싶은가?
    //    그렇다면 해시코드와
    MyKey s1 = new MyKey("key1");
    MyKey s2 = new MyKey("key1");
    
    
    if (s1 == s2) 
      System.out.println("s1 == s2");
    else
      System.out.println("s1 != s2");
    System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode());
    System.out.println(s1.equals(s2));
    
  }
}







