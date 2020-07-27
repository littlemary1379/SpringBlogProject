<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %> 

<div class="container">
   <form class="was-validated" >
     
     <div class="form-group">
       <label for="username">Username:</label>
       <button type="button" id ="btn-username-check" class="btn btn-warning float-right">중복확인</button>
       <input type="text" id="username" class="form-control" placeholder="Enter username" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>
     
     <div class="form-group">
       <label for="pwd">Password:</label>
       <input type="password" id="password" class="form-control" placeholder="Enter password" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>
     
     <div class="form-group">
       <label for="email">Email:</label>
       <input type="email" id="email" class="form-control" placeholder="Enter Email" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>

     <button id="btn-save" type="button" class="btn btn-primary">회원가입완료</button>
   </form>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
