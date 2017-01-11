<%-- 
    Document   : uploadgallery
    Created on : Dec 28, 2016, 9:11:15 PM
    Author     : Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>




<script>
     function lightbox(idx) {
         var ninjaSldr = document.getElementById("ninja-slider");
         ninjaSldr.parentNode.style.display = "block";

         nslider.init(idx);
 
         var fsBtn = document.getElementById("fsBtn");
         fsBtn.click();
     }
 
     function fsIconClick(isFullscreen) { //fsIconClick is the default event handler of the fullscreen button
         if (isFullscreen) {
             var ninjaSldr = document.getElementById("ninja-slider");
             ninjaSldr.parentNode.style.display = "none";
         }
     }
 </script>



<script>

      var imgArray=[];
        <c:forEach items="${productPicturesList}" var="imger" varStatus="counter">  
            imgArray.push('img${imger.imageName}');
        </c:forEach>


   function ajaxDeletePhoto(pname,pid,divID){
     
       $.ajax({
            url : '${pageContext.request.contextPath}/product/delete/photo/'+pid+'/'+pname,
            error: function () {
                        alert("Error please try again!");   
                    },
            success : function(data) {
                if(data=='true'){
                     $("#"+divID).hide();
                      }
                     else if(data='expired'){
                       alert('<spring:message code="global.session.expired" text="Session Expired, please login again"/>');
                       window.open('${pageContext.request.contextPath}/welcome');
                      }
          else if (data='notauthorized'){
            alert('<spring:message code="global.unauthorized" text="Sorry, you are not authorized !"/>');
        }
        else if(data='false'){
            alert('<spring:message code="global.upload.error" text="Error occur! please try again</n> or contact us on www.commesa.com/support"/>');   
        }
      
      
              
            } }); }
   
   
   function ajaxThumbnailPhoto (pname,pid,imgID){
       
      $.ajax({
            url : '${pageContext.request.contextPath}/product/thumbnail/photo/'+pid+'/'+pname,
            error: function () {
                        alert("Error please try again!");   
                    },
            success : function(data) {
                if(data=='true'){
                    
         for(var i=0;i<imgArray.length;i++){
             $("#"+imgArray[i]).css({ 'border' : ''});
            }
        $("#"+imgID).css({ 'border' : '10px groove gold'});
     
        }
          else if(data='expired'){
               alert('<spring:message code="global.session.expired" text="Session Expired, please login again"/>');
                  window.open('${pageContext.request.contextPath}/welcome');
              }
         else if (data='notauthorized'){
            alert('<spring:message code="global.unauthorized" text="Sorry, you are not authorized !"/>');
        }  
            else if(data='false'){
            alert('<spring:message code="global.upload.error" text="Error occur! please try again<\n> or contact us on www.commesa.com/support"/>');   
        }
      
          
            } }); }
   
   
</script>



<style type="text/css">
    
    .gallery{
        cursor: pointer;
    }
    
    </style>

<div class="panel panel-primary" style="width: 100%;">
    <div class="panel-heading"><spring:message code="global.product.uploadpictures" text="Upload pictures"/></div> 
    <div class="panel-body" id='photoPanel'>

        <sf:form action="${pageContext.request.contextPath}/product/upload" method="post" enctype="multipart/form-data"
                 commandName="uploadImage">  
            <a style="color: red"><sf:errors path="file"/></a>
            <input type="hidden" name="pid" value="${pr.productID}"/>
            <div class="form-group"> 
              <spring:message code="global.selectphoto" text="Select Photo"/> <sf:input class="form-control" type="file" path="file"/>  
              <sf:button type= "submit" class="form-control"><spring:message code="global.upload" text="Upload"/></sf:button>  
          </div>
        </sf:form> 
            <div class="gallery">
            <c:forEach items="${productPicturesList}" var="pic" varStatus="counter">   
      
          <div class="form-group" id='div${pic.imageName}'>  
              <c:choose>
                  <c:when test="${pic.imageMaster}">
                      <img onclick="lightbox(${counter.index})" id="img${pic.imageName}" src="<c:url value="/products/${pic.imageName}.jpg"  />" style="width: 50%;height: 5%;border:10px groove gold;"/>                         
                  </c:when>
                  <c:otherwise>
                       <img onclick="lightbox(${counter.index})" id="img${pic.imageName}" src="<c:url value="/products/${pic.imageName}.jpg"  />"  style="width: 50%;height: 5%;"/>       
                  </c:otherwise>
              </c:choose>
             
            <button id="deleteImage_btn" type="button"  class="btn btn-primary" onclick="ajaxDeletePhoto('${pic.imageName}','${pic.product.productID}','div${pic.imageName}');" > <spring:message code="global.delete" text="Delete"/> </button>
            <button id="setMaster_button" type="button" class="btn btn-primary" onclick="ajaxThumbnailPhoto('${pic.imageName}','${pic.product.productID}','img${pic.imageName}');"> <spring:message code="global.master" text="Thumbnail Cover"/> </button>
           
       </c:forEach>
          </div>
             
                
 
                
                
    </div>
</div>
</div>     
