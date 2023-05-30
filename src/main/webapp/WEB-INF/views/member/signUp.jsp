<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*, java.text.*, java.net.InetAddress" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <%@ include file="../../common.jsp" %> --%>
<title>회원가입</title>
<style>
</style>
</head>
<body>
<%-- <%@ include file="../../header.jsp" %> --%>
<div>
<!-- jquery -->
<script
  src="https://code.jquery.com/jquery-3.6.4.js"
  integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
  crossorigin="anonymous">
</script>
	<h2>회원가입</h2>
	<p>${msg }</p>
	<form action="${path }/member/insert.do" method="post" onsubmit="return joinCheck(this)">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디 : </th>
					<td>
						<div>
							<input type="text" id="id" name="id">
							<input type="button" value="아이디 중복 확인" onclick="idCheck()" class="btn btn-primary">
							<input type="hidden" id="idCk" name="idCk" value="no">
						</div>
						<div>
							<c:if test="${empty qid }">
							<p id="msg" style="padding-left:0.5rem">아직 아이디 중복 체크를 하지 않으셨습니다.</p>
							</c:if>
							<c:if test="${not empty qid }">
							<p id="msg" style="padding-left:0.5rem">아이디 중복 체크후 수정하였습니다.</p>
							</c:if>
						</div>
					</td>
				</tr>
				<tr>
					<th>비밀번호 : </th>
					<td><input type="password" id="pw" name="pw"></td>
				</tr>
				<tr>
					<th>비밀번호 확인 : </th>
					<td><input type="password" id="pw2" name="pw2"></td>
				</tr>
				<tr>
					<th>이름 : </th>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<th>전화번호 : </th>
					<td><input type="text" id="tel" name="tel"></td>
				</tr>
				<tr>
	      			<th>생년월일</th>
	      			<td>
	      				<input type="date" name="birth" id="birth" placeholder="생년월일 입력" required>
	      			</td>
	      		</tr>
				<tr>
					<th>주소 : </th>
					<td>
						<input type="text" id="addr1" name="addr1" placeholder="기본주소">
						<input type="text" id="addr2" name="addr2" placeholder="상세주소">
						<input type="text" id="postcode" name="postcode" placeholder="우편번호">
						<button type="button" onclick="findAddr()" class="btn btn-primary">우편번호 검색</button>
					</td>
				</tr>
				<tr>
					<th><label for="">이메일 : </label></th>
					<td><input type="text" id="email" name="email"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="회원가입하기">
						<input type="reset" value="리셋">
					</td>
				</tr>
			</tbody>
		</table>
		<script>
			function idCheck(){
				if($("#id").val()==""){
					alert("아이디를 입력하시기 바랍니다.");
					$("#id").focus();
					return;
				}
				var params = { id:$("#id").val() }
				$.ajax({
					url:"${path }/member/idCheck.do",
					type:"post",
					dataType:"json",
					data:params,
					success:function(result){
						var idChk = result.res;
						console.log(idChk);
						if(idChk==false){
							$("#idCk").val("no");
							$("#msg").html("<strong>사용할 수 없는 아이디 입니다.</strong>");
						} else if(idChk==true){
							$("#idCk").val("yes");
							$("#id").attr("readonly","true");
							$("#msg").html("<strong>사용 가능한 아이디 입니다.</strong>");
							$("#pw").focus();
						} else {
							$("#msg").html("<strong>아이디가 확인되지 않았습니다. 다시 시도 바랍니다.</strong>");
						}
					}
				});
			}
			function joinCheck(f){
				if(f.pw.value != f.pw2.value){
					alert("비밀번호가 서로 일치하지 않습니다.");
					f.pw1.focus();
					return false;
				}
				if(f.idCk.value != "yes"){
					alert("아이디 중복 확인이 되지 않았습니다.");
					f.id.focus();
					return false;
				}
			}
			function findAddr(){
				new daum.Postcode({
					oncomplete: function(data) {
						console.log(data);
						var roadAddr = data.roadAddress;
						var jibunAddr = data.jibunAddress;
						document.getElementById("postcode").value = data.zonecode;
						if(roadAddr !== '') {
							document.getElementById("addr1").value = roadAddr;				
						} else if(jibunAddr !== ''){
							document.getElementById("addr1").value = jibunAddr;
						}
						document.getElementById("addr2").focus();
					}
				}).open();		
			}
			</script>
			<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	</form>
</div>
<%-- <%@ include file="../../footer.jsp" %> --%>
</body>
</html>