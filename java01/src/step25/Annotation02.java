/* 애노테이션: SOURCE 에서만 유지되는 애노테이션    
 */
package step25;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 유지 범위를 지정하지 않으면 다음의 애노테이션이 자동으로 붙는다.

@Retention(RetentionPolicy.SOURCE)
public @interface Annotation02 {

}
