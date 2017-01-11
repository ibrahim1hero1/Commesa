
package com.cross.services;


 /**
      @author to Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
    */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cross.dao.pojo.Country;
import com.cross.dao.ComponentDao;
import com.cross.dao.pojo.ContainerType;
import com.cross.dao.pojo.CorporationType;
import com.cross.dao.pojo.IndustryType;
import com.cross.dao.pojo.PriceType;
import com.cross.dao.pojo.SizeType;
import com.cross.dao.pojo.WeightType;
import java.util.HashMap;
import java.util.Map;

@Service("componentService")
public class ComponentService {
    
     private ComponentDao componentDao;

        @Autowired
	public void setComponentDao(ComponentDao componentDao) {
        this.componentDao = componentDao;
    }


	public List<Country> getCountries(){	
		return componentDao.getCountries();
	}

  
        public List<CorporationType> getCorporationTypes(){
            return componentDao.getCorporationTypes();
        } 
       
         public List<IndustryType> getIndustryTypes(){
            return componentDao.getIndustryTypes();
        } 
         
         
          public List<WeightType> getWeightTypes(){
            return componentDao.getWeightTypes();
        } 
         
          
         public List<SizeType> getSizeTypes(){
            return componentDao.getSizeTypes();
        } 
         
         public List<PriceType> getPriceTypes(){
            return componentDao.getPriceTypes();
        } 
         
         
         public List<ContainerType> getContainerTypes(){
            return componentDao.getContainerTypes();
        } 
        
         public Map<String,String> getCountryMapList(List<Country> countryList){
             return componentDao.getCountryMapList(countryList);
         }
	
   public Map<String,String> getCorpotaionMapList(List<CorporationType> corporationList){
      return componentDao.getCorpotaionMapList(corporationList);
   }    
   
   public Map<String,String> getIndustriesMapList(List<IndustryType> industryList){
         return componentDao.getIndustriesMapList(industryList);
   }
   
    public Map<String,String> getWeightMapList(List<WeightType> weightList){
         return componentDao.getWeightMapList(weightList);
   }
    
     public Map<String,String> getSizeMapList(List<SizeType> sizeList){
         return componentDao.getSizeMapList(sizeList);
   }
   
     
       public Map<String,String> getPriceMapList(List<PriceType> priceList){
         return componentDao.getPriceMapList(priceList);
   }
       
       
      public Map<String,String> getContainerMapList(List<ContainerType> containerList){
         return componentDao.getContainerMapList(containerList);
   }   
       
       
}
