
package com.cross.dao.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.web.util.HtmlUtils;

   /*
   @author to Ibrahim Abdsaid Hanna
              ibrahim.seniore@gmail.com
    */
    
@Entity
@Table(name="address")
public class Address implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "Address_ID")   
    private String addressID;
    
    @ManyToOne
    @JoinColumn(name = "Corporation_ID")   
    private Corporation corporation;
    
    @Column(name = "Address_Title")   
    private String addressTitle;

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = HtmlUtils.htmlEscape(addressID);
    }

    public Corporation getCorporation() {
        return corporation;
    }

    public void setCorporation(Corporation corporation) {
        this.corporation = corporation;
    }

    public String getAddressTitle() {
        return addressTitle;
    }

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = HtmlUtils.htmlEscape(addressTitle);
    }

 
}
