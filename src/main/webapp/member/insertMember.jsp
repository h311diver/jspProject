<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 화면</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="/main/header.jsp"/>
	
	<div class="card-group">
  <div class="card">
    <div class="card-body">



	<div class="container">
	<form action="/insertMember.do" method="post">
	
		<div class="alert alert-info" role="alert"> 
  <a href="/insertuiMember.do" class="alert-link">회원 가입 화면</a></div>
	
	
	
			회원 아이디<br>
			<input name="id" placeholder="아이디"> 
			<button id="btn_idcheck">아이디중복체크</button><br>
			<p id="p_idcheck_result"></p>
		<label>
			회원 비밀번호<br>
			<input type="password" name="pw1" placeholder="비밀번호">
		</label>
		<br>
		<label>
			회원 비밀번호 확인<br>
			<input type="password" name="pw2" placeholder="비밀번호 확인">
		</label>
		<br>
		<label>
			회원 이름<br>
			<input type="text" name="name" placeholder="이름">
		</label>
		<br>
		<label>
			회원 생년월일<br>
			<input type="date" name="birthday" placeholder="생년월일">
		</label>
		<br>
		<label>
			회원 주소<br>
			<input type="text" name="address" placeholder="주소">
		</label>
		<br>
		<label>
			회원 성별<br>
			<input type="text" name="gender" placeholder="남성 또는 여성으로 기재">
		</label>
		<br>
		<label>
			회원 이메일<br>
			<input type="email" name="email" placeholder="이메일">
		</label>
		<br>
		<label>
			회원 전화번호<br>
			010 - <input type="tel" name="phone" placeholder="전화번호 8자리">
		</label>
		<br>
		<label>
			회원 등급<br>
			<input type="hidden" name="role" value="guest" readonly>
		</label>
		<br>
		<button type="submit" id="submit" name="submit" class="btn btn-outline-primary" value="가입하기">가입하기</button>
		<br><br>
	</form>
	</div>
	
	</div>
	</div>
	</div>
	
	<jsp:include page="/main/footer.jsp"/>
	
	
	
	
	
	
	<script type="text/javascript">
      $(document).ready(function() {
         $("#btn_idcheck").click(function(event) {
            event.preventDefault();
            var id = $("input[name ='id']").val();
            
            $.ajax({
               type: "get",
               url: "idcheck.do",
               data: {
                  id : id
               },
               dataType : "text",
               success : function(result) {
                  var msg = '';
                  if(result==0){
                     $("input[name ='id']").val('');
                     msg = "사용 불가한 아이디입니다.";
                     $("input[name ='id']").focus();
                  }else{
                     msg = "사용 가능한 아이디입니다.";
                  }
                     $("#p_idcheck_result").text(msg);
                  
                  
               }
            });
            
         });  
         
         $("button#submit").click(function() {
   			alert("회원가입을 축하합니다!");
   		});
         
      });
      
      
  	
  		
  	
  
   </script>

</body>
</html>