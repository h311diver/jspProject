<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈 화면</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>


</head>
<body>


<jsp:include page="/main/header.jsp"/>

	
	
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
  
  
	<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr class="table-danger">
							
							<th scope="col"><a class="text-dark" href="listNotice.do">필독!! 공지사항</a></th>
							
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${listNotice}" var="ndto">
							<tr>
							<td>
								<a class="text-danger" href="/readNotice.do?num=${ndto.num}">${ndto.title}</a></td>
								
							</tr>
						</c:forEach>

					</tbody>
				</table>
  </div>
  </div>
  <hr>
	<div class="row">
	
  <div class="card-group w-100" >
    <div class="card-body">
	
	
  
	
	<div class="alert alert-info"> 
  <a href="/listMember.do" class="alert-link">회원목록</a></div>
	
	
	<div class="table-responsive">
				<table class="table table-hover">
		<thead class="thead">
			<tr>
				<th scope="col">회원아이디</th>
				<th scope="col">회원이름</th>
				<th scope="col">회원등급</th>
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
	
	
	<jsp:include page="/member/pageMember.jsp"/>
	<jsp:include page="/member/searchMember.jsp"/>
	
	
	
	 </div>
	
	
	
	
	
	
	
    <div class="card-body">
   
			
			<div class="alert alert-primary" role="alert">
  <a href="/listPosting.do" class="alert-link">자유게시판</a></div>
	<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead">
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${listPosting}" var="pdto">
							<tr>
								<td>${pdto.num}</td>
								
								<td>
								<c:forEach begin="1" end="${pdto.repIndent}">
										&nbsp;└
									</c:forEach>
								<a href="/readPosting.do?num=${pdto.num}&curPage=${to.curPage}">${pdto.title}</a></td>
								<td><a href="readSimpleMember.do?id=${pdto.writer}"> ${pdto.writer}</a></td>
								<td>${fn:substring(pdto.writeDay, 0, 10)}</td>
								<td>${pdto.readCnt}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>


		
		
		
		
	
		
	<jsp:include page="/posting/pagePosting.jsp"/>	
	
	<jsp:include page="/posting/searchPosting.jsp"/>

	</div>
	</div>
	</div>
	</div>
	
    </div>
	</div>
	
	
<jsp:include page="/main/footer.jsp"/>







</body></html>
