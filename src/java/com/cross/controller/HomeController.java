
package com.cross.controller;

import com.cross.dao.pojo.Corporation;
import com.cross.dao.pojo.Local;
import com.cross.dao.pojo.Login;
import com.cross.dao.pojo.Search;
import com.cross.services.CalendarService;
import com.cross.services.ComponentService;
import com.cross.services.CorporationService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

   /*
       @author to Ibrahim Abdsaid Hanna @2016
                  ibrahim.seniore@gmail.com
   */

@Controller
public class HomeController {
    
    ComponentService componentService;
    CalendarService calendarService;
    CorporationService corporationService;
    HttpSession session;

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
         
      
    @RequestMapping("/home")
    public String homePage(Model model){
      
        Object userID=session.getAttribute("userID");
        if(userID!=null){    
              model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
          //   model.addAttribute("countryList", componentService.getCountryMapList(componentService.getCountries()));
          //   model.addAttribute("industryList", componentService.getIndustriesMapList(componentService.getIndustryTypes()));   
             return "home";
        } 
        else{
            
            return "redirect:/welcome";
        }
      
    }
 
    
}
