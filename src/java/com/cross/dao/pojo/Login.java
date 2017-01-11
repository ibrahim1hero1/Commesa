
package com.cross.dao.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.web.util.HtmlUtils;

/*
      @author to Ibrahim Abdsaid Hanna @2016
                 ibrahim.seniore@gmail.com
 */

@Entity
@Table(name="corporation")
public class Login implements Serializable{
   
   @Id
   @GeneratedValue
   @Column(name = "Corporation_ID")  
   private String id;
   
   @Column(name = "Corporation_Name")
   private String corporationName;
   
   @Column(name = "Email")
   private String lemail;
   
   @Column(name = "Password")
   private String lpassword;

     
   
    public String getId() {
        return id;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = HtmlUtils.htmlEscape(corporationName);
    }

    public void setId(String id) {
        this.id = HtmlUtils.htmlEscape(id);
    }  

    public String getLemail() {
        return lemail;
    }

    public void setLemail(String lemail) {
        this.lemail = HtmlUtils.htmlEscape(lemail);
    }

    public String getLpassword() {
        return lpassword;
    }

    public void setLpassword(String lpassword) {
        this.lpassword = HtmlUtils.htmlEscape(lpassword);
    }


}
