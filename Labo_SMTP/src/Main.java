
import java.net.Socket;

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
        
        Socket socket = Utils.openConnexion("localhost", 25);
        Mail mail = new Mail("marco.monzione@heig-vd.ch","marco.mon@windowslive.com","marco","polo","sujet","contenu");
        mail.sendMail(socket);
        
    }
    
}
