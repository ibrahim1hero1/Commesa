
package com.cross.dao.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.util.HtmlUtils;


/**
     @author to Ibrahim Abdsaid Hanna @2016
                ibrahim.seniore@gmail.com
 */

@Entity
@Table(name="corporation")
public class Corporation implements Serializable{
     
    @Id
    @GeneratedValue
    @Column(name = "Corporation_ID")          
    private String id;
    
    @NotBlank
    @Size(max=255)
    @Column(name = "Corporation_Name") 
    private String name;
    
    @Pattern(regexp="^((?!country).)*$")
    @Transient
    private String countryCode; 
    
    @Transient
    private String corporationTypeCode;
      
    @OneToOne
    @JoinColumn(name = "Country_ID")
    private Country country;
   
    @OneToOne
    @JoinColumn(name = "Corporation_Type_ID")
    private CorporationType corporationType;
    
    @OneToOne
    @JoinColumn(name = "Industry_Type_ID")
    private IndustryType industryType;
    
    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    @Column(name = "Email") 
    private String email;
     
    @Size(min=5, max=255) 
    @Column(name = "Password") 
    private String password;
    
    @Pattern(regexp="^((?!day).)*$", message = "!?") 
    @Transient
    private String day;
    
    @Pattern(regexp="^((?!month).)*$" , message = "!?") 
    @Transient
    private String month;
     
    @Pattern(regexp="^((?!year).)*$", message = "!?") 
    @Transient
    private String year;
     
    @Column(name = "Established_Date") 
    private String establishedDate;
     
    @Column(name = "Web_Address") 
    private String webAddress;
    
    @Column(name = "Government_Legal") 
    private boolean governmentLegal;
    
    @Column(name = "Iso_Legal")
    private boolean isoLegal;
    
    @Column(name = "Description")
    private String descrbtion; 
      
    @Column(name = "Date_Created")
    private Date registrationDate;
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = HtmlUtils.htmlEscape(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = HtmlUtils.htmlEscape(name);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = HtmlUtils.htmlEscape(countryCode);
    }

    public String getCorporationTypeCode() {
        return corporationTypeCode;
    }

    public void setCorporationTypeCode(String corporationTypeCode) {
        this.corporationTypeCode = HtmlUtils.htmlEscape(corporationTypeCode);
    }

    public CorporationType getCorporationType() {
        return corporationType;
    }

    public void setCorporationType(CorporationType corporationType) {
        this.corporationType = corporationType;
    }

    public IndustryType getIndustryType() {
        return industryType;
    }

    public void setIndustryType(IndustryType industryType) {
        this.industryType = industryType;
    }


   
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

      

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = HtmlUtils.htmlEscape(email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = HtmlUtils.htmlEscape(password);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = HtmlUtils.htmlEscape(day);
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = HtmlUtils.htmlEscape(month);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = HtmlUtils.htmlEscape(year);
    }


    public boolean isGovernmentLegal() {
        return governmentLegal;
    }

    public void setGovernmentLegal(boolean governmentLegal) {
        this.governmentLegal = governmentLegal;
    }

    public boolean isIsoLegal() {
        return isoLegal;
    }

    public void setIsoLegal(boolean isoLegal) {
        this.isoLegal = isoLegal;
    }

    public String getDescrbtion() {
        return descrbtion;
    }

    public void setDescrbtion(String descrbtion) {
        this.descrbtion = HtmlUtils.htmlEscape(descrbtion);
    }

    public String getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(String establishedDate) {
        this.establishedDate = HtmlUtils.htmlEscape(establishedDate);
    }

    

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getWebAddress() {
       return webAddress;
               //!=null? webAddress:"www.sitename.com";
        
    }

    public void setWebAddress(String webAddress) {
        this.webAddress =  HtmlUtils.htmlEscape(webAddress);
    }

    
}
