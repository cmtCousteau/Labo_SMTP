package src;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
public class ReadFiles {
    
    
    public static  List<String> readMailList(String file){
        
        
        List<String> mailList = new ArrayList<String>();
        InputStream ips=null;
        InputStreamReader ipsr;
        BufferedReader br;
        String line;
        
        try {
            ips = new FileInputStream(file);
            ipsr=new InputStreamReader(ips);
            br=new BufferedReader(ipsr);
            
            while ((line=br.readLine())!=null){
                mailList.add(line);
            }
            br.close(); 
    
        } catch (Exception  ex) {
            Logger.getLogger(ReadFiles.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ips.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return mailList;
    }
    
    
}
