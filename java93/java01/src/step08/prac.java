package step08;

public class prac {
  public static void main(String[] args) {
    Integer iValue1 = new Integer(10);
    Integer iValue2 = new Integer(10);
    
    if (iValue1 == iValue2) {
      System.out.println("동일인스턴스 참조");
    } else {
      System.out.println("동일인스턴스 참조X");
    }
  }
}
