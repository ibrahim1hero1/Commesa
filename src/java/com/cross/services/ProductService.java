
package com.cross.services;

import com.cross.dao.ProductDao;
import com.cross.dao.pojo.MyProduct;
import com.cross.dao.pojo.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
      @author to Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
    */

 @Service("productService")
public class ProductService {
    
     ProductDao productDao;

   
   @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    
    public boolean registerNewProduct(Product product,String factoryID) {
        return productDao.registerNewProduct(product, factoryID);
    }
  
      public boolean existsProductName(String productName, String factoryID) {	
        return  productDao.existsProductName(productName, factoryID);
    }
    
     public boolean existsProductSerial(String productSerial, String factoryID) {	
           return productDao.existsProductSerial(productSerial, factoryID);
    }
     
      public Product getProduct(String productID){
            return productDao.getProduct(productID);
      }
     
      public boolean updateProduct(Product product){
           return productDao.updateProduct(product);
      }
     
       public String getProductName(String productID){
           return productDao.getProductName(productID);
       }
       
        public String getProductSerialNumber(String productID){
           return productDao.getProductSerialNumber(productID);
        }
        
      public List<MyProduct> getMyProducts(String factoryID){	
          return productDao.getMyProducts(factoryID);
      }   
      
      
       public boolean isOwner(String userID,String productID){
           return productDao.isOwner(userID, productID);
       }
      
      
}
