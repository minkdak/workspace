/* 애노테이션: 애노테이션에 속성 추가하기    
 */
package step25;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 유지 범위를 지정하지 않으면 다음의 애노테이션이 자동으로 붙는다.

@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation04 {
  // 속성 : 인터페이스의 메서드 처럼 생겼다.
  String v1(); // 필수 속성.
  String v2() default "aaa"; // 선택속성.
  
  int v3();
  int v4() default 100;
}
