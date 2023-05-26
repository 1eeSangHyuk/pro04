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
<title>noticeUpdate</title>
</head>
<body>
	<form action="" method="post">
		<table>
			<tbody>
				<tr>
					<th>title</th>
					<td><input type="text" id="notiTitle" name="notiTitle" placeholder="제목"></td>
				</tr>
				<tr>
					<th>text</th>
					<td><textarea cols="20" rows="25" id="notiText" name="notiText" placeholder="내용"></textarea></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="글 수정하기">
	</form>
	<a href="javascript:history.go(-1)">뒤로가기</a>
</body>
</html>