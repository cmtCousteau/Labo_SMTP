/**
 * @author Monzione Marco, Anastasia Zharkova
 * 
 * File : ReadMails.java
 * 
 * Purpose : The purpose of this class is to read a list of mail provided in the file
 * "victims.txt" and return a list containing thoose mail adresses.
 * 
 * The class contain only one static method.
 * 
 */

package src;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadMails {
    
    
    public static  List<String> readMailList(){
       
            List<String> mailList = new ArrayList();
            InputStreamReader inputStreamReader;
            BufferedReader bufferedReader;
            String line;

            // Load the ressource file "victims.txt" wich contain the mails of
            // the victims.
            // I have no idea of what im doing.
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream in = classloader.getResourceAsStream("victims.txt");
            
            inputStreamReader = new InputStreamReader(in);
            bufferedReader = new BufferedReader(inputStreamReader);
        
        
        try {
            // Read line by line and put it in a list of strings.
            while ((line=bufferedReader.readLine())!=null){
                mailList.add(line);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadMails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mailList;
    }
}
