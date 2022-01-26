<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form action="/searchMember.do" method="get" target="_blank">
  <div class="form-row align-items-center">
    <div class="col-auto my-1">
      <label class="mr-sm-2 sr-only">검색창</label>
      <select class="custom-select mr-sm-2" name="criteria">
       
        
        <option selected value="id">아이디</option>
       <option value="name">이름</option>
       
      </select>
    </div>
    
    <div class="col-sm-8 col-xl-5 my-1">
        <input class="form-control" name="keyword">
    </div>
    
    <div class="col-auto my-1">
      <button type="submit" class="btn btn-info">검색</button>
    </div>
  </div>
</form>
