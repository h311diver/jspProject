<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>

<jsp:include page="/main/header.jsp"/>

	<div class="card-group">
  <div class="card">
    <div class="card-body">
	
	
  
	
	<div class="alert alert-info" role="alert"> 
  <a href="/listMember.do" class="alert-link">회원목록</a></div>
	
	
	<div class="table-responsive">
				<table class="table table-hover">
		<thead class="thead">
			<tr>
				<th scope="col">회원 아이디</th>
				<th scope="col">회원 이름</th>
				<th scope="col">회원 등급</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${listMember}" var="mdto">
			<tr>
				<td>${mdto.id}
				
				<c:if test="${login.role=='admin'||login.role=='manager'}">
				<a href="/readMember.do?id=${mdto.id}" class="badge badge-info">
				정보 보기</a>
				</c:if>
				
				</td>
				<td>${mdto.name}</td>
				<td>${mdto.role}</td>
			</tr>
		</c:forEach>
		</tbody>	
	</table>
	</div>
	
	<jsp:include page="/member/searchPageMember.jsp"/>
	
	<jsp:include page="/member/searchMember.jsp"/>
	
	 </div>
	</div>
	</div>


		
		
		
		
	
	
	
	<jsp:include page="/main/footer.jsp"/>

</body>
</html>