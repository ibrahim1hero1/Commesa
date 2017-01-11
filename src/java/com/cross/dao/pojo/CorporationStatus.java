
package com.cross.dao.pojo;

import org.springframework.web.util.HtmlUtils;

/*
     @author to Ibrahim Abdsaid Hanna @2016
                ibrahim.seniore@gmail.com
 */
public class CorporationStatus {
    
    private int statusID;
    private String statusName;

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = HtmlUtils.htmlEscape(statusName);
    }
  
}
