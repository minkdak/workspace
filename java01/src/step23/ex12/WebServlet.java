package step23.ex12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// WebServerlet이라는 주석은 JVM을 실행할 떄도 유지하라.
@Retention(RetentionPolicy.RUNTIME)
public @interface WebServlet {
  String url();
}

