
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

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
        List<String> mailFromList;
        List<String> mailToList;
        String serverAdress;
        int serverPort;
        
        ReadProperties properties = new ReadProperties("config.properties");
        
        
        
        
      //  mailFromList = ReadFiles.readMailList("E:/Ecole/RES/mailFrom.txt");
      //  mailToList = ReadFiles.readMailList("E:/Ecole/RES/mailTo.txt");
        
        
        
        
     //   serverAdress = properties.getProperty("smtpServerAdress");
     //   serverPort = Integer.parseInt(properties.getProperty("smtpServerport"));
        
        Socket socket = Utils.openConnexion(properties.getSmtpServerAdress(), properties.getSmtpServerPort());
        
        Mail mail = new Mail("marco.monzione@heig-vd.ch","marco.mon@windowslive.com","marco","polo","sujet","contenu");
        mail.sendMail(socket);
        
        
    }
    
}
