
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class ReadProperties {
    
    private Properties properties;
    
    
    public ReadProperties(String propertiesFileName){
        openConfig(propertiesFileName);
    }
    
    private void openConfig(String propertiesFileName){
        properties = new Properties();
        InputStream inputStream;
        
        try {
            inputStream = new FileInputStream(propertiesFileName);
            properties.load(inputStream);
            
        } catch (IOException  ex) {
            Logger.getLogger(ReadProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        properties.getProperty("smtpServerAdress");
    }
    
    public String getSmtpServerAdress(){
        return properties.getProperty("smtpServerAdress");
    }
    
    public int getSmtpServerPort(){
        return Integer.parseInt(properties.getProperty("smtpServerport"));
    }
    
}
