<%-- 
    Document   : accountinfobody
    Created on : Dec 18, 2016, 4:59:36 PM
    Author     : Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<ul class="nav nav-tabs">
   <li class="active"><a data-toggle="tab" href="#general"><spring:message code="global.generalinformation" text="General Information"/></a></li>
   <li><a data-toggle="tab" href="#address"><spring:message code="global.address" text="Address"/></a></li>
   <li><a data-toggle="tab" href="#tel"><spring:message code="global.telephone" text="Telephone"/></a></li>
   <li><a data-toggle="tab" href="#mobile"><spring:message code="global.mobile" text="Mobile"/></a></li>
   <li><a data-toggle="tab" href="#fax"><spring:message code="global.fax" text="Fax"/></a></li>
   <li><a data-toggle="tab" href="#map"><spring:message code="global.map" text="Map"/></a></li>
 </ul>

    <div class="tab-content">
    <div id="general" class="tab-pane fade in active">
      <jsp:include page="generaltab.jsp"/> 
  </div>
 
    <div id="address" class="tab-pane fade">
       <jsp:include page="addresstab.jsp"/>
    </div>
        
    <div id="tel" class="tab-pane fade">
       <jsp:include page="telephonetab.jsp"/>
    </div>
    
    <div id="mobile" class="tab-pane fade">
       <jsp:include page="mobiletab.jsp"/>
    </div>
    
    <div id="fax" class="tab-pane fade">
       <jsp:include page="faxtab.jsp"/>
    </div>
    
     <div id="map" class="tab-pane fade">
       <jsp:include page="maptab.jsp"/>
    </div>
    
    </div>
