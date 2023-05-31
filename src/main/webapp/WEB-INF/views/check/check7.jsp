<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="path1" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>폼 유효성 검사7</title>
</head>
<body>
	<h2>FORM 유효성 검사7</h2>
	<form:form action="./check7.do" method="post" modelAttribute="pro">
		<table>
			<tbody>
				<tr>
					<th>품명</th>
				    <td><form:input path="pname"/></td>
				</tr>
				<tr>
					<th>가격</th>
				    <td><form:input path="price"/></td>
				</tr>
				<tr>
					<th>수량</th>
				    <td><form:input path="quantity"/></td>
				</tr>
				<tr>    
				    <td colspan="2"><button class="btn" type="submit"> 전송 </button></td>
				</tr>
	    	</tbody>
    	</table>
	</form:form>
</body>
</html>