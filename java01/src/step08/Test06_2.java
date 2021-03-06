/* 컬렉션(Collection) 클래스 : 사용 전 - 목록을  다루는 클래스 구현
 * => 배열을 이용하여 데이터 목록을 다루는 ArrayList 구현
 */
package step08;

import java.sql.Date;

public class Test06_2 {
    
  
    // ArrayLIst 클래스 내부에서만 사용할 메서드라면 굳이 공개하지 말라!
    // => 메서드 선언 앞에 private을 붙인다.
    public static void main(String[] args) {
      Test06_2_ArrayList dateList = new Test06_2_ArrayList();
      
      dateList.add(Date.valueOf("2017-3-1"));
      dateList.add(Date.valueOf("2017-5-3"));
      dateList.add(Date.valueOf("2017-5-5"));
      //dateList.length = 1; // private로 했기 때문에 접근 불가, 엉뚱한 값 저장 불가
      dateList.add(Date.valueOf("2017-5-9"));
      dateList.add(Date.valueOf("2017-6-6"));
      
      dateList.add(2, Date.valueOf("2017-2-22"));
      
      Object removedObj = dateList.remove(3);
      
      Object oldObj = dateList.set(1, Date.valueOf("2017-5-4"));
      
     for (int i = 0; i < dateList.size(); i++) {
        System.out.println(dateList.get(i));
      }
     
     System.out.println("=>" + removedObj);
     System.out.println("=>" + oldObj);
    }
  }








