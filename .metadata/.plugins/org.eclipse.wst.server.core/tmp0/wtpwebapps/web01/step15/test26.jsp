<%-- JSP 구성 요소 : JSP 액션 태그 - jsp:useBean
  1) 템플릿 데이터 
  2) 스크립트릿(scriptlet) 엘리먼트
  3) 지시어(diretive) 엘리먼트
  4) 표현식 (expression) 엘리먼트
  5) 선언문 (declaration) 엘리먼트
  6) JSP 액션 태그
  7) JSP 확장 태그 (JSTL)
  8) EL (Expression Language)
  9) JSP 주석
 --%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSTL c:import 태그 사용법2</h1>
<%-- https://search.naver.com/search.naver?where=nexearch&sm=top_sly.hst&fbm=1&acr=2&ie=utf8&query=kotlin --%>
 
<c:set var='url1' value="https://search.naver.com/search.naver?where=nexearch&sm=top_sly.hst&fbm=1&acr=2&ie=utf8&query=kotlin"/>
${pageScope.url1}<br>
<c:url var="url2" value="http://localhost:8080/project01/teacher/list">
  <c:param name="pageNo" value="2"/>
  <c:param name="pageSize" value="3"/>
</c:url>
<!-- var 속성을 이용하여 변수를 지정하지 않으면 c:import 태그의 자리에 그대로 출력된다. -->
<textarea cols="80" rows="10"><c:import url="${pageScope.url2}"></c:import></textarea><br>
<!-- var 속성을 이용하여 변수명을 지정하면 응답 결과를 보관소에 저장한다. -->
<c:import var="result" url="${pageScope.url2}"/>
<textarea cols="80" rows="10">${pageScope.result}</textarea>
</body>
</html>
