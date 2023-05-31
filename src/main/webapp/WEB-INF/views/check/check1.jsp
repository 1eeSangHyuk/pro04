<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>폼 유효성 검사1</title>
</head>
<body>
	<h2>FORM 유효성 검사1</h2>
	<form action="./check1" method="post">
	    id : <input type="text" name="id" id="id" pattern="^[a-z0-9]{5,12}" maxlength="12" required /><br><br>
	    pw : <input type="password" name="pw" id="pw" pattern="^[a-zA-Z0-9]{8,12}$" maxlength="12" required /><br><br>
	    <button class="btn" type="submit"> 전송 </button>
	</form>
</body>
</html>