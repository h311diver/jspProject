<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보자세히보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="/main/header.jsp"/>
	
	
<div class="card-group shadow-sm">
  <div class="card">
    <div class="card-body">

<div class="alert alert-info"> 
  <a href="/readMember.do?id=${mdto.id}" class="alert-link">회원정보 자세히 보기</a></div>

<div class="table-responsive">
				<table class="table table-hover">
		<thead class="thead-dark">
			<tr>
				<th scope="col">아이디</th>
				<th scope="col">이름</th>
				<th scope="col">생년월일</th>
				<th scope="col">주소</th>
				<th scope="col">성별</th>
				<th scope="col">이메일</th>
				<th scope="col">핸드폰번호</th>
				<th scope="col">회원등급</th>
				
			</tr>
		</thead>
		
		<tbody>
		
			<tr>
				<td>${mdto.id}</td>
				<td>${mdto.name}</td>
				<td>${mdto.birthday}</td>
				<td>${mdto.address}</td>
				<td>${mdto.gender}</td>
				<td>${mdto.email}</td>
				<td>010 - ${mdto.phone}</td>
				<td>
				<form action="/updateRoleMember.do?id=${mdto.id}" method="post">
  		<div class="form-row align-items-center">
    <div class="col-auto my-1">
      <label class="mr-sm-2 sr-only">등급변경</label>
      <select class="custom-select mr-sm-2" name="role">
      
     <option  id="guest"  value="guest" ${mdto.role eq 'guest' ? "selected" : ""}>게스트등급</option>
		<option id="manager" value="manager" ${mdto.role eq 'manager' ? "selected" : ""}>매니저등급</option>
        <option id="admin" value="admin" ${mdto.role eq 'admin' ? "selected" : ""}>관리자 등급 </option>
      </select>
    </div>
    
    <input type="submit" id="changeRole" name="changeRole" class="btn btn-warning btn-sm" value="등급변경">
    
    
    </div> 
</form>
				</td>
			</tr>
		</tbody>	
	</table>
	
	

	
	
	
	
	
<div class="row container">
<a href="/updateuiMember.do?id=${mdto.id}">
	<button class="btn btn-warning btn-sm">수정</button>
</a> &nbsp;&nbsp;<br>



<c:choose>
<c:when test="${login.role=='admin'||login.role=='manager'}">
	<form name=form method=post action="/deleteMember.do?id=${mdto.id}">
<input type="hidden" name="pw" id="pw" value="${mdto.pw}">
<button class="btn btn-danger btn-sm" onclick="deleteMember();">삭제</button>&nbsp;<br>
</form>
</c:when>

<c:otherwise>
	<form name=form method=post action="/deleteMember.do?id=${mdto.id}">
<input type=hidden name="pw" id="pw" value="">
</form>
<button class="btn btn-danger btn-sm" onclick="savePrompt();">삭제</button>&nbsp;<br>
</c:otherwise>
</c:choose>

<a href="/listMember.do">
&nbsp;<button id="list" class="btn btn-info btn-sm">목록</button><br>
</a>

</div>


	</div>
	 </div>
	</div>

</div>
<jsp:include page="/main/footer.jsp"/>





<script type="text/javascript">
      
      		function deleteMember() {
      			alert("성공적으로 회원을 탈퇴시켰습니다.")
      		}
      
      
    	  function savePrompt() {
    		  var pw = prompt("탈퇴하시겠습니까? 비밀번호를 입력하세요.")
    		  
    		  if (pw!=${mdto.pw}) {
    			  alert("비밀번호가 일치하지 않습니다.")
			}else if(pw==${mdto.pw})	{
				alert("탈퇴되셨습니다.")
			
			}
    		  
    		  document.form.pw.value = pw;
    		  document.form.submit();
    	  }
      
    	  
    	 
    		$(document).ready(function(){
    		
    			$("input#changeRole").click(function() {
    				
    					alert("회원의 등급 변경 완료.")
    		});
    			
    		});
    	
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
</script>



</body>
</html>