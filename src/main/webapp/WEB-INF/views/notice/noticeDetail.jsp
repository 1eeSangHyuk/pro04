<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetail</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<th>no</th>
				<td>${list.notiNO }</td>
			</tr>
			<tr>
				<th>title</th>
				<td>${list.notiTitle }</td>
			</tr>
			<tr>
				<th>text</th>
				<td>${list.notiText }</td>
			</tr>
			<tr>
				<th>cnt</th>
				<td>${list.notiCnt }</td>
			</tr>
			<tr>
				<th>regDate</th>
				<td>${list.notiRegDate }</td>
			</tr>
		</tbody>
	</table>
	<a href="javascript:history.go(-1)">목록으로</a>
	<a href="${path }">홈으로</a>
</body>
</html>