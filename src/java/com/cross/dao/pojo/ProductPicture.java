
package com.cross.dao.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

/*
       @author to Ibrahim Abdsaid Hanna @2016
                  ibrahim.seniore@gmail.com
 */
@Entity
@Table(name="product_pictures")
public class ProductPicture implements Serializable{
    
    
    @Id
    @GeneratedValue
    @Column(name = "Image_ID")   
    private String imageID;
    
    @ManyToOne
    @JoinColumn(name = "Product_ID")   
    private Product product;
    
    @Column(name = "Image_Name")   
    private String imageName;

    @Column(name = "Image_Master")   
    private boolean imageMaster;

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public boolean isImageMaster() {
        return imageMaster;
    }

    public void setImageMaster(boolean imageMaster) {
        this.imageMaster = imageMaster;
    }

     
}
