
package com.cross.dao.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.util.HtmlUtils;

/**
    @author to Ibrahim Abdsaid Hanna @2016
               ibrahim.seniore@gmail.com
 */
@Entity
@Table(name="products")
public class Product implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "Product_ID")   
    private String productID;
    
    @NotBlank
    @Size(max=255)
    @Column(name = "Product_Name")   
    private String productName;
    
    @NotBlank
    @Size(max=255)
    @Column(name = "Serial_Number") 
    private String serialNumber;
    
    @Column(name = "Factory_ID") 
    private String factoryID;
    
    @NotBlank
    @Pattern(regexp = "^$|[0-9]{1,13}(\\\\.[0-9]*)?")
    @Column(name = "Weight") 
    private String weight;
    
    @OneToOne
    @JoinColumn(name = "Weight_Type_ID")
    private WeightType weightType; 
    
    @OneToOne
    @JoinColumn(name = "Size_Type_ID")
    private SizeType sizeType; 
    
    @NotBlank
    @Pattern(regexp = "^$|[0-9]{1,13}(\\\\.[0-9]*)?")
    @Column(name = "Size_Width") 
    private String sizeWidth;
    
    @NotBlank
    @Pattern(regexp = "^$|[0-9]{1,13}(\\\\.[0-9]*)?")
    @Column(name = "Size_Height") 
    private String sizeHeight;
    
    @Column(name = "Available") 
    private boolean available;
    
    @NotBlank
    @Pattern(regexp = "^$|[0-9]{1,13}(\\\\.[0-9]*)?")
    @Column(name = "Price") 
    private String price;
    
    @OneToOne
    @JoinColumn(name = "Price_Type_ID")
    private PriceType priceType;
    
    @OneToOne
    @JoinColumn(name = "Container_Type_ID")
    private ContainerType containerType;
     
    @NotBlank
    @Pattern(regexp ="^$|((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])")
    @Column(name = "Production_Date") 
    private String productionDate;
    
    @Size(min = 50)
    @Column(name = "Description") 
    private String description;

    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = HtmlUtils.htmlEscape(productID);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = HtmlUtils.htmlEscape(productName);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = HtmlUtils.htmlEscape(serialNumber);
    }

    public String getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(String factoryID) {
        this.factoryID = HtmlUtils.htmlEscape(factoryID);
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = HtmlUtils.htmlEscape(weight);
    }

    public WeightType getWeightType() {
        return weightType;
    }

    public void setWeightType(WeightType weightType) {
        this.weightType = weightType;
    }

    public SizeType getSizeType() {
        return sizeType;
    }

    public void setSizeType(SizeType sizeType) {
        this.sizeType = sizeType;
    }

    public String getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(String sizeWidth) {
        this.sizeWidth = HtmlUtils.htmlEscape(sizeWidth);
    }

    public String getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(String sizeHeight) {
        this.sizeHeight = HtmlUtils.htmlEscape(sizeHeight);
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = HtmlUtils.htmlEscape(price);
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    public ContainerType getContainerType() {
        return containerType;
    }

    public void setContainerType(ContainerType containerType) {
        this.containerType = containerType;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = HtmlUtils.htmlEscape(productionDate);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = HtmlUtils.htmlEscape(description);
    }

   

}
