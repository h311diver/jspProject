<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</head>
<body>





<c:choose>
<c:when test="${login.id==null}">

<jsp:include page="../member/loginMember.jsp"/>
</c:when>
<c:otherwise>
<jsp:include page="/main/header.jsp"/>



   <div class="card-group shadow-lg">
  <div class="card">
    <div class="card-body">
    
   <form action="/updateMember.do" method="post">
   
   <div class="alert alert-primary"> 
  <a href="/updateuiMember.do?id=${login.id}" class="alert-link">회원정보 수정 화면</a></div>

      <label>
         회원 아이디<br>
         <input type="text" name="id" value="${mdto.id}" readonly>
      </label>
      <br>
      
      <c:choose>
      <c:when test="${login.role=='admin'||login.role=='manager'}">
      <label>
         회원 비밀번호<br>
         <input type="password" name="pw" value="${mdto.pw}" readonly>
      </label>
      </c:when>
      <c:otherwise>
      <label>
         회원 비밀번호<br>
         <input type="password" name="pw" value="${mdto.pw}">
      </label>
      </c:otherwise>
      </c:choose>
      
      <br>
      <label>
         회원 이름<br>
         <input type="text" name="name" value="${mdto.name}">
      </label>
      <br>
      <label>
         회원 생년월일<br>
         <input type="date" name="birthday" value="${fn:substring(mdto.birthday, 0, 10)}">
      </label>
      <br>
      <label>
         회원 주소<br>
         <input type="text" name="address" value="${mdto.address}">
      </label>
      <br>
      <label>
         회원 성별<br>
         <input type="text" name="gender" value="${mdto.gender}">
      </label>
      <br>
      <label>
         회원 이메일<br>
         <input type="email" name="email" value="${mdto.email}">
      </label>
      <br>
      <label>
         회원 전화번호<br>
         010 - <input type="number" name="phone" value="${mdto.phone}">
      </label>
      <br>
     
      <label>
         회원 등급<br>
         <input type="hidden" name="role" value="${mdto.role}" readonly>
      </label>
      
      
      <br><br>
      <button type="submit" id="submit" name="submit" class="btn btn-warning btn-sm" value="수정완료">수정완료</button>
      <br><br>
   </form>

</div>
</div>
   </div>
   
   <jsp:include page="/main/footer.jsp"/>
   
   
   <script type="text/javascript">
   
      $(document).ready(function() {
         $("button#submit").click(function() {
     			alert("회원정보 수정완료")
     			
     		});
     	
      });
   
   </script>
   </c:otherwise>
   </c:choose>
   
</body>
</html>