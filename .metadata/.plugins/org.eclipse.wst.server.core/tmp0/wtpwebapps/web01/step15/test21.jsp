<%-- JSP 구성 요소: JSP 액션 태그 - jsp:forward
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시어(directive) 엘리먼트
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
   c:
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
<h1>JSTL- c:if 태그 사용법</h1>
<c:set var="level" value="관리자"/>
<c:choose>
<c:when test="${level=='손님'}">손님입니다.</c:when>
<c:when test="${level=='일반회원'}">일반회원입니다.</c:when>
<c:when test="${level=='관리자'}">관리자입니다.</c:when>
<c:otherwise>등급이 없습니다.</c:otherwise>
</c:choose>
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

