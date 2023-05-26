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
<title>noticeList</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>연번</th>
				<th>no</th>
				<th>title</th>
				<th>regDate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${noticeList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${list.notiNO }</td>
				<td><a href="${path }/notice/noticeDetail.do">${list.notiTitle }</a></td>
				<td>${list.notiRegDate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${path }/notice/noticeInsert.do">글 쓰기</a>
	<a href="javascript:history.go(-1)">뒤로가기</a>
</body>
</html>