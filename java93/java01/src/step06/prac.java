package step06;



public class prac {
     

  public static void main(String[] args) {
    
    
    prac1 p1 = new prac1();
    prac1 p2 = new prac1();
    
    prac1.init(p1,"홍2길동", 19);
    prac1.init(p2,"홍3길동", 29);
    

    
    prac1.print(p1);
    prac1.print(p2);
  }
}
