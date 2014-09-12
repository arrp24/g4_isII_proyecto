package com.ls.gestion.web.backing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


  
@ManagedBean(name = "descargasBacking")
@ViewScoped
public class DescargasBacking {  
  
    private StreamedContent file;  
      
    public DescargasBacking() throws FileNotFoundException {          
    	
    	try{
    		
        	InputStream ist = new FileInputStream("http://localhost:8181/ls-gestion-web/docs/CUENCA.pdf");        	
        	file = new DefaultStreamedContent(ist, "application/pdf", "archivo.pdf"); 
			
        	

        }catch (Exception e){
        	System.out.println(e);
        }
        
    }  
  
    public StreamedContent getFile() {  
        return file;  
    }    
}  