<%-- 
    Document   : editproductbody
    Created on : Dec 30, 2016, 1:19:04 PM
    Author     : Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<script type="text/javascript">
    
     $(document).ready(function(){
            
               var pname = '${pr.productName}';
               var dpname = $('<div/>').html(pname).text();
               $('#productName_editText').val(dpname);  
        
               var snumber = '${pr.serialNumber}';
               var dsnumber = $('<div/>').html(snumber).text();
               $('#serialNumber_editText').val(dsnumber);  
        
             
               var pdesc = '${pr.description}';
               var dpdesc = $('<div/>').html(pdesc).text();
               $('#description_editText').val(dpdesc);  
               
             
              $('#edit_btn').on('click',function (){
                 $("#prdouctName_txt").hide();
                 $("#productName_editText").show();
                 $("#serialNumber_txt").hide();
                 $("#serialNumber_editText").show();
                 $("#weight_txt").hide();
                 $("#weight_editDiv").show();
                 $("#width_txt").hide();
                 $("#width_editDiv").show();
                 $("#height_txt").hide();
                 $("#height_editDiv").show();
                 $("#price_txt").hide();
                 $("#price_editDiv").show();
                 $("#productionDate_txt").hide();
                 $("#productionDate_editText").show();
                 $("#description_txt").hide();
                 $("#description_editText").show();
                 $("#available_txt").hide();
                 $("#available_editSelectBox").show();
                 $("#edit_btn").hide();
                 $("#save_btn").show();
              });
               
        
        
        $('#sizeType_firstSelect').on('change',function (){
                  $('#sizeType_secondSelect').val($('#sizeType_firstSelect').val());
              });
        
          $('#sizeType_secondSelect').on('change',function (){
                  $('#sizeType_firstSelect').val($('#sizeType_secondSelect').val());
              });
        
             
           }); 
    
    </script>

   

