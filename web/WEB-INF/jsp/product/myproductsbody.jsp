<%-- 
    Document   : myproductsbody
    Created on : Dec 28, 2016, 8:11:28 PM
    Author     : Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<style type="text/css">
    
    #emptycloud {
      display:block;
      margin:auto;
     }
     #createproductlink{
       text-align: center;
       vertical-align: central;
       font-size: large;
       
     }
    </style>

<c:if test="${empty myProductsList}">
      <img id="emptycloud" src="<c:url value="/theme/icons/createproduct.png" />" style="width: 50%;height: 50%; "/> 

      <a href="${pageContext.request.contextPath}/product/create"><p id="createproductlink">Create Product</p></a>  
     
</c:if>


<c:forEach items="${myProductsList}" var="myproduct">

 <div class="jumbotron" style="margin: 2px;">
            <div class="container-fluid" >
                <div class="row">
                <div class="col-sm-1">
                    <img width="150" height="150" src="<c:url value="/resources/factories-thumbnail/2.jpg" />" />
                </div>
                <div class="col-sm-12">
                <h3 style="color: #269abc">${myproduct.productName}</h3>  
                <p style="font-family: sans-serif;font-size: 15px;">
                    ${myproduct.description}
                </p> 
                <div class="pull-right"> 
                <a href="${pageContext.request.contextPath}/product/edit/${myproduct.productID}" class="btn btn-info" role="button"><spring:message code="global.edit" text="Edit"/> </a>
                </div>
                </div>
                </div>      
            </div>
        </div>

</c:forEach>
    


