/* 애노테이션 사용하기 : 속성 값 지정하기
 * => 
 */
package step25;

//@Annotation04 // 컴파일 오류! 필수 속성의 값은 반드시 입력해야 한다.
@Annotation04(v1="hello", v3 =200) // v2와 v4는 선택속성이라 생략 ㅇㅈ
public class Class02 {  // 애노테이션이 .class 파일에 유지되는지 확인하라!
                        // => Class01.class 파일을 읽어보면된다.

}

