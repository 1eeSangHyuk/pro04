<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="notice/noticeList.do">목록</a>
<P>  The time on the server is ${serverTime}. </P>
<a href="member/terms.do">회원가입</a>
<a href="member/loginForm.do">로그인 - 컨트롤러에서 세션 처리</a>
<a href="member/">로그인 - 서비스에서 세션 처리</a>
<a href="member/">로그인 - DAO에서 세션 처리</a>
<c:if test="${sid != null}">
${sid }님 안녕하세요!
<a href="member/logout.do">로그아웃</a>
</c:if>
</body>
</html>
