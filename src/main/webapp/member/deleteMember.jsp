<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>

<jsp:include page="/main/header.jsp"/>




<div class="container">
	<div class="alert alert-danger" role="alert">
  <a href="/deleteuiMember.do?id=${mdto.id}" class="alert-link">삭제화면</a></div>
	<form action="/deleteMember.do" method="post">
		<input name="id" type="hidden"  value="${id}"><br>
		비밀번호: &nbsp; <input name="pw" type="password" ><br><br>
		<input type="submit" id="submit" name="submit" class="btn btn-primary btn-sm" value="삭제완료"><br>
	
	</form>
	</div>

<jsp:include page="/main/footer.jsp"/>

<script type="text/javascript">
	$(document).ready(function(){
	
		$("button#submit").click(function() {
			alert("탈퇴되셨습니다.")
			<% session.invalidate(); %>
			}
		});
		
	});
</script>


</body>
</html>