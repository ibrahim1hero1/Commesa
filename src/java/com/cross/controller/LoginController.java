
package com.cross.controller;

import com.cross.dao.pojo.Corporation;
import com.cross.dao.pojo.Local;
import com.cross.dao.pojo.Login;
import com.cross.dao.pojo.Search;
import com.cross.services.CalendarService;
import com.cross.services.ComponentService;
import com.cross.services.CorporationService;
import com.cross.services.LoginService;
import com.cross.services.RegisterService;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
 


     /*
         @author to Ibrahim Abdsiad Hanna @2016
                    ibrahim.seniore@gmail.com
     */

@Controller
public class LoginController {

    ComponentService componentService;
    CalendarService calendarService;
    RegisterService registerService;  
    LoginService loginService;
    CorporationService corporationService;
    SessionLocaleResolver localeResolver;
    
    
    HttpSession session;

    
    @Autowired
    public void setLocaleResolver(SessionLocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
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
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
     
     @Autowired
    public void setCorporationService(CorporationService corporationService) {
        this.corporationService = corporationService;
    }
         
    
    
    @RequestMapping(value="/local/apply/language", method = RequestMethod.POST)
    public String setLocal(Local local,Model model,Login login,Corporation corporation){
    
          Object userID=session.getAttribute("userID");
        if(userID!=null){
             model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
             return "home";
      
         } 
        else{  
           
      model.addAttribute("countryList", componentService.getCountryMapList(componentService.getCountries()));
        model.addAttribute("corporationTypes", componentService.getCorpotaionMapList(componentService.getCorporationTypes()));
        model.addAttribute("industryTypes", componentService.getIndustriesMapList(componentService.getIndustryTypes()));   
        model.addAttribute("calendarDays", calendarService.getCalendarDays());
        model.addAttribute("calendarMonths", calendarService.getCalendarMonths());
        model.addAttribute("calendarYears", calendarService.getCalendarYears());
       
     
        localeResolver.setDefaultLocale(new Locale(local.getLocalName()));
        session.setAttribute("local", local);
        
         
        return "welcome";
   
        }
       
    }

    @RequestMapping("/welcome")
    public String welcomePage(Local local,Model model,Corporation corporation, Login login) {
      
        Object userID=session.getAttribute("userID");
        if(userID!=null){ 
               model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
             return "home";
        } 
        else{  
           
        model.addAttribute("countryList", componentService.getCountryMapList(componentService.getCountries()));
        model.addAttribute("corporationTypes", componentService.getCorpotaionMapList(componentService.getCorporationTypes()));
         model.addAttribute("industryTypes", componentService.getIndustriesMapList(componentService.getIndustryTypes()));   
        model.addAttribute("calendarDays", calendarService.getCalendarDays());
        model.addAttribute("calendarMonths", calendarService.getCalendarMonths());
        model.addAttribute("calendarYears", calendarService.getCalendarYears());
        
        return "welcome";
        }
       
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(Local local,Model model,Login Login,@Valid Corporation corporation, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("countryList", componentService.getCountryMapList(componentService.getCountries()));
            model.addAttribute("corporationTypes", componentService.getCorpotaionMapList(componentService.getCorporationTypes()));
             model.addAttribute("industryTypes", componentService.getIndustriesMapList(componentService.getIndustryTypes()));   
            model.addAttribute("calendarDays", calendarService.getCalendarDays());
            model.addAttribute("calendarMonths", calendarService.getCalendarMonths());
            model.addAttribute("calendarYears", calendarService.getCalendarYears());
            return "welcome";
        } else if (registerService.exists(corporation.getEmail())) {
            result.rejectValue("email", "DuplicateKey.corporation.email");
            model.addAttribute("countryList", componentService.getCountryMapList(componentService.getCountries()));
            model.addAttribute("corporationTypes", componentService.getCorpotaionMapList(componentService.getCorporationTypes()));
            model.addAttribute("industryTypes", componentService.getIndustriesMapList(componentService.getIndustryTypes()));   
            model.addAttribute("calendarDays", calendarService.getCalendarDays());
            model.addAttribute("calendarMonths", calendarService.getCalendarMonths());
            model.addAttribute("calendarYears", calendarService.getCalendarYears());
            return "welcome";
        }
         registerService.register(corporation);
        return "commesa-registration";
    }

   
    @RequestMapping(value = "/login/authorization", method = RequestMethod.POST)
    public String doLogin(Local local,Model model,@Valid Login login,BindingResult result,Corporation corporation,Search search){
      
         if (result.hasErrors()) {
              result.rejectValue("lpassword", "NotRegistered.corporation.password");
              return "welcome";
         }
         else{
                 Login log=loginService.loginCheck(login.getLemail(), login.getLpassword());
                
      if(log==null){ 
            result.rejectValue("lpassword", "NotRegistered.corporation.password");
            model.addAttribute("countryList", componentService.getCountryMapList(componentService.getCountries()));
            model.addAttribute("corporationTypes", componentService.getCorpotaionMapList(componentService.getCorporationTypes()));
            model.addAttribute("industryTypes", componentService.getIndustriesMapList(componentService.getIndustryTypes()));   
            model.addAttribute("calendarDays", calendarService.getCalendarDays());
            model.addAttribute("calendarMonths", calendarService.getCalendarMonths());
            model.addAttribute("calendarYears", calendarService.getCalendarYears());
      return "welcome";
      }
      else{
   //     model.addAttribute("countryList", componentService.getCountryMapList(componentService.getCountries()));
   //     model.addAttribute("industryList", componentService.getIndustriesMapList(componentService.getIndustryTypes()));
        
          session.setAttribute("userID",log.getId()+"");
          model.addAttribute("coname",log.getCorporationName());
          return "home";
      }
        
         }
        
  
}

   @RequestMapping("/logout")
      public String logout(Local local,Model model, Corporation corporation,Login login) {
       
   /*    SecurityContextHolder.getContext().setAuthentication(null);
       HttpServletRequest request= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();        
       new SecurityContextLogoutHandler().logout(request, null, null);       
     */  
        session.invalidate();
        
        
        return "redirect:/welcome";
      }
      
}
      
   
