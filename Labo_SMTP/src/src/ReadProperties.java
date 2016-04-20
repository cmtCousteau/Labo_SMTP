/**
 * @author Monzione Marco, Anastasia Zharkova
 * 
 * File : ReadProperties.java
 * 
 * Purpose : The purpose of this class is to provide an access to the config file
 * and allow the user to get the values of the properties set in the file.
 * 
 */

package src;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadProperties {
    
    private Properties properties;
    
    
    public ReadProperties(){
        openConfig();
    }
    
    private void openConfig(){
        properties = new Properties();
        
        // Open the file wich contain the properties of the programm.
        // I have no idea of what im doing.
        InputStream propertiesInputStream = getClass().getClassLoader().getResourceAsStream("conf.properties");
        
        try {
            properties.load(propertiesInputStream);
        } catch (IOException ex) {
            Logger.getLogger(ReadProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getSmtpServerAdress(){
        return properties.getProperty("smtpServerAdress");
    }
    
    public int getSmtpServerPort(){
        return Integer.parseInt(properties.getProperty("smtpServerport"));
    }
    
    public int getNumberOfGroups(){
        return Integer.parseInt(properties.getProperty("numberOfgroups"));
    }
    
}
