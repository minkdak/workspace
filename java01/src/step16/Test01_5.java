/* File 다루기 - File 클래스 사용법 V */
package step16;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Test01_5 {

  public static void main(String[] args) throws Exception {
    File f = new File("../");
    
    // 지정된 폴더에 들어있는 파일 및 하위 폴더에 대한 정보를 담은 File 객체 목록을 리턴한다.
    
    displayDirectory(f, 0);
  }

  public static void displayDirectory(File dir, int level) {
    File[] files = dir.listFiles();
    
    for (File file : files) {
      for (int i = 0; i < level; i++) System.out.print("    ");
      System.out.printf("%s %s\n", 
          (file.isDirectory() ? ">" : " "),
          file.getName());
      
      if(file.isDirectory()) {
        displayDirectory(file, level + 1);
      }
    }    
  }
}
