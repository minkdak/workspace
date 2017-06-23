<%-- JSP 구성 요소: JSP 액션 태그 - jsp:forward
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시어(directive) 엘리먼트
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
   c:out
   => 출력문을 만드는 태그
8) EL(Expression Language)
9) JSP 주석
--%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSTL</title>
</head>
<body>
<h1>JSTL- c:out 태그 사용법 II</h1>
<%

pageContext.setAttribute("m", new Member());
%>
<%-- c:set을 사용하여 객체의 프로퍼티에 값 설정하고 조회하기 --%>
<c:set target="${pageScope.m}" property="name" value="홍길동"/>
<c:set target="${pageScope.m}" property="age" value="20"/>
<c:set target="${pageScope.m}" property="working" value="true"/>
name: ${pageScope.m.name2}<br>
age: ${pageScope.m.age}<br>
working: ${pageScope.m.working}<br>

</body>
</html>
<%!
public class Member {
  String name2;
  int age;
  boolean working;
  
  public void setName(String name) {this.name2 = name;}
  public void setAge(int age) {this.age = age;}
  public void setWorking(boolean working) {this.working = working;}
  
  public String getName() {return this.name2;}
  public int getAge() {return this.age;}
  public boolean isWorking() {return this.working;}
}
%>

