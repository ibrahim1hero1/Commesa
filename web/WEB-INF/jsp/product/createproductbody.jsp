<%-- 
    Document   : createproductbody
    Created on : Dec 28, 2016, 9:11:15 PM
    Author     : Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<div class="panel panel-primary">
    <div class="panel-heading"><spring:message code="global.createProduct" text="Create Product"/></div> 
            <div class="panel-body">
                     
                      <sf:form method="post" action="${pageContext.request.contextPath}/product/register" 
                             commandName="product">
                      <div class="form-group">
                            <spring:message code="global.productName.placeholder" var="productNamePlaceholder"/>
                            <label for="addproductname"><spring:message code="global.productName" text="Product Name"/></label>  <a style="color: red"><sf:errors path="productName"/></a>
                            <sf:input path="productName" class="form-control" id="addproductname" placeholder="${productNamePlaceholder}" type="text"/>
                        </div>
                        <div class="form-group">
                            <spring:message code="global.serialNumber.placeholder" var="serialNumberPlaceholder"/>
                            <label for="addserialnumber"><spring:message code="global.serialNumber" text="Serial Number"/></label> <a style="color: red"><sf:errors path="serialNumber"/></a>
                            <sf:input path="serialNumber" class="form-control" id="addserialnumber" placeholder="${serialNumberPlaceholder}" type="text"/>
                        </div>
                        
                        <div class="form-group">
                            <label for="addweight"><spring:message code="global.weight" text="Weight"/> </label><a><sf:errors path="weight"/></a>
                          <div class="row">
                                <div class="col-sm-4">
                                  <sf:select class="form-control" id="addweightType" path="weightType.id">               
                                    <sf:options items="${weightTypes}"/>
                                   </sf:select>
                                </div>
                             <div class="col-sm-4">
                                  <spring:message code="global.weight.placeholder" var="weightPlaceholder"/>
                               <div class="input-group">
                                  <sf:input path="weight" class="form-control" id="addweight" placeholder="${weightPlaceholder}" type="text" aria-describedby="basic-addon1"/>  
                                    <span class="input-group-addon" id="basic-addon1"><spring:message code="global.weight" text="Weight"/></span>
                               </div>
                               </div>   
                           </div>
                          </div>
                                
                            <div class="form-group">
                            <label for="addsize"><spring:message code="global.size" text="Size"/></label> <a><sf:errors path="sizeWidth"/></a>  <a><sf:errors path="sizeHeight"/>
                          
                            <div class="row">
                                <div class="col-sm-4">
                                   <sf:select class="form-control" id="addweightType" path="sizeType.id">               
                                    <sf:options items="${sizeTypes}"/>
                                   </sf:select>         
                                </div>
                             <div class="col-sm-4">
                                  <spring:message code="global.sizeWidth.placeholder" var="sizeWidthPlaceholder"/>
                                   <div class="input-group">
                                  <sf:input path="sizeWidth" class="form-control" id="addsizeWidth" placeholder="${sizeWidthPlaceholder}" type="text" aria-describedby="basic-addon2"/>  
                                    <span class="input-group-addon" id="basic-addon2"><spring:message code="global.width" text="Width"/></span>
                                   </div>
                                   </div>   
                             <div class="col-sm-4">
                                  <spring:message code="global.sizeHeight.placeholder" var="sizeHeightPlaceholder"/>
                                  <div class="input-group">
                                  <sf:input path="sizeHeight" class="form-control" id="addsizeHeight" placeholder="${sizeHeightPlaceholder}" type="text" aria-describedby="basic-addon3"/>  
                                   <span class="input-group-addon" id="basic-addon3"><spring:message code="global.height" text="Height"/></span>
                                  </div>
                                  </div>  
                              </div>
                          </div>     
                       
                                  
                      <div class="form-group">
                            <label for="addprice"><spring:message code="global.price" text="Price"/></label><a><sf:errors path="price"/></a>
                          <div class="row">
                                <div class="col-sm-4">
                                  <sf:select class="form-control" id="addpriceType" path="priceType.id">               
                                    <sf:options items="${priceTypes}"/>
                                   </sf:select>
                                </div>
                             <div class="col-sm-4">
                                  <spring:message code="global.price.placeholder" var="pricePlaceholder"/>
                               <div class="input-group">
                                  <sf:input path="price" class="form-control" id="addweight" placeholder="${pricePlaceholder}" type="text" aria-describedby="basic-addon4"/>  
                                    <span class="input-group-addon" id="basic-addon4"><spring:message code="global.price" text="Price"/></span>
                               </div>
                               </div>
                               
                               <div class="col-sm-4">
                                  <sf:select class="form-control" id="addcontainerType" path="containerType.id">               
                                    <sf:options items="${containerTypes}"/>
                                   </sf:select>
                                </div>
                           </div>
                          </div>             
                                  
                         <div class="form-group">
                            <spring:message code="global.productionDate.placeholder" var="productionDatePlaceholder"/>
                            <label for="addproductiondate"><spring:message code="global.productionDate" text="Production Date"/></label>  <a style="color: red"><sf:errors path="productionDate"/></a>
                            <sf:input path="productionDate" class="form-control" id="addproductiondate" placeholder="${productionDatePlaceholder}" type="text"/>
                        </div>  
                           
                        
                        <div class="form-group">
                            <label for="addDescribtion"><spring:message code="global.description" text="Description" /></label>  <a style="color: red"><sf:errors path="description"/></a>
                            <sf:textarea class="form-control" rows="5" id="addDescribtion" path="description"/>                                        
                           </div>  
                        
                           <div class="form-group">
                               <div class="checkbox">
                                   <label for=""><sf:checkbox id="addavailablebox" path="available" value="true"/> <spring:message code="global.product.availableBox" text="this product ready for purchasing" /> </label>                             
                                 </div>     
                           </div> 
                                  
                           
                           
                        <div class="pull-right"> 
                           <sf:button type="submit" class="btn btn-primary"> <spring:message code="global.add" text="Add"/> </sf:button>
                         </div>
                      </sf:form>  
                    
                     </div>
            </div>
       
      
