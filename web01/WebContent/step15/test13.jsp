<%-- JSP 구성 요소: JSP
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시어(directive) 엘리먼트
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
   => JSP에서 기본으로 제공하는 태그이다.
   => 이 태그를 사용하기 위해 따로 라이브러리를 가져오는 taglib를 선언할 필요가 없다. 
   jsp:param
   => 다른 서블릿        
7) JSP 확장 태그(JSTL)
8) EL(Expression Language)
9) JSP 주석
--%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSP</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:include + jsp:param</h1>
<jsp:include page="c.jsp">
  <jsp:param name="name" value="홍길동"/>
  <jsp:param name="age" value="20"/>
</jsp:include>

</body>
</html>