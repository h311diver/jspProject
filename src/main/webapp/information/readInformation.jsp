<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 자세히 보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>

<jsp:include page="/main/header.jsp"/>

<div class="card-group shadow-lg">
  <div class="card">
    
    
    <div class="alert alert-danger" role="alert"> 
  <a href="/readInformation.do?num=${idto.num}" class="alert-link">문의사항 자세히 보기</a></div>
	
<div class="card ">
  <h5 class="card-header"><span>작성자: ${idto.writer}</span> <span class="float-right">작성일: ${idto.writeDay}</span></h5>
  <div class="card-body">
    <h5 class="card-title">제목: ${idto.title}</h5>
   
    <p class="card-text">${idto.content}</p><br>
    
    
    
    

 

 


<c:if test="${idto.writer == login.id||login.role=='manager'||login.role=='admin'}">
<button type="button" class="btn btn-warning btn-sm sujeong">수정</button> 
    <button type="button" class="btn btn-danger btn-sm">삭제</button>
</c:if>

<c:if test="${login.role == 'admin' || login.role == 'manager'}">
     <button type="button" id="reply" class="btn btn-primary btn-sm">답변하기</button>
    </c:if>
   <button type="button" id="list" class="btn btn-info btn-sm">목록</button>
   

 </div>
</div>


<form>
	<input type="hidden" name="num" value="${idto.num}">
	<input type="hidden" name="curPage" value="${param.curPage}">
</form>


</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		
		
	
		
		$("button#reply").click(function() {
			location.assign("/replyuiInformation.do?num=${idto.num}&curPage=${param.curPage}");
		});
		
		$("button").eq(2).click(function() {
			alert("삭제하시겠습니까?")
			$("form").attr("method", "post");
			$("form").attr("action", "/deleteInformation.do");
			$("form").submit();
		});
		
		$(".sujeong").click(function() {
			location.assign("/updateuiInformation.do?num=${idto.num}&curPage=${param.curPage}");
		});
		
		$("button#list").click(function() {
			location.assign("/listInformation.do?curPage=${param.curPage}");
		});
		
		
	});
</script>



<jsp:include page="/main/footer.jsp"/>


</body>
</html>