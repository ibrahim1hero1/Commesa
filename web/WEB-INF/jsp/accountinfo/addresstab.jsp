<%-- 
    Document   : addresstab.jsp
    Created on : Dec 18, 2016, 4:59:36 PM
    Author     : Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


    <script type="text/javascript">   
      
           var id= '${co.id}';
           var tableCount=${addressList.size()};
          
           $(document).ready(function(){
             $('#addAddress_btn').on('click',function (){
          
          var address=$("#corporationAddress_editText").val();
            if(address.indexOf(".")>=0){
              for(var i=0;i<address.length;i++){
               if(address[i]=='.'){
                  address= address.replace(address.charAt(i),"1111111111");
                }
            }
          
          } 
            $.ajax({
            url : '${pageContext.request.contextPath}/corporation/add/address/'+id+'/'+address,
            error: function () {
                        $("#errorAddAdderss").show();   
                    },
            success : function(data) {
                if(data=='true'){
                    tableCount++;
                     $("#errorAddAdderss").hide();  
                 $('#addressTable > tbody:last-child').append('<tr><td>'+tableCount+'</td><td>'+address+'</td><td>'+'\
                  <div class="pull-right"> '+'<button id="saveAddress_btn" type="button" class="btn btn-primary" > <spring:message code="global.edit" text="Edit"/></button> '+
                    ' <button id="'+tableCount+'editAddress_btn" type="button"  class="btn btn-primary" > <spring:message code="global.delete" text="Delete"/> </button>'+
                    ' <button id="'+tableCount+'saveAddress_btn" type="button" style="display: none;" class="btn btn-primary" > <spring:message code="global.edit" text="Edit"/> </button>'+
                    ' <button id="'+tableCount+'cancelAddress_btn" type="button" style="display: none;" class="btn btn-primary" > <spring:message code="global.delete" text="Delete"/> </button>'+
                    '<div></td>'+
                    '<td><div class="pull-right"> '+
                    '<button id="editMap_btn" type="button"  class="btn btn-primary" > <spring:message code="global.map" text="Map"/> </button></div></td></tr>');
                  $('#addressTable').refresh();
            }
            else if(data=='illegal'){
                 $("#errorEditName").show();
                 
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
      

            }});
          
              });
             
              }); 
           
           
           </script>



  <div class="panel panel-primary">
     <div class="panel-heading"><spring:message code="global.address" text="Address"/></div>
        <div class="panel-body">
          
            <div class="input-group"> 
                <spring:message code="global.address.placeholder" text="Enter Corporation Address" var="addressPlaceHolder"/>
                <input class="form-control" id="corporationAddress_editText" placeholder="${addressPlaceHolder}" type="text"/>
                <span class="input-group-btn">
                <button id="addAddress_btn" type="button" class="btn btn-primary"><spring:message code="global.add" text="Add"/></button>  
                </span>
            </div> 
          
       <a id="errorAddAdderss" style="color: red;display: none;"><spring:message code="Size.address" text="?! Address size not legal" /></a>          
    <table id="addressTable" class="table table-striped"> 
        <th>#</th>
        <th><spring:message code="global.address" text="Address"/></th>
        <th></th>
         <th></th>
      <tbody>
          <c:forEach items="${addressList}" var="addrees" varStatus="counter">
       <tr>
           <td>${counter.count}</td>
           <td>${addrees.addressTitle}</td>
           <td>
            <div class="pull-right">
            <button id="${counter.count}editAddress_btn" onclick="alert('hi');" type="button" class="btn btn-primary" > <spring:message code="global.edit" text="Edit"/> </button>
            <button id="${counter.count}deleteAddress_btn" type="button"  class="btn btn-primary" > <spring:message code="global.delete" text="Delete"/> </button>
            <button id="${counter.count}saveAddress_btn" type="button" style="display: none;" class="btn btn-primary" > <spring:message code="global.edit" text="Edit"/> </button>
            <button id="${counter.count}cancelAddress_btn" type="button" style="display: none;" class="btn btn-primary" > <spring:message code="global.delete" text="Delete"/> </button>
               </div>
           </td>
           <td>
               <div class="pull-right">
                 <button id="editMap_btn" type="button"  class="btn btn-primary" > <spring:message code="global.map" text="Map"/> </button>
               </div>
               </td>
       </tr>
       </c:forEach>
      </tbody>
    </table>
      

                
                
                
        </div></div>
