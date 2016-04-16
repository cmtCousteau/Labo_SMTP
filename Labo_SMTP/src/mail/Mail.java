/**
 * @author Monzione Marco, Anastasia Zharkova
 * 
 * File : Mail.java
 * 
 * Purpose : The purpose of this class is to create a object mail.
 * 
 */

package mail;

import java.util.List;

public class Mail {

    private final String SUBJECT;
    private final String CONTENT;
    
    private final String SENDER;
    private final List<String> VICTIM_LIST;

    public Mail(Group group, Message message) {
        
        SENDER = group.getSender(); 
        VICTIM_LIST = group.getVictimList();
        SUBJECT = "Subject: " + message.getSubject();
        CONTENT = message.getContent();
    }
    
    public String getFrom(){
        return SENDER;
    }
    public List<String> getRcpt(){
        return VICTIM_LIST;
    }
    public String getSubject(){
        return SUBJECT;
    }
    public String getContent(){
        return CONTENT;
    }
}
