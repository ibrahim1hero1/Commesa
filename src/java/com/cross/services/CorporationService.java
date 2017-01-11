/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cross.services;

import com.cross.dao.CorporationDao;
import com.cross.dao.pojo.Address;
import com.cross.dao.pojo.Corporation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
      @author to Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
    */

@Service("corporationService")
public class CorporationService {
    
    CorporationDao corporationDao;

    
    @Autowired
    public void setCorporationDao(CorporationDao corporationDao) {
        this.corporationDao = corporationDao;
    }
    
  
     public Corporation getCorporation(String corporationID){	
           return corporationDao.getCorporation(corporationID);
       }  
     
      public String getCorporationName(String corporationID){
          return corporationDao.getCorporationName(corporationID);
      }
     
       public List<Address> getCorporationAddress(String corporationID){
            return corporationDao.getCorporationAddress(corporationID);
       }
      
      
}

       
