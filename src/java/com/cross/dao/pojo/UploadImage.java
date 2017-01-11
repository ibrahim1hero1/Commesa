
package com.cross.dao.pojo;

import org.springframework.web.multipart.MultipartFile;

  /*
      @author Ibrahim Abdsaid Hanna @2016 
              ibrahim.seniore@gmail.com
 */
public class UploadImage {
    
   private MultipartFile  file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

 
}
