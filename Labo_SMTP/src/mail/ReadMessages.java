/**
 * @author Monzione Marco, Anastasia Zharkova
 * 
 * File : ReadMessages.java
 * 
 * Purpose : The purpose of this class is to read a list of prank message contained 
 * in the file "messages.txt" and to return a list of "Message". The messages
 * in the file "messages.txt" are separated by ":::".
 * 
 * The class contain only one static method.
 * 
 */
package mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadMessages {
    
    public static List<Message>  readMessage(){
        
        
        List<Message> messageList = new ArrayList();
        String line;
        InputStreamReader ipsr;
        BufferedReader br;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream in = classloader.getResourceAsStream("messages.txt");

        ipsr = new InputStreamReader(in);
        br = new BufferedReader(ipsr);
        String subject = "";
        String content = "";
        boolean firstLine = true;
        
        try {
            // Read the file line by line.
            while ((line=br.readLine())!=null){
                // If it's the first line, it's the subject of the message.
                if(firstLine){
                    subject = line;
                    firstLine = false;
                // If the line contains ":::" it's the end of the current message,
                // if the next line is not empty, it will contain the next message,
                // so we reset firstLine.
                }else if(line.contains(":::")){
                    // Create a new message and add it to the list.
                    messageList.add(new Message(subject, content));
                    firstLine = true;
                    content = "";
                }
                // if nothing happen before it's just the content of the message.
                else
                {
                    content += '\n' + line;
                }
            }
            br.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ReadMessages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messageList;  
    }
}
