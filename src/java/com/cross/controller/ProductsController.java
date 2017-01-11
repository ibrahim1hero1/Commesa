
package com.cross.controller;

import com.cross.dao.pojo.Corporation;
import com.cross.dao.pojo.Local;
import com.cross.dao.pojo.Login;
import com.cross.dao.pojo.Product;
import com.cross.dao.pojo.ProductPicture;
import com.cross.dao.pojo.UploadImage;
import com.cross.dao.pojo.customvalidators.ImageValidator;
import com.cross.services.CalendarService;
import com.cross.services.ComponentService;
import com.cross.services.CorporationService;
import com.cross.services.ProductPictureService;
import com.cross.services.ProductService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


   /*
       @author to Ibrahim Abdsaid Hanna 
                  ibrahim.seniore@gmail.com
    */


@Controller
public class ProductsController {
    
    CorporationService corporationService;
    ComponentService componentService;
    CalendarService calendarService;
    ProductService productService;
    ProductPictureService productPictureService;
    ImageValidator validator; 
    HttpSession session;
    
   // ProductCustomValidator customerValidator;

     @Autowired 
    public void setValidator(ImageValidator validator) {
        this.validator = validator;
    }
    
    
     @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }
     
    @Autowired
    public void setCalendarService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }
    
    @Autowired
    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }
    @Autowired
    public void setCorporationService(CorporationService corporationService) {
        this.corporationService = corporationService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
   
     @Autowired
    public void setProductPictureService(ProductPictureService productPictureService) {
        this.productPictureService = productPictureService;
    }

    
    
    
  /*  @Autowired
    public void setCustomerValidator(ProductCustomValidator customerValidator) {
        this.customerValidator = customerValidator;
    }
   */ 
    
    
    
    @RequestMapping("my/products")
    public String myProductsPage(Model model){
        Object userID=session.getAttribute("userID");
         if(userID!=null){
             
        model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
        model.addAttribute("myProductsList", productService.getMyProducts(userID.toString()));
        return "myproducts";
         }
         else{
      
          return "redirect:/welcome";
         } 
      
    }
    
    
     @RequestMapping("product/create")
    public String createProductPage(Model model, Local local,Product product,Corporation corporation,Login login){
        Object userID=session.getAttribute("userID");
         if(userID!=null){
             
        model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
        model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
        model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
        model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
        model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
        return "createproduct";
         }
         else{
      
          return "redirect:/welcome";
         } 
      
    }
    
    
    
    @RequestMapping(value="product/register", method = RequestMethod.POST)
    public String doregisterProduct(Model model,@Valid Product product,BindingResult result,UploadImage uploadImage){
         Object userID=session.getAttribute("userID"); 
         
          if(userID!=null){
             
          
         if (result.hasErrors()) {
            
        model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
        model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
        model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
        model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
        model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
            return "createproduct";
        }
         else if (productService.existsProductName(product.getProductName(), userID.toString())) {
           result.rejectValue("productName", "DuplicateKey.product.productName");  
           model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
           model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
           model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
           model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
           model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
            return "createproduct";
        }
          else if (productService.existsProductSerial(product.getSerialNumber(), userID.toString())) {
              result.rejectValue("serialNumber", "DuplicateKey.product.serialNumber"); 
              model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
              model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
              model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
              model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
              model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
              return "createproduct";
        }
        else{
            model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
            model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
            model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
            model.addAttribute("sizeTypesList", componentService.getSizeTypes());
            model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
            model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
            productService.registerNewProduct(product, userID.toString());
            model.addAttribute("pr", productService.getProduct(product.getProductID()));
            model.addAttribute("productPicturesList", productPictureService.getProductPhotos(product.getProductID()));
 
          }
          }
          else{
       
          return "redirect:/welcome";
          }
         
          return "editproduct";
      
        
    }
    
    
      @RequestMapping(value="product/edit/{id}", method = RequestMethod.GET)
    public String doEditProduct(Model model,Product product,@PathVariable String id,UploadImage uploadImage){

         Object userID=session.getAttribute("userID"); 
         

         
         if(userID!=null){ 
             
             if(!productService.isOwner(userID.toString(), id)){
                  model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
                  return "unauthorized-editproduct";
             }
             
            model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
            model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
            model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
            model.addAttribute("sizeTypesList", componentService.getSizeTypes());
            model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
            model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
                
            model.addAttribute("pr", productService.getProduct(id));
            model.addAttribute("productPicturesList", productPictureService.getProductPhotos(id));
           
          }
           else{
       
          return "redirect:/welcome";
         } 
           
        
          return "editproduct";
    }
    
    
    
    
    
     @RequestMapping(value="product/edit/info", method = RequestMethod.POST)
    public String doEditProductInfo(Model model,@Valid Product product, BindingResult result,UploadImage uploadImage){

         
         Object userID=session.getAttribute("userID"); 
       
          
          if(userID!=null){
    
              if(!productService.isOwner(userID.toString(), product.getProductID())){
                  model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
                  return "unauthorized-editproduct";
             }  
              
              
     if (result.hasErrors()) {
            
        model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
        model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
        model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
        model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
        model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
        model.addAttribute("sizeTypesList", componentService.getSizeTypes()); 
        model.addAttribute("pr",productService.getProduct(product.getProductID()));
         model.addAttribute("productPicturesList", productPictureService.getProductPhotos(product.getProductID()));
            
       
        return "editproduct";
        }
    else if (!product.getProductName().equals(productService.getProductName(product.getProductID()+""))&&productService.existsProductName(product.getProductName(), userID.toString())) {
        model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
        model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
        model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
        model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
        model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
        model.addAttribute("sizeTypesList", componentService.getSizeTypes()); 
        model.addAttribute("pr", productService.getProduct(product.getProductID()));
        model.addAttribute("productPicturesList", productPictureService.getProductPhotos(product.getProductID()));
            
        return "editproduct";
             }
       
      else if (!product.getSerialNumber().equals(productService.getProductSerialNumber(product.getProductID()))&&productService.existsProductSerial(product.getSerialNumber(), userID.toString())) {
        model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
        model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
        model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
        model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
        model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
        model.addAttribute("sizeTypesList", componentService.getSizeTypes()); 
        model.addAttribute("pr", productService.getProduct(product.getProductID()));
        model.addAttribute("productPicturesList", productPictureService.getProductPhotos(product.getProductID()));
            
       
        return "editproduct";
             }

           else{ 
            model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
            model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
            model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
            model.addAttribute("sizeTypesList", componentService.getSizeTypes());
            model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
            model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
         
           
            product.setFactoryID(userID.toString());
            productService.updateProduct(product);
            
            model.addAttribute("pr", productService.getProduct(product.getProductID()));
            model.addAttribute("productPicturesList", productPictureService.getProductPhotos(product.getProductID()));
            
           }
          }
     else{
       
          return "redirect:/welcome";
          }
      
            return "editproduct";
    }
    
    
     

    @RequestMapping(value="/product/upload",method=RequestMethod.POST)  
    public String upload(Model model,@Valid UploadImage uploadImage,@RequestParam String pid,BindingResult result,Product product) throws Exception{  
        
        Object userID=session.getAttribute("userID"); 
      
         
    if(userID!=null){
      
          if(!productService.isOwner(userID.toString(), pid)){
                  model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
                  return "unauthorized-editproduct";
             }  
              
        
        if(productPictureService.getPictureCount(pid)>=5){
            result.rejectValue("file", "Exceed.product.photo");
            model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
            model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
            model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
            model.addAttribute("sizeTypesList", componentService.getSizeTypes());
            model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
            model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
            model.addAttribute("pr", productService.getProduct(pid));
            model.addAttribute("productPicturesList", productPictureService.getProductPhotos(pid));
            
       return "editproduct";  
        }
        
        
       validator.validate(uploadImage, result);
       
        if (result.hasErrors()) {
            
            model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
            model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
            model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
            model.addAttribute("sizeTypesList", componentService.getSizeTypes());
            model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
            model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
            model.addAttribute("pr", productService.getProduct(pid));
            model.addAttribute("productPicturesList", productPictureService.getProductPhotos(pid));
            
       return "editproduct";  
       }
        
        
        String path=session.getServletContext().getRealPath("/resources/products");  
        String filename=uploadImage.getFile().getOriginalFilename();
        
        String baseFilename= filename.replace(".", "A");
        
         DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
       
            ProductPicture productPicture=new ProductPicture();
            productPicture.setProduct(productService.getProduct(pid));
            productPicture.setImageName(pid+dateFormat.format(date)+baseFilename);
            
         
        try{  
        byte barr[]=uploadImage.getFile().getBytes();  
          
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(path+"/"+pid+dateFormat.format(date)+baseFilename+".jpg"));  
        bout.write(barr);  
        bout.flush();  
        bout.close();  
          
        
           
       
        productPictureService.addPhoto(productPicture);
        
        
        }catch(Exception e){
        } 
        
        
            model.addAttribute("coname", corporationService.getCorporationName(userID.toString()));
            model.addAttribute("weightTypes", componentService.getWeightMapList(componentService.getWeightTypes()));
            model.addAttribute("sizeTypes", componentService.getSizeMapList(componentService.getSizeTypes()));
            model.addAttribute("sizeTypesList", componentService.getSizeTypes());
            model.addAttribute("priceTypes", componentService.getPriceMapList(componentService.getPriceTypes()));
            model.addAttribute("containerTypes", componentService.getContainerMapList(componentService.getContainerTypes()));
            model.addAttribute("pr", productService.getProduct(pid));
            model.addAttribute("productPicturesList", productPictureService.getProductPhotos(pid));
            
    }
    else{
       
        return "redirect:/welcome";
          
    }
       return "editproduct";  
   } 

    
    @RequestMapping(value="/product/delete/photo/{pid}/{pname}",method=RequestMethod.GET) 
    @ResponseBody
    public String deletePhoto(@PathVariable String pid,@PathVariable String pname) {  
        
       
        Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!productService.isOwner(userID.toString(), pid)){
            
               return "notauthorized";
             }  
              
      String path=session.getServletContext().getRealPath("/resources/products")+"/"+pname+".jpg";  
       try{
           
        File file=new File(path);
        file.delete();
        
       }
       catch(Exception ex){
           System.err.println(ex);
       }
       return ""+productPictureService.deletePhoto(pname, pid);
          }
          else{
           return "expired";  
          }
    
    }
 
    
    
    @RequestMapping(value="/product/thumbnail/photo/{pid}/{pname}",method=RequestMethod.GET) 
    @ResponseBody
    public String doSetThumbnail(@PathVariable String pid,@PathVariable String pname) {  
        
        Object userID=session.getAttribute("userID"); 
          if(userID!=null){
              
         if(!productService.isOwner(userID.toString(), pid)){
               return "notauthorized";
             }  
            return ""+productPictureService.setMasterThumbnail(pid, pname);
          }
          else{
           return "expired";  
          }
               
    }
    
    
     
    
    
  
}
