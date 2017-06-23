/* 예외처리 : 일반 모드(Exception 계열 예외)와 스텔스 모드(Error와 RuntimeException 계열 예외)
 * => 일반 모드의 예외가 발생하는 경우 반드시 둘 중 하나는 작성해야 한다.
 *    1) try ~ catch ~ 
 *    2) throws
 * => 스텔스 모드의 예외가 발생하는 경우 예외처리 문법은 선택 사항이다.
 *    즉 try ~ catch ~, throws 를 작성하지 않아도 된다.
 *       
 */
package step17;



public class Test11 {
  static void m1(int v) throws Exception {
    m2(v);
  }
  
  static void m2(int v) throws Exception {
    m3(v);
  }
  
  // 예외를 발생시키는 메서드를 사용한다면 반드시 둘 중 하나의 작업은 해야 한다.
  // 1) try ~ catch ~ 로 예외를 정확히 처리하거나,
  // 2) 이 메서드 안에서 예외가 발생한다고 메서드 선언부에 적시하거나,
  static void m3(int v) throws Exception{ // 자기가 발생시키는 예외가 아니라 m4가 발생시키는 예외라도
    // throws를 선언해줘야 한다.
    m4(v);
  }
  
  static void m4(int v) throws Exception{
    if (v < 0)
      throw new Exception("음수는 허용하지 않습니다.");
    System.out.println(v);
  }
  
  public static void main(String[] args) {
    try {
      if (args.length < 1) {
        System.out.println("[사용법] java -cp bin step17.Test11 숫자");
        return;
      }
      m1(Integer.parseInt(args[0]));
    } catch (NumberFormatException e) {
      System.out.println("프로그램 아규먼트는 숫자여야 합니다.");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("ㅎㅇ");
    

    
    
  }

}
