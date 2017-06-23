/* 데이터 프로세싱 스트림 클래서 BufferedInputStream 도입 후
 * => 버퍼를 준비하여 일정량 만큼 읽는다. 
 */
package step16;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test04_3_in {
  static class MyBufferedInputStream {
    InputStream in;
    byte[] buf = new byte[8192];
    int len;
    int cursor;
    MyBufferedInputStream(InputStream in) {
      this.in = in;
    }
    
    public int read() throws IOException {
      if (cursor == len) {
        cursor = 0;
        len = in.read(buf);
        if (len < 0) 
        return -1;
      }
      return buf[cursor++] & 0x000000FF; 
      // 버퍼(cursor)의 값이 0x0000000ff를 만나게 되면 앞 비트를 모두
      // 0xffffffff로 처리하기 때문에 int에서는 -1을  처리해서 -1을 리턴하게 돼서 비정상종료된다.
      // & 연산으로 앞자리를 0으로 만들어 줘서 중간에 종료되는걸 방지함
      // 1byte & 4byte 연산 불가능 => 암시적형변환
    }
    
    public void close() {}
  }

  public static void main(String[] args) throws Exception {
    FileInputStream in0 = new FileInputStream("temp/jls8.pdf");
    MyBufferedInputStream in = new MyBufferedInputStream(in0);

    int b = 0;
    int count = 0;
    long start = System.currentTimeMillis();
    
    while ((b = in.read()) != -1) {
        if ((++count % 10000) ==0) System.out.print(".");
        if ((count % 500000) == 0) System.out.println();
    }
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end-start);
    in.close();
    in0.close();
  }
}
