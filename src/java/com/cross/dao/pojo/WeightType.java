
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
@Table(name="weight_type")
public class WeightType implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "Weight_Type_ID")
    private String id;
    
    @Column(name = "Weight_Type_Code")
    private String code;
    
    @Column(name = "Weight_Type_Name")
    private String name;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = HtmlUtils.htmlEscape(id);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = HtmlUtils.htmlEscape(code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = HtmlUtils.htmlEscape(name);
    }
    
 
}
