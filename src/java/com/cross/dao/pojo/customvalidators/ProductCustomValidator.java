
package com.cross.dao.pojo.customvalidators;

import com.cross.dao.pojo.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

     /*
           @author to Ibrahim Abdsaid Hanna @2016
                      ibrahim.seniore@gmail.com
  */
@Component
public class ProductCustomValidator implements Validator  {

    @Override
    public boolean supports(Class<?> type) {     
        return Product.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
     
        Product product = (Product)target;
        
        //////// Validate Weight ///////
        try{
            if(product.getWeight().toString().trim().length()>0){
              if(Double.parseDouble(product.getWeight().toString())<0){
                    errors.rejectValue("weight", "DoubleConverter.product.weight");
              }
            }
            
        }
        catch(Exception ex){
             errors.rejectValue("weight", "DoubleConverter.product.weight");
        }
     
    
        //////// Validate sizeWidth ///////
        try{
            if(product.getSizeWidth().toString().trim().length()>0){
              if(Double.parseDouble(product.getSizeWidth().toString())<0){
                    errors.rejectValue("sizeWidth", "DoubleConverter.product.sizeWidth");
              }
            }
            
        }
        catch(Exception ex){
             errors.rejectValue("sizeWidth", "DoubleConverter.product.sizeWidth");
        }
     

      //////// Validate sizeHeight ///////
         try{
            if(product.getSizeHeight().toString().trim().length()>0){
              if(Double.parseDouble(product.getSizeHeight().toString())<0){
                errors.rejectValue("sizeHeight", "DoubleConverter.product.sizeHeight");
              }
            }
            
        }
        catch(Exception ex){
            errors.rejectValue("sizeHeight", "DoubleConverter.product.sizeHeight");
        }
     

          //////// Validate sizeHeight ///////
       try{
            if(product.getPrice().toString().trim().length()>0){
              if(Double.parseDouble(product.getPrice().toString())<0){
                  errors.rejectValue("price", "DoubleConverter.product.price");
              }
            }
            
        }
        catch(Exception ex){
           errors.rejectValue("price", "DoubleConverter.product.price");
        }
     
    
    }
    
    
    
    
}
