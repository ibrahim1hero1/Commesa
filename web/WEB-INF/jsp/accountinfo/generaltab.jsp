<%-- 
    Document   : generaltab
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
          
           
           $(document).ready(function(){

           $("#corporationCountry_Select").val(${co.country.id});
           $("#industryType_Select").val(${co.industryType.id});
           $("#governmentLegal_Select").val('${co.governmentLegal}');
           $("#isoLegal_Select").val('${co.isoLegal}');
          
           /////////////// Edit Corporation Name ///////////////
              $('#editName_btn').on('click',function (){
                  $("#corporationName_txt").hide();
                 $("#editName_btn").hide();
                  $("#corporationName_editText").show(); 
                  $("#saveName_btn").show();    
              });
              
             $('#saveName_btn').on('click',function (){
            
         
          var newname=$("#corporationName_editText").val();
            if(newname.indexOf(".")>=0){
              for(var i=0;i<newname.length;i++){
               if(newname[i]=='.'){
                  newname= newname.replace(newname.charAt(i),"1111111111");
                }
            }
          
          } 
            $.ajax({
            url : '${pageContext.request.contextPath}/corporation/edit/name/'+id+'/'+newname,
            error: function () {
                        $("#errorEditName").show();   
                    },
            success : function(data) {
                if(data=='true'){
                 $("#errorEditName").hide();
                 $("#corporationName_txt").text($("#corporationName_editText").val());
                 $("#corporationName_editText").hide(); 
                 $("#saveName_btn").hide();    
                 $("#corporationName_txt").show();
                 $("#editName_btn").show();  
            }
            else if(data=='illegalsize'){
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
              
              ///////////////////////////////////////////////////////
              
                $('#editCountry_btn').on('click',function (){
                  $("#corporationCountry_txt").hide();
                 $("#editCountry_btn").hide();  
                  $("#corporationCountry_Select").show(); 
                  $("#saveCountry_btn").show();   
               });
    
              
      $('#saveCountry_btn').on('click',function (){
            
      
          var newCountryID=$("#corporationCountry_Select").val();
            $.ajax({
            url : '${pageContext.request.contextPath}/corporation/edit/country/'+id+'/'+newCountryID,
            error: function () {
                         alert("Error please try again!");    
                    },
            success : function(data) {
                if(data=='true'){
                 $("#corporationCountry_txt").text($("#corporationCountry_Select option:selected").text());
                 $("#corporationCountry_Select").hide(); 
                 $("#saveCountry_btn").hide();    
                 $("#corporationCountry_txt").show();
                 $("#editCountry_btn").show();  
            }
            else if(data=='illegalsize'){
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
              ////////////////////////////////////////////////
             
              $('#editCorporationIndustry_btn').on('click',function (){
                  $("#industryType_txt").hide();
                 $("#editCorporationIndustry_btn").hide();
                  $("#industryType_Select").show(); 
                  $("#saveCorporationIndustry_btn").show();   
               });
             
       $('#saveCorporationIndustry_btn').on('click',function (){
          var newIndustryID=$("#industryType_Select").val();
            $.ajax({
            url : '${pageContext.request.contextPath}/corporation/edit/industry/'+id+'/'+newIndustryID,
            error: function () {
                         alert("Error please try again!");    
                    },
            success : function(data) {
                if(data=='true'){
                 $("#industryType_txt").text($("#industryType_Select option:selected").text());
                 $("#industryType_Select").hide(); 
                 $("#saveCorporationIndustry_btn").hide();    
                 $("#industryType_txt").show();
                 $("#editCorporationIndustry_btn").show();  
            }
            else if(data=='illegalsize'){
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
              
            $('#editEstablishedDate_btn').on('click',function (){
                 $("#establishedDate_txt").hide();
                 $("#editEstablishedDate_btn").hide();
                 $("#establishedDate_editText").show(); 
                 $("#saveEstablishedDate_btn").show();   
               });
               
         $('#saveEstablishedDate_btn').on('click',function (){
                   
          var newdate=$("#establishedDate_editText").val();
            $.ajax({
            url : '${pageContext.request.contextPath}/corporation/edit/established/'+id+'/'+newdate,
            error: function () {
                        $("#errorEstablishedDate").show();   
                    },
            success : function(data) {
                if(data=='true'){
                 $("#errorEstablishedDate").hide();
                 $("#establishedDate_txt").text($("#establishedDate_editText").val());
                 $("#establishedDate_editText").hide(); 
                 $("#saveEstablishedDate_btn").hide();    
                 $("#establishedDate_txt").show();
                 $("#editEstablishedDate_btn").show();  
            }
            else if(data=='illegaldate'){
                 $("#errorEstablishedDate").show();
                 
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
               
          $('#editWebAddress_btn').on('click',function (){
                 $("#webAddress_txt").hide();
                 $("#editWebAddress_btn").hide();
                 $("#webAddress_editText").show(); 
                 $("#saveWebAddress_btn").show();   
               });      
              
       $('#saveWebAddress_btn').on('click',function (){
          var newaddress=$("#webAddress_editText").val();
          if(newaddress.indexOf(".")>=0){
              for(var i=0;i<newaddress.length;i++){
               if(newaddress[i]=='.'){
                  newaddress= newaddress.replace(newaddress.charAt(i),"1111111111");
                }
            }
          
          }          
       
            $.ajax({
            url : '${pageContext.request.contextPath}/corporation/edit/webaddress/'+id+'/'+newaddress,
            error: function () {
                        $("#errorWebAddress").show();   
                    },
            success : function(data) {
                if(data=='true'){
                 $("#errorWebAddress").hide();
                 $("#webAddress_txt").text($("#webAddress_editText").val());
                 $("#webAddress_editText").hide(); 
                 $("#saveWebAddress_btn").hide();  
                 $("#webAddress_txt").show();
                 $("#editWebAddress_btn").show();  
            }
            else if(data=='illegaladdress'){
                 $("#errorWebAddress").show();
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
              
              
             $('#editGovernmentLegal_btn').on('click',function (){
                 $("#governmentLegal_txt").hide();
                 $("#editGovernmentLegal_btn").hide();
                 $("#governmentLegal_Select").show(); 
                 $("#saveGovernmentLegal_btn").show();   
               });   
               
         $('#saveGovernmentLegal_btn').on('click',function (){
          var newLegal=$("#governmentLegal_Select").val();
       
            $.ajax({
            url : '${pageContext.request.contextPath}/corporation/edit/governmentlegal/'+id+'/'+newLegal,
            error: function () {
                         alert("Error please try again!");    
                    },
            success : function(data) {
                if(data=='true'){
                 $("#governmentLegal_txt").text($("#governmentLegal_Select option:selected").text());
                 $("#governmentLegal_Select").hide(); 
                 $("#saveGovernmentLegal_btn").hide();    
                 $("#governmentLegal_txt").show();
                 $("#editGovernmentLegal_btn").show();  
            }
            else if(data=='illegal'){
                 $("#errorillegalGovernment").show();
                 
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
               
             $('#editIsoLegal_btn').on('click',function (){
                 $("#isoLegal_txt").hide();
                 $("#editIsoLegal_btn").hide();
                 $("#isoLegal_Select").show(); 
                 $("#saveIsoLegal_btn").show();   
               });      
          
     $('#saveIsoLegal_btn').on('click',function (){
          var newLegal=$("#isoLegal_Select").val();
       
            $.ajax({
            url : '${pageContext.request.contextPath}/corporation/edit/isolegal/'+id+'/'+newLegal,
            error: function () {
                         alert("Error please try again!");    
                    },
            success : function(data) {
                if(data=='true'){
                 $("#isoLegal_txt").text($("#isoLegal_Select option:selected").text());
                 $("#isoLegal_Select").hide(); 
                 $("#saveIsoLegal_btn").hide();    
                 $("#isoLegal_txt").show();
                 $("#editIsoLegal_btn").show();  
            }
            else if(data=='illegal'){
                 $("#errorillegalGovernment").show();
                 
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
            <div class="panel-heading">General Information</div> 
            <div class="panel-body">
                             

             
    <table class="table table-striped"> 
    <tbody>
      <tr>
          <td style="width: 15%"><spring:message code="global.corporationName" text="Corporation Name" /></td>
          <td style="width: auto;">
            <a id="corporationName_txt">${co.name}</a> 
            <input class="form-control" id="corporationName_editText" value="${co.name}" type="text" style="display: none;width: 75%;"/>
            <div class="pull-right"> 
            <button id="editName_btn" type="button" class="btn btn-primary" > <spring:message code="global.edit" text="Edit"/> </button>
            </div>
            <button id="saveName_btn" type="button" class="btn btn-primary"  style="display: none;margin-top: 5px;" > <spring:message code="global.save" text="Save"/> </button>
            <a id="errorEditName" style="color: red;display: none;"><spring:message code="Size.corporation.name" text=" Corporation Name size not legal" /></a> 
          </td>
      </tr>
            
       <tr>
          <td style="width: 15%"><spring:message code="global.corporationCountry" text="Corporation Country" /></td>
          <td style="width: auto;"><a id="corporationCountry_txt">${co.country.name}</a> 
              <select class="form-control" id="corporationCountry_Select" type="text" style="display: none;width: 75%;">
                 <c:forEach items="${countryList}" var="country">
                  <option value="${country.id}">${country.name}</option>
                 </c:forEach> 
              </select>
           <div class="pull-right"> 
            <button id="editCountry_btn" type="button"  class="btn btn-primary" onclick="showEdit('corporationCountry_editText')" > <spring:message code="global.edit" text="Edit"/> </button>          
           </div>
            <button id="saveCountry_btn" type="button" class="btn btn-primary" style="display: none;margin-top: 5px;" > <spring:message code="global.save" text="Save"/> </button>
         </td> 
      </tr> 
      
     <tr>
          <td style="width: 15%"><spring:message code="global.corporationType" text="Corporation Type" /></td>
          <td style="width: auto;"><a id="corporationType_txt">${co.corporationType.name}</a> 
          <input class="form-control" id="corporationType_editText" type="text" style="display: none"/>
            <div class="pull-right"> 
            <button id="editCorporationType_btn" type="button"  class="btn btn-primary"> <spring:message code="global.edit" text="Edit"/> </button>
           </div>
            <button id="saveCorporationType_btn" type="button" class="btn btn-primary" style="display: none;margin-top: 5px;" > <spring:message code="global.save" text="Save"/> </button>
         </td>
      </tr> 
          
      
       <tr>
          <td style="width: 15%"><spring:message code="global.industrtyType" text="Industry Type" /></td>
          <td style="width: auto;"><a id="industryType_txt">${co.industryType.name}</a> 
           <select class="form-control" id="industryType_Select"  style="display: none;width: 75%;">
                 <c:forEach items="${industryTypes}" var="industry">
                  <option value="${industry.id}">${industry.name}</option>
                 </c:forEach> 
              </select>
         <div class="pull-right"> 
            <button id="editCorporationIndustry_btn" type="button"  class="btn btn-primary" > <spring:message code="global.edit" text="Edit"/> </button>          
           </div>
             <button id="saveCorporationIndustry_btn" type="button" class="btn btn-primary" style="display: none;margin-top: 5px;"> <spring:message code="global.save" text="Save"/> </button>
         </td>
      </tr>  
           
       <tr>
          <td style="width: 15%"><spring:message code="global.establishedDate" text="Established Date" /></td>
          <td style="width: auto;"><a id="establishedDate_txt">${co.establishedDate}</a> 
              <input class="form-control" id="establishedDate_editText" value="${co.establishedDate}" type="text" style="display: none;width: 75%;"/>
            <div class="pull-right"> 
            <button id="editEstablishedDate_btn" type="button"  class="btn btn-primary"> <spring:message code="global.edit" text="Edit"/> </button>
           </div>
           <button id="saveEstablishedDate_btn" type="button" class="btn btn-primary" style="display: none;margin-top: 5px;" > <spring:message code="global.save" text="Save"/> </button>
            <a id="errorEstablishedDate" style="color: red;display: none;"><spring:message code="Pattern.corporation.establishedDate" text=" please enter date like this (2017-11-1)" /></a> 
          </td>
      </tr>  
      
       <tr>
          <td style="width: 15%"><spring:message code="global.siteURL" text="Web Address" /></td>
          <td style="width: auto;"><a id="webAddress_txt">${co.webAddress}</a> 
              <input class="form-control" id="webAddress_editText" value="${co.webAddress}" type="text" style="display: none;width: 75%;"/>
            <div class="pull-right"> 
            <button id="editWebAddress_btn" type="button"  class="btn btn-primary"> <spring:message code="global.edit" text="Edit"/> </button>                           
           </div>
             <button id="saveWebAddress_btn" type="button" class="btn btn-primary" style="display: none;margin-top: 5px;" > <spring:message code="global.save" text="Save"/> </button>
            <a id="errorWebAddress" style="color: red;display: none;"><spring:message code="Pattern.corporation.webaddress" text="!? not valid, web address should start with www." /></a> 
          </td>
      </tr>  
      
      
       <tr>
          <td style="width: 15%"><spring:message code="global.aboutCorporation" text="About Corporation" /></td>
          <td style="width: auto;"><a id="aboutCorporation_txt">${co.descrbtion}</a> 
          <input class="form-control" id="aboutCorporation_editText" type="text" style="display: none"/>
            <div class="pull-right"> 
            <button id="editAboutCorporation_btn" type="button"  class="btn btn-primary"> <spring:message code="global.edit" text="Edit"/> </button>
           
           </div>
             <button id="saveAboutCorporation_btn" type="button" class="btn btn-primary" style="display: none;;margin-top: 5px;" > <spring:message code="global.save" text="Save"/> </button>
         </td>
      </tr>  
      
      
        <tr>
          <td style="width: 15%"><spring:message code="global.governmentLegal" text="Government License Available" /></td>
          <td style="width: auto;">
                <c:choose>
                <c:when test="${co.governmentLegal}"> 
                   <a id="governmentLegal_txt"><spring:message code="global.yes" text="Yes" /></a>
                 </c:when>
                    <c:otherwise>
                         <a id="governmentLegal_txt"><spring:message code="global.no" text="No" /></a> 
                    </c:otherwise>
                </c:choose>
              
                         <select class="form-control" id="governmentLegal_Select"  style="display: none;width: 75%;">
                             <option value="true">Yes</option>
                             <option value="false">No</option>
                         </select>
            <div class="pull-right"> 
            <button id="editGovernmentLegal_btn" type="button"  class="btn btn-primary" > <spring:message code="global.edit" text="Edit"/> </button>
           </div>
           <button id="saveGovernmentLegal_btn" type="button" class="btn btn-primary" style="display: none;;margin-top: 5px;" > <spring:message code="global.save" text="Save"/> </button>
           <a id="errorillegalGovernment" style="color: red;display: none;"><spring:message code="global.error" text="error!" /></a> 
          </td>
      </tr>  
      
      
       <tr>
          <td style="width: 15%"><spring:message code="global.isoLegal" text="ISO License Available" /></td>
          <td style="width: auto;">
                <c:choose>
               <c:when test="${co.isoLegal}"> 
                   <a id="isoLegal_txt"><spring:message code="global.yes" text="Yes" /></a>
               </c:when>
                    <c:otherwise>
                         <a id="isoLegal_txt"><spring:message code="global.no" text="No" /></a> 
                    </c:otherwise>
                </c:choose>
              
         
                         <select class="form-control" id="isoLegal_Select"  style="display: none;width: 75%;">
                             <option value="true">Yes</option>
                             <option value="false">No</option>
                         </select>
                         
            <div class="pull-right"> 
            <button id="editIsoLegal_btn" type="button"  class="btn btn-primary"> <spring:message code="global.edit" text="Edit"/> </button>
            
           </div>
            <button id="saveIsoLegal_btn" type="button" class="btn btn-primary" style="display: none;margin-top: 5px;"> <spring:message code="global.save" text="Save"/> </button>
         </td>
      </tr>  
      
      
    </tbody>
    </table>
    
    
            </div>                      
   </div>
