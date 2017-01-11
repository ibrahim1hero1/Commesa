
package com.cross.services;

import com.cross.dao.AccountInfoDao;
import com.cross.dao.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

  /*
      @author to Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
    */
   
@Service("accountInfoService")
public class AccountInfoService {
    
    
    AccountInfoDao accountInfoDao;

    @Autowired
    public void setAccountInfoDao(AccountInfoDao accountInfoDao) {
        this.accountInfoDao = accountInfoDao;
    }
    
    
     public boolean updateCorporationName(String corporationID, String newName){
           return accountInfoDao.updateCorporationName(corporationID, newName);
     }
    
       public boolean updateCorporationCountry(String corporationID, String newCountryID){
           return accountInfoDao.updateCorporationCountry(corporationID, newCountryID);
       }
    
         public boolean updateCorporationIndustry(String corporationID, String newIndustryID){
             return accountInfoDao.updateCorporationIndustry(corporationID, newIndustryID);
         }
         
          public boolean updateEstablishedDate(String corporationID, String newDate){
            return accountInfoDao.updateEstablishedDate(corporationID, newDate);
          }
          
       public boolean updateWebAddress(String corporationID, String newWebAddress){
           return accountInfoDao.updateWebAddress(corporationID, newWebAddress);
       }  
       
         public boolean updateGovernmentLegal(String corporationID, String governmentLegal){
               return accountInfoDao.updateGovernmentLegal(corporationID, governmentLegal);
         }
         
         public boolean updateIsoLegal(String corporationID, String isoLegal){  
             return accountInfoDao.updateIsoLegal(corporationID, isoLegal);
         }
         
         
         // handle corporation addresses
         
         public boolean addAddress(Address address){  
             return accountInfoDao.addAddress(address);    
         }
         
         
         
}
