
package com.cross.dao.pojo;

import java.util.Map;

/** 
  @author to Ibrahim Abdsaid Hanna 
             ibrahim.seniore@gmail.com
 */
public class Calendar {
    
   private Map<Integer,Integer> day;
   private  Map<Integer,Integer> month;
   private  Map<Integer,Integer> year;

    public Map<Integer, Integer> getDay() {
        return day;
    }

    public void setDay(Map<Integer, Integer> day) {
        this.day = day;
    }

    public Map<Integer, Integer> getMonth() {
        return month;
    }

    public void setMonth(Map<Integer, Integer> month) {
        this.month = month;
    }

    public Map<Integer, Integer> getYear() {
        return year;
    }

    public void setYear(Map<Integer, Integer> year) {
        this.year = year;
    }

     
     
}
