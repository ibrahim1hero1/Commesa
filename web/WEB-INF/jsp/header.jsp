<%-- 
    Document   : header
    Created on : Dec 18, 2016, 4:59:36 PM
    Author     : Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

 <nav class="navbar navbar-default navbar-fixed-top" >
    
  <div class="container-fluid">      
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/home"><spring:message code="global.home" text="Home"/></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="">
      <sf:form class="navbar-form navbar-left" method="post"
               action="#{pageContext.request.contextPath}/doSearch"
               commandName="search">
     
      <div class="form-group">
      <div class="input-group">
      <div class="input-group-btn">
        
      </div><!-- /btn-group -->
       
      <input type="text" class="form-control" aria-label="...">
    </div><!-- /input-group -->
    
     <div class="input-group">
     <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <spring:message code="global.search" text="Search"/> <span class="caret"></span></button>
        <ul class="dropdown-menu">
          <li><a href="#"><spring:message code="global.factory" text="Factory"/></a></li>
          <li><a href="#"><spring:message code="global.product" text="Product"/></a></li>
          <li><a href="#"><spring:message code="global.custome" text="Custom"/></a></li>
        </ul>
      </div><!-- /btn-group -->
       </div>
    
        </div>
      </sf:form>
                 
       
       <sf:form class="navbar-form navbar-right" method="post" > 
          Welcome, 
        <div class="form-group">
        <div class="input-group">
        <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${coname} <span class="caret"></span></button>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/account/info"><spring:message code="global.accountInformation" text="Account Information"/></a></li>
          <li><a href="#"> <spring:message code="global.accountSettings" text=" Account Settings"/></a></li>
          <li role="separator" class="divider"></li>
          <li><a href="${pageContext.request.contextPath}/product/create"> <spring:message code="global.createProduct" text="Create Product"/></a></li>
          <li><a href="${pageContext.request.contextPath}/my/products"><spring:message code="global.myProducts" text="My Products"/></a></li>
         
          <li role="separator" class="divider"></li>
          <li><a href="${pageContext.request.contextPath}/logout"><spring:message code="global.signout" text="Sign out"/></a></li>
        </ul>
      </div><!-- /btn-group -->
       </div>
       </div>
      </sf:form>   
     
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
     <br/>
     <br/>
     <br/>
