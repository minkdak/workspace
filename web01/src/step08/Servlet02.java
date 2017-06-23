/* 서블릿기리 값을 공유하는 방법: Ser 사용하기
 * => 클라이언트가 요청하지 않아도 웹 애플리케이션이 시작될 떄
 *    1) web.xml DD 파일에 설정하는 방법
 *    <servlet>
 *      <servlet-name>...<servlet-name>
 *      <servlet-class>...<cersvet-class>
 *      <load-on-startup>1</load-on-startup>
 *    </servlet>
 *    2) @WebServlet 애노테이션에 설정하는 방법
 *       @WebSErvlet(
 *        urlPattern="...",
 *        <loadOnsSTtSartg>- loadOnstartup?

 *    <setvlt
 *  
 *  
 *  
 *  = 
 *    
 */
package step08;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(urlPatterns="/step08/Servlet02", loadOnStartup=1)
public class Servlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L; //
  
  @Override
  public void init() throws ServletException{
    // Servlet 인터페이스의 init(ServletConfig) 메서드 대신에
    // 이 메서드를 오버라이딩 하라고 GenericServlet 클래스에서 제공해준다.
    // 개발자는 서블릿이 생성될 때 뭔가를 준비시키고 싶다면,
    // 오리지널 init(ServletConfig) 대신 이 메서드를 오버라이딩 하여 코드를 작성하라!
    System.out.println("===========>step08.Servlet01.init2()");
    ServletContext sc = this.getServletContext();// HttpServlet 클래스로부터 상속받은 메서드를 이용할 수 있다.
    sc.setAttribute("v2", "hi");
    
  }
}
