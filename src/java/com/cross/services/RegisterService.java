
package com.cross.services;

import com.cross.dao.RegisterDao;
import com.cross.dao.pojo.Corporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
      @author to Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
    */

@Service("registerService")
public class RegisterService {
    
    RegisterDao registerDao;

     @Autowired
    public void setRegisterDao(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }
    
    
    public boolean register(Corporation corporation) {
        return registerDao.register(corporation);
    }
    
    public boolean exists(String email) {	
        return  registerDao.exists(email);
    }
    
}
