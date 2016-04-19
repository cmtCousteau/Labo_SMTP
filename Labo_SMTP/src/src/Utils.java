/**
 * @author Monzione Marco, Anastasia Zharkova
 * 
 * File : Utils.java
 * 
 * Purpose : The purpose of this class is to provide some utilies functions, like
 * generating a random number beetween a range or sending/reading a message to/from
 * a socket and opening/closing a TCP connexion.
 * 
 */

package src;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  Utils {
    
    public static String readMessage(BufferedReader in){
        String strToReturn = "";
        try {
            strToReturn = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return strToReturn;
    }
    
    public static void sendMessage(PrintWriter out, String message){
        out.write(message);
        out.flush();
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

    
    public static Socket openConnexion(String host, int port){
        
        Socket clientSocket = null;

        try {
            clientSocket = new Socket(host, port);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientSocket;
    }
    
    public static int getRandomNumber(int maxValue){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(maxValue);
    }
    
}
