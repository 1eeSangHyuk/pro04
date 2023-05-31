<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="path1" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>폼 유효성 검사</title>
</head>
<body>
<h2>FORM 유효성 검사</h2>
<form method="POST" action="${pageContext.servletContext.contextPath }/user/check">
        이름 : <input name="name" type="text" value="">
	<spring:hasBindErrors name="userVO">
    	<c:if test="${errors.hasFieldErrors('name') }">                                     
			<strong>${errors.getFieldError('name').defaultMessage }</strong>
		</c:if>
	</spring:hasBindErrors>
        이메일 : <input id="email" name="email" type="text" value="">
        비밀번호 : <input name="pwd" type="password" value="">
     <fieldset>
            <legend>성별</legend>
            <label>여</label> <input type="radio" name="gender" value="female" checked="checked">
            <label>남</label> <input type="radio" name="gender" value="male">
     </fieldset>
     <input type="submit" value="가입하기">
</form>
</body>
</html>