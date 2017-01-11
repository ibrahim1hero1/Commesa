
package com.cross.dao.pojo;

import javax.validation.constraints.Pattern;
import org.springframework.web.util.HtmlUtils;

/*
  @author to Ibrahim Abdsaid Hanna @2016
             ibrahim.seniore@gmail.com
 */
public class Search {
    
    @Pattern(regexp="^((?!country).)*$") 
    private String countryCode; 
    
    private String industryType;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = HtmlUtils.htmlEscape(countryCode);
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

}
