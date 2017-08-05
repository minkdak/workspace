import java.io.File;

public class BIT_ls {

  public static void main(String[] args) throws Exception {
    File f = new File("./");
    
    File[] files = f.listFiles();
    
    for (File file : files) {
      System.out.printf("%s %12d %s\n", 
          (file.isDirectory() ? "d" : "-"),
          (file.length()),
          (file.getName()));
    }
  }
}
