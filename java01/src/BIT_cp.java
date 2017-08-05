import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BIT_cp {
  public static void main(String[] args) throws Exception {
    String src = args[0];
    String prs = args[1];
    File f = new File(src);
    
    FileInputStream in0 = new FileInputStream("./src/" + src);
    BufferedInputStream in = new BufferedInputStream(in0);
    
    FileOutputStream out0 = new FileOutputStream("./src/" + prs);
    BufferedOutputStream out= new BufferedOutputStream(out0);
    
    int b = 0;
    while ((b = in.read()) != -1) {
      out.write(b);
    }
    
    
    
    in.close();
    in0.close();
    
    out.close();
    out0.close();
    

  }
}
