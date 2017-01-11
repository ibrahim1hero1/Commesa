
package com.cross.services;

import com.cross.dao.CalendarDao;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    /*
          @author to Ibrahim Abdsaid Hanna @2016
                     ibrahim.seniore@gmail.com
    */
@Service("calendarService")
public class CalendarService {
    
    CalendarDao calendarDao;

    @Autowired
    public void setCalendarDao(CalendarDao calendarDao) {
        this.calendarDao = calendarDao;
    }
    
     public Map<Integer,Integer> getCalendarDays(){
        return calendarDao.getCalendarDays();
    }
    
    
      public Map<Integer,Integer> getCalendarMonths(){
       return calendarDao.getCalendarMonths();
    }
    
    
     public Map<Integer,Integer> getCalendarYears(){
      return calendarDao.getCalendarYears();
    }
}
