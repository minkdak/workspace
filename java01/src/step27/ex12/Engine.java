package step27.ex12;

// @Component
public abstract class Engine {
  int valve;
  int cylinder;
  
  public Engine() {
    System.out.println("Engine()");
  }
  public Engine(int valve, int cylinder) {
    System.out.println("Engine(valve, cylinder");
    this.valve = valve;
    this.cylinder = cylinder;
  }
  @Override
  public String toString() {
    return "Engine [valve=" + valve + ", cylinder=" + cylinder + "]";
  }
  
  public int getValve() {
    return valve;
  }
  public void setValve(int valve) {
    System.out.println("setValve()");
    this.valve = valve;
  }
  public int getCylinder() {
    return cylinder;
  }
  public void setCylinder(int cylinder) {
    System.out.println("setCylinder()");
    this.cylinder = cylinder;
  }
  
  
}