<div class="panel panel-primary">
    <div class="panel-heading">
        <spring:message code="global.product.info" text="Product info"/>  
    </div> 
    <div class="panel-body">
      
        
  <sf:form method="post" action="${pageContext.request.contextPath}/product/edit/info" commandName="product">      
 <div class="form-group">       
   <table class="table table-striped">
   
    <tbody>
      <tr>
        <td><spring:message code="global.productName" text="Product Name" /></td>
        <td><a id="prdouctName_txt">${pr.productName}</a> 
           
            <sf:input path="productName" class="form-control" id="productName_editText" type="text" style="display: none"/> </td>
      </tr>
      <tr>
        <td><spring:message code="global.serialNumber" text="Serial Number" /></td>
        <td><a id="serialNumber_txt">${pr.serialNumber}</a>
          
             <sf:input path="serialNumber" class="form-control" id="serialNumber_editText" type="text" style="display: none"/></td>
      </tr>
      <tr>
        <td><spring:message code="global.weight" text="Weight" /> </td>
        <td><a id="weight_txt">${pr.weight} (${pr.weightType.name}) </a>
            <div class="row" id="weight_editDiv" style="display: none;">
                <div class="col-sm-4">
                                  <sf:select class="form-control" id="addweightType" path="weightType.id">               
                                    <sf:options items="${weightTypes}"/>
                                   </sf:select>
                                </div>
                             <div class="col-sm-4">
                                  <sf:input path="weight" class="form-control" id="addweight" value="${pr.weight}" type="text"/>                              
                               </div>   
            </div>
        </td>
      </tr>
        <tr>
        <td><spring:message code="global.width" text="Width"/> </td>
        <td><a id="width_txt">${pr.sizeWidth} (${pr.sizeType.name})</a>
            <div class="row" id="width_editDiv" style="display: none;">
                                <div class="col-sm-4">
                                   <sf:select class="form-control" id="sizeType_firstSelect" path="sizeType.id">               
                                    <sf:options items="${sizeTypes}"/>
                                   </sf:select>         
                                </div>
                             <div class="col-sm-4">
                                  <sf:input path="sizeWidth" class="form-control" id="addsizeWidth" value="${pr.sizeWidth}" type="text"/>  
                               </div>   
                            
                          </div>
        </td>
      </tr>
       <tr>
        <td><spring:message code="global.height" text="Height" /></td>
        <td><a id="height_txt">${pr.sizeHeight} (${pr.sizeType.name})</a>
            <div class="row" id="height_editDiv" style="display: none;">
                                <div class="col-sm-4">   
                                        <select class="form-control" id="sizeType_secondSelect">
                                          <c:forEach items="${sizeTypesList}" var="sizeType">
                                              <option value="${sizeType.id}">${sizeType.name}</option>
                                            </c:forEach>
                                          </select>    
                                </div>    
                             <div class="col-sm-4">
                                  <sf:input path="sizeHeight" class="form-control" id="addsizeHeight" value="${pr.sizeHeight}" type="text"/>  
                                </div>  
                              </div>
        </td>
      </tr>
      <tr>
        <td><spring:message code="global.price" text="Price" /> </td>
        <td><a id="price_txt">${pr.price} (${pr.priceType.name} ${pr.containerType.name})</a>
            <div class="row" id="price_editDiv" style="display: none;">
                                <div class="col-sm-4">
                                  <sf:select class="form-control" id="addpriceType" path="priceType.id">               
                                    <sf:options items="${priceTypes}"/>
                                   </sf:select>
                                </div>
                             <div class="col-sm-4">
                                  <sf:input path="price" class="form-control" id="addweight" value="${pr.price}" type="text"/>           
                               </div>
                               
                               <div class="col-sm-4">
                                  <sf:select class="form-control" id="addcontainerType" path="containerType.id">               
                                    <sf:options items="${containerTypes}"/>
                                   </sf:select>
                                </div>
                           </div>
        </td>
      </tr>
       <tr>
        <td><spring:message code="global.productionDate" text="Production Date" /></td>
        <td><a id="productionDate_txt">${pr.productionDate}</a>
            
             <sf:input path="productionDate" class="form-control" id="productionDate_editText" value="${pr.productionDate}" type="text" style="display:none;"/>
        </td>
      </tr>
        <tr>
        <td><spring:message code="global.description " text="Description"/></td>
        <td><a id="description_txt">${pr.description}</a>
            <sf:textarea class="form-control" rows="5" id="description_editText" path="description"  style="display:none;"/>                                     
        </td>
      </tr>
       <tr>
        <td><spring:message code="global.product.readyPurchasing " text="Ready for purchacing " /></td>
        <td>
            <c:choose>
               <c:when test="${pr.available}">
                   <a id="available_txt">  <spring:message code="global.yes " text="Yes " /> </a>
               </c:when>
                <c:otherwise>
                   <a id="available_txt"> <spring:message code="global.no " text="No " /> </a>
              </c:otherwise>
            </c:choose>
            <spring:message code="global.yes" var="yesLable"/>
             <spring:message code="global.no" var="noLable"/>
             
             <sf:select class="form-control" id="available_editSelectBox" path="available" style="display:none;width:15%;">               
               <sf:option value="true" label="${yesLable}"></sf:option>
               <sf:option value="false" label="${noLable}"></sf:option>
            </sf:select>             
                   
        </td>
      </tr>
    </tbody>
  </table>      
 </div>
        
             <sf:input type="hidden" path="productID" value="${pr.productID}"/>
        
            <div class="pull-right"> 
                <button id="edit_btn" type="button"  class="btn btn-primary" > <spring:message code="global.edit" text="Edit"/> </button>
                <button id="save_btn" type="submit" class="btn btn-primary" style="display: none;" > <spring:message code="global.save" text="Save"/> </button>
            </div>
      
  </sf:form>
        
      </div>
   </div>
               
                
