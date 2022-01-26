<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<input type="hidden" name="criteria" value="${param.criteria}">
<input type="hidden" name="keyword" value="${param.keyword}">

<nav aria-label="페이지 번호가 적혀 있음">
  <ul class="pagination justify-content-center">
    <li class="page-item" >
       <a class="page-link" href="/searchPosting.do?curPage=${to.curPage <= 1 ? 1 : to.curPage-1}&criteria=${param.criteria}&keyword=${param.keyword}">&laquo;</a>
    </li>
     <c:forEach begin="${to.beginPageNum}" end="${to.endPageNum}" var="i">
    <li class="page-item ${i==to.curPage?'active':''}">
       <a class="page-link" href="/searchPosting.do?curPage=${i}&criteria=${param.criteria}&keyword=${param.keyword}">${i}</a>
    </li>
     </c:forEach>
    <li class="page-item" >
       <a class="page-link" href="/searchPosting.do?curPage=${to.curPage >= to.totalPage ? to.totalPage : to.curPage+1}&criteria=${param.criteria}&keyword=${param.keyword}">&raquo;</a>
    </li>
  </ul>
</nav>