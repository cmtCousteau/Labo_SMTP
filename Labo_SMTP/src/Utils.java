
import java.io.IOException;
import java.net.Socket;
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
public class  Utils {
    
    
    public static void sendMail(Mail mail){
    
        
    }  
    
    public static void closeConnexion(Socket socket){
        if(socket != null){
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static Socket connexion(String host, int port){
        
        Socket clientSocket = null;

        try {
            clientSocket = new Socket(host, port);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientSocket;
    }
    
}
