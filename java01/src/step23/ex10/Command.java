/* 역할
 * HttpProcessor(Caller)와 요청처리객체(callee) 사이의
 * 호출 규칙을 정의한다.
 */
package step23.ex10;

import java.io.PrintStream;

public interface Command {
  void service(PrintStream out) throws Exception;
}
