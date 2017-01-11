
package com.cross.dao.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/*
       @author to Ibrahim Abdsaid Hanna @2016
                  ibrahim.seniore@gmail.com
 */
@Entity
@Table(name="products")
public class MyProduct implements Serializable{
    
    
    @Id
    @GeneratedValue
    @Column(name = "Product_ID")   
    private String productID;
    
    @Column(name = "Product_Name")   
    private String productName;
    
    @Column(name = "Factory_ID") 
    private String factoryID;
    
    @Column(name = "Description") 
    private String description;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(String factoryID) {
        this.factoryID = factoryID;
    }

    
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    
}
