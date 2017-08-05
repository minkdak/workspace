/* 애노테이션: 애노테이션에 배열 속성 추가하기    
 */
package step25;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 유지 범위를 지정하지 않으면 다음의 애노테이션이 자동으로 붙는다.

@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation05 {
  String[] v1();
  String[] v2();
  String[] v3();
  
  int[] v4();
  int[] v5();
  int[] v6();
  
}
