  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 자세히 보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/main/header.jsp"/>



		
	
<div class="card-group">
  <div class="card">
    
    
    <div class="alert alert-primary" role="alert"> 
  <a href="/readPosting.do?num=${pdto.num}&curPage=${param.curPage}" class="alert-link">게시글 자세히 보기</a></div>
	
<div class="card ">
  <h5 class="card-header"><span>작성자: <a href="readSimpleMember.do"> ${pdto.writer}</a></span> <span class="float-right">작성일: ${pdto.writeDay}</span></h5>
  <div class="card-body">
    <h5 class="card-title">제목: ${pdto.title}</h5>
   
    <p class="card-text">${pdto.content}</p><br>
    
    
    






<c:if test="${pdto.writer == login.id||login.role=='manager'||login.role=='admin'}">
	<button type="button" class="btn btn-warning btn-sm sujeong">수정</button> 
    <button type="button" onclick="rusure();"class="btn btn-danger btn-sm">삭제</button>
</c:if>

    <button type="button" id="list" class="btn btn-info btn-sm">목록</button>
    <button type="button" id="reply" class="btn btn-primary btn-sm">답글</button>
 
</div>
  </div>
</div>
</div>

<form>
	<input type="hidden" name="num" value="${pdto.num}">
	<input type="hidden" name="curPage" value="${param.curPage}">
</form>

<jsp:include page="/main/footer.jsp"/>



<script type="text/javascript">
	$(document).ready(function(){
		
		
	
		
		$("button#reply").click(function() {
			location.assign("/replyuiPosting.do?num=${pdto.num}&curPage=${param.curPage}");
		});
		
		$("button").eq(2).click(function() {
			alert("삭제하시겠습니까?")
			$("form").attr("method", "post");
			$("form").attr("action", "/deletePosting.do");
			$("form").submit();
		});
		
		$(".sujeong").click(function() {
			location.assign("/updateuiPosting.do?num=${pdto.num}&curPage=${param.curPage}");
		});
		
		$("button#list").click(function() {
			location.assign("/listPosting.do?curPage=${param.curPage}");
		});
		
		
	});
</script>
</body>
</html>