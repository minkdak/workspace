import java.io.File;

public class BIT_del {
  public static void displayDirectory(File dir, int level) throws Exception {
    File[] files = dir.listFiles();
 
    
    
    
    for (File file : files) {
      for (int i = 0; i < level; i++) System.out.print("  ");
      
      System.out.printf("삭제할 폴더 = %s \n", 
          file.getName());
      
      if (file.isDirectory()) {
        displayDirectory(file, level + 1);
      }
      file.delete();
    }
  }

  public static void main(String[] args) throws Exception {
    
    if (!args[0].equals("-R")) {
      String src = args[0];
      File f = new File("./src/" + src);
      f.delete();      
    } else if (args[0].equals("-R")) {
      String src = args[1];
      File f = new File("./src/");
      displayDirectory(f, 0);
      
      
      
    }
  }
}