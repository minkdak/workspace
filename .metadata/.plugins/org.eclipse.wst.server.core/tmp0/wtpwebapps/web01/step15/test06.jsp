<%-- JSP 구성 요소
1) 템플릿 데이터
2) 스크립트릿(scriptlet) 엘리먼트
3) 지시어(directive) 엘리먼트
   - <%@ page %>
     language 속성: 스크립트릿 등에서 사용하는 프로그래밍 언어가 무엇인지 지정.
                    현재 java 밖에 안된다.
                    원래 의도는 다른 프로그래밍 언어도 사용할 경우도 고려했다.
     contentType 속성: response.setContentType() 코드를 생성
     pageEncoding 속성: JSP 파일이 어떤 인코딩으로 저장되어있는지 지정한다.
                        JSP 엔진이 JSP 파일을 읽을 때 사용한다.
     trimDirenctiveWhitesapces 속성: 
        JSP 태그를 사용한 후 줄 바꿈 코드가 있을 때 무사할 지 적용할 지 결정.
     buffer 속성
        출력 스트림의 기본 버퍼 크기를 지정한다. 기본이 8KB.
     impot 속성:
       import 문을 추가할 때 사용.
       콤마(,)
   - <%@ incluede %>
   - <%@ taglib %>
     JSP에서 기본으로 제공하지 않는, 외부에서 제공하는 태그를 사용할 떄 선언한다.
     prefix 속성:
       외부 태그를 사용할 때 태그명 앞에 붙이는 접두어.
       즉 태그 라이브러리의 별명
     url 속성:
       외부 태그의 라이브러리 이름.
       자바의 패키지 명과 다르게 URL 주소 형태로 되어 있다.
       개발자가 직접 만든 태그나 외부에서 만든 태그를 사용하려면
       /WEB-INF/classes 또는 WEB-INF/lib 에 태그를 처리하는 라이브러리를 두어야 한다.
4) 표현식(expression) 엘리먼트
5) 선언문(declaration) 엘리먼트
6) JSP 액션 태그
7) JSP 확장 태그(JSTL)
8) EL(Expression Language)
9) JSP 주석
--%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%
int i=20;
int j=30;
%>
  <meta >
  <title>JSP</title>
</head>
<body>
<!-- HTML 주석도 템플릿 데이터이다. -->
<h1>지시 엘리먼트-taglib</h1>
<hr>
<% String name = "홍길동"; %>
<%@ include file="a.jsp" %>
<hr>
<%-- <jsp:include page="a.jsp"/> --%>
</body>
</html>