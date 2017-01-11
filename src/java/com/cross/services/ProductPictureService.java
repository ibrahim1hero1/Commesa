
package com.cross.services;

import com.cross.dao.ProductPicturesDao;
import com.cross.dao.pojo.ProductPicture;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
      @author to Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
    */

 @Service("productPictureService")
public class ProductPictureService {
    
     ProductPicturesDao productPicturesDao;

    @Autowired
    public void setProductPicturesDao(ProductPicturesDao productPicturesDao) {
        this.productPicturesDao = productPicturesDao;
    }
     
     
      public boolean addPhoto(ProductPicture productPicture) {  
         return productPicturesDao.addPhoto(productPicture);
        }
       
     public List<ProductPicture> getProductPhotos(String productID){
         return productPicturesDao.getProductPhotos(productID);
     } 
     
        public boolean deletePhoto(String imagename, String productID){
            return productPicturesDao.deletePhoto(imagename, productID);
        }
     
         public int getPictureCount(String productID){
             return productPicturesDao.getPictureCount(productID);
         }
 
      public boolean setMasterThumbnail(String productID, String imagename){
         return productPicturesDao.setMasterThumbnail(productID, imagename);
      }
         
         
      
      
      
      
      
}
