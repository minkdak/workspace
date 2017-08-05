package step10.ex3;

public class Test01 {
  
  public static void main(String[] args){
  Calculator c1 = new Calculator();
  c1.plus(10);
  c1.plus(7);
  c1.plus(10, 7);
  c1.minus(5);
  
  System.out.println(c1.result);
  }
}
