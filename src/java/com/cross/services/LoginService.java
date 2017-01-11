
package com.cross.services;

import com.cross.dao.LoginDao;
import com.cross.dao.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


   /*
        @author to Ibrahim Abdsaid Hanna @2016
                   ibrahim.seniore@gmail.com
    */

 @Service("loginService")
public class LoginService {
    
     LoginDao loginDao;

     @Autowired
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
     
  
    public Login loginCheck(String logemail, String logpassword){
         return loginDao.loginCheck(logemail, logpassword);
    }
     
}
