/* 멀티 태스킹 : 스레드의 라이프 사이클
 * => 생명 주기
 *              start()                  sleep()
 * new Thread() --------> Runnable 상태 --------------> Not Runnable 상태
 *                            |         <------------- 
 *                            |         timeout, notify
 *                            | 실행 완료
 *                            
 *                          Dead
 *                          
 * => Runnable 상태
 *    - CPU 쟁탈전에 놓인 상태
 *    - CPU를 받을 수 있는 상태
 *    - Runnable 상태에 있는 스레드 중 CPU를 사용하여 실행한다.
 * => Not Runnable 상태
 *    - CPU 쟁탈전에서 제외된 상태
 *    - CPU를 받을 수 없는 상태
 * => 실행이 완료되면 Dead 상태가 되어 다시는 실행할 수 없다.
 *    반복 실행할 수 없다.
 * 
 *  
 */
package step19;

public class Test06 {
  
  static public class Worker {
    public void play() {
      System.out.println("오호라~~ 놀자!");
    }
  }
    
  static class MyThread extends Thread {
    Worker worker;
    
    public MyThread(Worker worker) {
      this.worker = worker;
    }
    
    public void run() {
      worker.play();
      while (true) {
        worker.play();
        try {
      Thread.sleep(1000);
        } catch (Exception e) {}
      }
    }
  }
  public static void main(String[] args) {
    Worker worker = new Worker();
    MyThread t1 = new MyThread(worker);
    
    t1.start();
  }
}