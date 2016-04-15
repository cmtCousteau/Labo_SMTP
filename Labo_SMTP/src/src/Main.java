package src;


import mail.Mail;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;
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
public class Main {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //String separator = File.separator;
        List<String> mailList;
        List<String> mailToList;
        String mailListPath;
        String serverAdress;
        int serverPort;
        
	InputStream input = null;

        ReadProperties properties = new ReadProperties("config.properties");
        mailListPath = properties.getMailListFilePath();
        
        mailList = ReadFiles.readMailList("E:/Ecole/RES/Labo_SMTP/mailList.txt");
        
        
        
        
        serverAdress = properties.getSmtpServerAdress();
        serverPort = properties.getSmtpServerPort();
        
       // Socket socket = Utils.openConnexion("smtp.heig-vd.ch", 25);
        Socket socket = Utils.openConnexion(serverAdress, serverPort);
        Mail mail = new Mail("anastasia.zharkova@heig-vd.ch","anastasia.zharkova@heig-vd.ch","Anastasia Zharkova","Anastasia Zharkova","pizza","Je mange de la pizza");
        mail.sendMail(socket);
        
        
    }
    
}
