
package com.cross.dao.pojo;

import org.springframework.web.util.HtmlUtils;

/*
        @author to Ibrahim Abdsaid Hanna @2016
                   ibrahim.seniore@gmail.com
 */

public class Local {
    private String code;
    private String localName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = HtmlUtils.htmlEscape(code);
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = HtmlUtils.htmlEscape(localName);
    }

  
    
}
