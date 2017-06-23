package step21.ex5;

public class Tesla extends Mortor{
  int charge; 
  
  public void doCharge() {
    charge = 100;
  }
  
  public void run() {
    System.out.println("조용히 달린다!");
  }
}
