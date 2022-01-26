<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>

<jsp:include page="/main/header.jsp"/>




<div class="card-group shadow-sm">
  <div class="card">
    <div class="card-body">


<div class="alert alert-info" role="alert"> 
  <a href="/loginuiMember.do" class="alert-link">로그인 화면</a></div>

<form action="/loginMember.do" method="post">
	<label>
			회원 아이디<br>
			<input type="text" name="id" placeholder="아이디" >
		</label>
		<br>
		<label>
			회원 비밀번호<br>
			<input type="password" name="pw" placeholder="비밀번호">
		</label>
		<br>
		<br>
		<button type="submit" id="submit" name="submit" class="btn btn-outline-primary" value="로그인">로그인</button><br><br>
		<br><br>
	
</form>
</div>
</div>
	</div>
<jsp:include page="/main/footer.jsp"/>

<script type="text/javascript">
	$(document).ready(function(){
	
		$("button#submit").click(function() {
			if (id!=null&&pw!=null) {
				alert(" 환영합니다!")
			}
			
		});
		
	});
</script>




</body>
</html>