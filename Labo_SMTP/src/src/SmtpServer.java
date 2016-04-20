/**
 * @author Monzione Marco, Anastasia Zharkova
 * 
 * File : SmtpServer.java
 * 
 * Purpose : The purpose of this class is to open/close the connexion with
 * the SMTP server, both TCP and "telnet" connexion. This class also send the mail
 * using functions in Utils.java
 * 
 */
package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mail.Mail;

public class SmtpServer {
    
    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;
    private final String hostName;
    private final int port;
    
    String NEW_LINE = System.getProperty("line.separator");
    
    public SmtpServer(String hostName, int port){
        
        this.hostName = hostName;
        this.port = port;
        out   = null;
        in = null;
    }
    
    // This method open the TCP connexion and next open the "telnet" connexion.
    // This method create too the read/write buffer.
    public void openConnexion(){

        String strTmp;
        // Open the TCP connexion.
        socket = Utils.openConnexion(hostName, port);
        
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Connect to the SMTP.
        // Wait for the "connexion" to be etablished.
        System.out.println(Utils.readMessage(in));
        Utils.sendMessage(out, "EHLO Marco" + NEW_LINE);
        
        // Wait until all the "welcom" message are received and the server
        // send "250" followed by an empty space.
        while (true) {
            strTmp = Utils.readMessage(in);
            System.out.println(strTmp);

            if (strTmp.contains("250 ")) {
                break;
            }
        }
    }
    // Close the "telnet" connexion and the TCP connexion.
    public void closeConnexion(){
        Utils.sendMessage(out, "quit");
        //System.out.println(Utils.readMessage(in));
        Utils.closeConnexion(socket); 
    }
    
    public void sendMail(Mail mail){
        // Get the list of victims to send the mail.
        List<String> VICTIM_LIST = mail.getRcpt();
        
        Utils.sendMessage(out, "MAIL FROM: " + mail.getSender() + NEW_LINE);
        System.out.println(Utils.readMessage(in));
        
        for(String s : VICTIM_LIST){
            Utils.sendMessage(out, "RCPT TO: " + s + NEW_LINE);
            System.out.println(Utils.readMessage(in));
        }
        Utils.sendMessage(out, "DATA" + NEW_LINE);
        System.out.println(Utils.readMessage(in));
        
        Utils.sendMessage(out, "From:" + mail.getSender() + NEW_LINE);
        
        for(String s : VICTIM_LIST){
            Utils.sendMessage(out, "To: " + s + NEW_LINE);
        }
        
        // Add the subject to the mail.
        Utils.sendMessage(out, mail.getSubject() + NEW_LINE + NEW_LINE) ;
        // Add the content to the mail and send it.
        Utils.sendMessage(out, mail.getContent() + NEW_LINE + "." + NEW_LINE);
        System.out.println(Utils.readMessage(in));
    }  
}
