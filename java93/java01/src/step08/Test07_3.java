/* 컬렉션(Collection) 클래스II : java.util.HashSet
 * => 저장하는 객체에 대해 데이터에서 hashCode()를 호출하여
 *    그 리턴 값을 가지고 저장할 위치를 계산한다.
 *    => null 값을 저장할 수 없다.
 *    => 값을 중복 저장할 수 없다.
 *       왜? 클래스 이름을 보라. 집합을 의미한다.
 *    => 값을 넣을 때 인스턴스의 해시값을 기준으로 저장하기 때문에 
 *       순서대로 저장되지 않는다.
 *       그래서 값을 꺼낼 때도 순서대로 꺼낼 수 없다.
 *    => 값을 꺼낼 때 숫자 인덱스로 꺼낼 수 없다. 
 *    => 예) HashSet
 *     
 */

package step08;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;

public class Test07_3 {
    

    public static void main(String[] args) {
      HashSet dateSet = new HashSet();
      
      dateSet.add(Date.valueOf("2017-3-1"));
      dateSet.add(Date.valueOf("2017-5-3"));
      dateSet.add(Date.valueOf("2017-5-5"));

      dateSet.add(Date.valueOf("2017-5-9"));
      Date d1 = Date.valueOf("2017-6-6");
      dateSet.add(d1);
      dateSet.add(d1); // 데이터 중복을 허용하지 않는다.
      
      // Set 컬렉션에서 값을 꺼내려면 별도의 도움을 받아야 한다.
      
      // 방법1) 배열을 리턴받기: 입력 순서대로 리턴 받을 수 없다.
      Object[] valueList = dateSet.toArray();
      for (int i = 0; i < valueList.length; i++) {
        System.out.println(valueList[i]);
      }
      System.out.println("-------------------------");
      // 방법2) 값을 꺼내주는 도구를 이용하여 처리한다.
      Iterator iterator = dateSet.iterator();
      while (iterator.hasNext()) { // 꺼낼 거 있냐?
        System.out.println(iterator.next()); // 꺼내 줘~
      }
     
     
    }
    
  }








