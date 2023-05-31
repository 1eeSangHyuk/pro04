<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<jsp:include page="../include/common.jsp" />
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>스프링의 데이터 전송</title>
</head>
<body>
	<h1>GET 방식</h1>
	<h2>GET 방식1</h2>
	<div>
		<a href="./get1?id=admin&pw=1234">GET1</a>
	</div>
	<hr>
	
	<h2>GET 방식2</h2>
	<div>
		<a href="./get2?id=admin&pw=1234">GET2</a>
	</div>
	<hr>
	
	<h2>GET 방식3</h2>
	<div>
		<a href="./get3?id=admin&pw=1234">GET3</a>
	</div>
	<hr>
	
	<h2>GET 방식4</h2>
	<div>
		<a href="./get4?id=admin&pw=1234">GET4</a>
	</div>
	<hr>
	
	<h2>GET 방식5</h2>
	<div>
		<a href="./get5?id=admin&pw=1234">GET5</a>
	</div>
	<hr>
	
	<h2>GET 방식6 - spring에서만 활용 가능한 방식</h2>
	<div>
		<a href="./get6/admin/1234">GET6</a>
	</div>
	<hr>
	
	<h2>GET 방식7 - ModelAndView 이용한 방식</h2>
	<div>
		<a href="./get7?id=admin&pw=1234">GET7</a>
	</div>
	<hr>
	
	<h1>POST 방식 알아보기</h1>
	<h2>POST 방식1</h2>
	<div>
		<form name="post1" action="./post1" method="post">
			id : <input type="text" name="id" id="id1" required /><br>
			pw : <input type="password" name="pw" id="pw1" required /><br><br>
			<input type="submit" value="post1"/>
		</form>
	</div>
	<hr>
	
	<h2>POST 방식2</h2>
	<div>
		<form name="post2" action="./post2" method="post">
			id : <input type="text" name="id" id="id2" required /><br>
			pw : <input type="password" name="pw" id="pw2" required /><br><br>
			<input type="submit" value="post2"/>
		</form>
	</div>
	<hr>
	
	<h2>POST 방식3</h2>
	<div>
		<form name="post3" action="./post3" method="post">
			id : <input type="text" name="id" id="id3" required /><br>
			pw : <input type="password" name="pw" id="pw3" required /><br><br>
			<input type="submit" value="post3"/>
		</form>
	</div>
	<hr>
	
	<h2>POST 방식4</h2>
	<div>
		<form name="post4" action="./post4" method="post">
			id : <input type="text" name="id" id="id4" required /><br>
			pw : <input type="password" name="pw" id="pw4" required /><br><br>
			<input type="submit" value="post4"/>
		</form>
	</div>
	<hr>
	
	<h2>POST 방식5</h2>
	<div>
		<form name="post5" action="./post5" method="post">
			id : <input type="text" name="id" id="id5" required /><br>
			pw : <input type="password" name="pw" id="pw5" required /><br><br>
			<input type="submit" value="post5"/>
		</form>
	</div>
	<hr>
	
	<h2>POST 방식6</h2>
	<div>
		<form name="post6" action="./post6/{23}/{2323}" method="post">
			id : <input type="text" name="id" id="id6" required /><br>
			pw : <input type="password" name="pw" id="pw6" required /><br><br>
			<input type="submit" value="post6"/>
		</form>
	</div>
	<hr>
	
	<h2>POST 방식7</h2>
	<div>
		<form name="post7" action="./post7" method="post">
			id : <input type="text" name="id" id="id7" required /><br>
			pw : <input type="password" name="pw" id="pw7" required /><br><br>
			<input type="submit" value="post7"/>
		</form>
	</div>
	<hr>
</body>
</html>