/* 애노테이션: 애노테이션에 배열 속성 추가하기    
 */
package step25;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation06 {
  String value() default "hello";
  String value2() default "hi";
  
  
}
