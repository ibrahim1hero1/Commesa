
package com.cross.dao.pojo.customvalidators;

 

import com.cross.dao.pojo.UploadImage;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;  
import org.springframework.validation.Validator; 


     /**
      @author to Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
    */ 

@Component
public class ImageValidator implements Validator { 
 
  
    
    
     @Override
    public boolean supports(Class<?> type) {       
       return UploadImage.class.isAssignableFrom(type);
    } 

     @Override
    public void validate(Object obj, Errors errors) { 

         try {
             UploadImage uploadImage = (UploadImage) obj;
             
             if (uploadImage.getFile().getSize() == 0) {
                 errors.rejectValue("file", "global.image.notselected");
             }
             else if (uploadImage.getFile().getBytes().length >2048*1000 ) {
                 errors.rejectValue("file", "global.image.illegalsize");
             }
     
             else{
                 Image image=null;
                 try {
                     image = ImageIO.read(uploadImage.getFile().getInputStream());
                 } catch (IOException ex) {
                     Logger.getLogger(ImageValidator.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 if(image==null){
                     errors.rejectValue("file", "global.image.notsupported");
                 }
             }
         } catch (Exception ex) {
             Logger.getLogger(ImageValidator.class.getName()).log(Level.SEVERE, null, ex);
         }
              
    } 
} 
