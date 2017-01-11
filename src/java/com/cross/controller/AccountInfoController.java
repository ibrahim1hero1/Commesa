
package com.cross.controller;

import com.cross.dao.pojo.Address;
import com.cross.dao.pojo.Corporation;
import com.cross.dao.pojo.Local;
import com.cross.dao.pojo.Login;
import com.cross.services.AccountInfoService;
import com.cross.services.CalendarService;
import com.cross.services.ComponentService;
import com.cross.services.CorporationService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;


 /*
  @author to Ibrahim Abdsaid Hanna @2016
             ibrahim.seniore@gmail.com
 */

@Controller
public class AccountInfoController {
    
    ComponentService componentService;
    CalendarService calendarService;
    CorporationService corporationService;
    AccountInfoService accountInfoService;
    HttpSession session;
    Pattern pattern;
   
    public AccountInfoController(){
           pattern=Pattern.compile("^$|((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])");       
    }
    
    
    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Autowired
    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }
    @Autowired
    public void setCalendarService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }
    
     @Autowired
    public void setCorporationService(CorporationService corporationService) {
        this.corporationService = corporationService;
    }

     @Autowired
    public void setAccountInfoService(AccountInfoService accountInfoService) {
        this.accountInfoService = accountInfoService;
    }

   
       
    
    @RequestMapping("/account/info")
    public String viewAccountInfo(Model model, Corporation corporation){
       
        Object userID=session.getAttribute("userID");
         if(userID!=null){
        Corporation corporationModel=corporationService.getCorporation(userID.toString());    
        model.addAttribute("co",corporationModel );
        model.addAttribute("coname",corporationModel.getName());
        model.addAttribute("countryList", componentService.getCountries());
        model.addAttribute("corporationTypes", componentService.getCorporationTypes());
        model.addAttribute("industryTypes", componentService.getIndustryTypes()); 
        model.addAttribute("addressList", corporationService.getCorporationAddress(userID.toString())); 
      
          
          return "accountinfo";
         } 
         else{ 
          return "redirect:/welcome";
         } 
    }
    
    
    @RequestMapping(value="/corporation/edit/name/{id}/{newname}",method=RequestMethod.GET) 
    @ResponseBody
    public String updateCorporationName(@PathVariable String id,@PathVariable String newname) {  
        
        
          Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!userID.equals(id)){
               return "notauthorized";
             }  
         
         
         if(newname.trim().equals("")){
             return "illegalsize";
         }
          newname= newname.replace("1111111111", ".");
          if(newname.trim().length()>255){
             return "illegalsize";
         }
         
    
            return ""+accountInfoService.updateCorporationName(id,newname);
          }
          else{
           return "expired";  
          }

    }
    
    
    
    @RequestMapping(value="/corporation/edit/country/{id}/{newcountryID}",method=RequestMethod.GET) 
    @ResponseBody
    public String updateCorporationCountry(@PathVariable String id,@PathVariable String newcountryID) {  
        
        
          Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!userID.equals(id)){
               return "notauthorized";
             }  
         
            return ""+accountInfoService.updateCorporationCountry(id,newcountryID);
          }
          else{
           return "expired";  
          }
    }
 
  
    
       
    @RequestMapping(value="/corporation/edit/industry/{id}/{newindustryID}",method=RequestMethod.GET) 
    @ResponseBody
    public String updateCorporationIndustry(@PathVariable String id,@PathVariable String newindustryID) {  
        
        
          Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!userID.equals(id)){
               return "notauthorized";
             }  
         
            return ""+accountInfoService.updateCorporationIndustry(id,newindustryID);
          }
          else{
           return "expired";  
          }
    }
    
    
    @RequestMapping(value="/corporation/edit/established/{id}/{newdate}",method=RequestMethod.GET) 
    @ResponseBody
    public String updateEstablishedDate(@PathVariable String id,@PathVariable String newdate) {  

          Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!userID.equals(id)){
               return "notauthorized";
             }  
         if(HtmlUtils.htmlEscape(newdate.trim()).equals("")){
             return "illegaldate";
         }
          
          if(!pattern.matcher(newdate).find()){
             return "illegaldate";
         }
         
    
            return ""+accountInfoService.updateEstablishedDate(id,newdate);
          }
          else{
           return "expired";  
          }

    }
    
    
    
    
    @RequestMapping(value="/corporation/edit/webaddress/{id}/{newaddress}",method=RequestMethod.GET) 
    @ResponseBody
    public String updateWebAddress(@PathVariable String id,@PathVariable String newaddress) {  

          Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!userID.equals(id)){
               return "notauthorized";
             }  
         if(HtmlUtils.htmlEscape(newaddress.trim()).equals("")){
             return "illegaladdress";
         }
          
       
             newaddress= newaddress.replace("1111111111", ".");
         
         
         
          if(!HtmlUtils.htmlEscape(newaddress).startsWith("www.")){
             return "illegaladdress";
         }
         
    
            return ""+accountInfoService.updateWebAddress(id,newaddress);
          }
          else{
           return "expired";  
          }

    }
   
    @RequestMapping(value="/corporation/edit/governmentlegal/{id}/{newlegal}",method=RequestMethod.GET) 
    @ResponseBody
    public String updateGovernmentLegal(@PathVariable String id,@PathVariable String newlegal) {  

          Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!userID.equals(id)){
               return "notauthorized";
             }  
         if(HtmlUtils.htmlEscape(newlegal).equals("true")||HtmlUtils.htmlEscape(newlegal).equals("false")){
               return ""+accountInfoService.updateGovernmentLegal(id,newlegal);
         }
         else{
              return "illegal";
         }
         
          }
          else{
           return "expired";  
          }

    }
    
    
      
    @RequestMapping(value="/corporation/edit/isolegal/{id}/{newlegal}",method=RequestMethod.GET) 
    @ResponseBody
    public String updateIsoLegal(@PathVariable String id,@PathVariable String newlegal) {  

          Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!userID.equals(id)){
               return "notauthorized";
             }  
         if(HtmlUtils.htmlEscape(newlegal).equals("true")||HtmlUtils.htmlEscape(newlegal).equals("false")){
               return ""+accountInfoService.updateIsoLegal(id,newlegal);
         }
         else{
              return "illegal";
         }
         
          }
          else{
           return "expired";  
          }
    }  
    
    
    
    // handle corporation addresses
    
    @RequestMapping(value="/corporation/add/address/{id}/{address}",method=RequestMethod.GET) 
    @ResponseBody
    public String addAddress(@PathVariable String id,@PathVariable String address) {  

          Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!userID.equals(id)){
               return "notauthorized";
             }  
         
         if(HtmlUtils.htmlEscape(address.trim()).equals("") || HtmlUtils.htmlEscape(address.trim()).length()>255 ){
              return "illegal"; 
         }
          address= address.replace("1111111111", ".");
         Corporation corporation=corporationService.getCorporation(HtmlUtils.htmlEscape(id));
              Address addressObj=new Address();
              addressObj.setCorporation(corporation);
              addressObj.setAddressTitle(address);
         return ""+accountInfoService.addAddress(addressObj);
         
          }
          else{
           return "expired";  
          }
    }  
    

    
}
