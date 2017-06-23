/* 웹 애플리케이션 구성 요소 - ServletContextListener
 * 1) 서블릿
 *    - 클라이언트 요청 처리
 * 2) 필터
 *    - 요청 처리 전/후에 작업 수행
 * 3) 리스너 (= event handler)
 *    - 특정 상태에 넣일 때 작업 수행 
 *    
 * ServletContextListener?
 * - 웹 애플리케이션이 시작되거나 종료되는 상태에 대해 작업을 수행
 * 
 * 리스너 배치하기
 * 1) web.xml에 등록하기
 * 2) 애노테이션으로 등록하기
 */
package step09;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class Listener02 implements ServletRequestListener{

  @Override
  public void requestInitialized(ServletRequestEvent sce) {
    // ServletRequest 객체가 생성되었을 때 호출된다.
    // 즉 클라이언트로부터 요청이 들어올 때 호출된다.
    System.out.println("======>Listener01.requestInitialized()");
    
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sce) {
    // ServletRequest객체가 소멸되기 직전에 호출된다.
    // 즉 클라이언트
    System.out.println("======>Listener01.requestDestroyed()");
    
  }

}
