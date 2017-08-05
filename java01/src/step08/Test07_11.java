/* 컬렉션(Collection) 클래스II : java.util.ArrayList 
 */
package step08;

import java.sql.Date;
import java.util.ArrayList;

public class Test07_11 {
    
  
    // ArrayLIst 클래스 내부에서만 사용할 메서드라면 굳이 공개하지 말라!
    // => 메서드 선언 앞에 private을 붙인다.
    public static void main(String[] args) {
      ArrayList<Date> dateList = new ArrayList();
      
      dateList.add(Date.valueOf("2017-3-1"));
      dateList.add(Date.valueOf("2017-5-3"));
      dateList.add(Date.valueOf("2017-5-5"));
      dateList.add(Date.valueOf("2017-5-9"));
      Date d1 = Date.valueOf("2017-6-6");
      dateList.add(d1);
      dateList.add(d1);
      
      // 제네릭의 장점 중 하나는 목록에 넣을 수 있는 객체의 타입을 제한할 수 있다는 것이다.
      // dateList.add(new String("Hello"));
      
      dateList.add(2, Date.valueOf("2017-2-22"));
      Object removedObj = dateList.remove(3);
      
      
      Object oldObj = dateList.set(1, Date.valueOf("2017-5-4"));
      
      // java. util.ArrayList는 Collection의 서브 타입이기 때문에
      // for( : ) 명령에 사용할 수 있다.
     for (Date date : dateList) {
        System.out.printf("%d월 %d일\n", date.getMonth() + 1, date.getDate());
      }
     
     System.out.println("=>" + removedObj);
     System.out.println("=>" + oldObj);
    }
  }








