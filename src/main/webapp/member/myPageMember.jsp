<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>


<div class="row">
	
	
	
	<div class="card w-20 ml-4">
    <div class="card-body">
    <img src="picture/profile.png" class="rounded border border-info" alt="프로필이미지">
    <br><br>
    <p class="text-info">${login.name} ${login.id}</p>
   <a href="/updateuiMember.do?id=${login.id}" class="badge badge-secondary">edit-></a>
    <br><a href="/myPageMember.do?id=${login.id}" class="badge badge-dark">프로필-></a>
    <br><br>
    	<a href="/writeuiPosting.do">
			<button type="button" class="badge badge-primary">
			글쓰기</button></a>
	<hr>
	<div class="alert alert-dark"> 
  <a href="#" class="alert-link">게시판목록</a></div>
  <a class="text-dark" href="listPosting.do">자유게시판</a><hr>
  <a class="text-dark" href="listInformation.do">고객게시판</a><hr>
  <a class="text-dark" href="listNotice.do">공지사항</a><hr>
  <a class="text-dark" href="listMember.do">회원게시판</a><hr>
  
  
	
	
	
	
	
	</div>
	</div>
	
	
	<div class="col">
	<div class="card">
	<div class="card-body">
  
  <div class="alert alert-info"> 
  <h3><a href="/myPageMember.do?id=${login.id}" class="alert-link">마이페이지</a></h3></div>
  </div>
  <hr>
  
	<div class="row">
 <div class="card-group w-100" >
    <div class="card-body">
	
	
  
	<form action="/updateMember.do" method="post">
	<div class="alert alert-info"> 
  <a href="/readMember.do?id=${login.id}" class="alert-link">내 정보</a></div>
	<label>
         회원 아이디<br>
         <input class="border-0 text-info" type="text" name="id" value="${mdto.id}" readonly>
      </label>
      
      <br>
      <label>
         회원 이름<br>
         <input class="border-0 text-info" type="text" name="name" value="${mdto.name}" readonly>
      </label>
      <br>
      <label>
         회원 생년월일<br>
         <input class="border-0 text-info" type="date" name="birthday" value="${mdto.birthday}" readonly>
      </label>
      <br>
      <label>
         회원 주소<br>
         <input class="border-0 text-info" type="text" name="address" value="${mdto.address}" readonly>
      </label>
      <br>
      <label>
         회원 성별<br>
         <input class="border-0 text-info" type="text" name="gender" value="${mdto.gender}" readonly>
      </label>
      <br>
      <label>
         회원 이메일<br>
         <input class="border-0 text-info" type="email" name="email" value="${mdto.email}" readonly>
      </label>
      <br>
      <label>
         회원 전화번호<br>
         010 - <input class="border-0 text-info" type="number" name="phone" value="${mdto.phone}" readonly>
      </label>
      <br>
        
      <label>
         회원 등급<br>
         <input class="border-0 text-info" type="text" name="role" value="${mdto.role}" readonly>
      </label>
     
      <br>
      <br>
      
      
   </form>
   <div class="row">&nbsp; &nbsp; &nbsp; &nbsp;
   <a href="/updateuiMember.do?id=${mdto.id}">
	<button class="btn btn-warning btn-sm">수정하기</button>
</a> &nbsp; &nbsp;
  
  	<form name=form method=post action="/deleteMember.do?id=${mdto.id}">
<input type=hidden name="pw" id="pw" value="${mdto.pw}">
</form>

<button class="btn btn-danger btn-sm" onclick="savePrompt();">탈퇴하기</button>
	</div>
	 </div>
	
	
	
	
	
	
	
    <div class="card-body">
			<div class="alert alert-info" role="alert">
  <a href="/myCountMember.do?id=${login.id}" class="alert-link">내활동내역</a></div>
	<br><br><div class="row">작성한 게시글 개수 : &nbsp; <p class="text-info"> ${amount} 개</p> 
	 </div><a href="/searchPosting.do?criteria=writer&keyword=${login.id}" 
	 class="btn btn-primary btn-sm">보러가기</a>

		
		
		
		
	
		
	

	</div>
	</div>
	</div>
	</div>
	
    </div>
	</div>

<jsp:include page="../main/footer.jsp"/>

<script type="text/javascript">
      
    	  function savePrompt() {
    		  var pw = prompt("탈퇴하시겠습니까? 비밀번호를 입력하세요.")
    		  
    		  if (pw!=${mdto.pw}) {
    			  alert("비밀번호가 일치하지 않습니다.")
    		
			}else if(pw==${mdto.pw}) {
				alert("탈퇴되셨습니다.")
			<%	session.invalidate();  %>
			}
    		  document.form.pw.value = pw;
    		  document.form.submit();
    	  }
      
</script>


</body>
</html>