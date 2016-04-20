/**
 * @author Monzione Marco, Anastasia Zharkova
 * 
 * File : Message.java
 * 
 * Purpose : The purpose of this class is to provide a way to create message wich
 * contain a subject and a content.
 * 
 */
package mail;

public class Message {
    
    private final String SUBJECT;
    private final String CONTENT;
    
    public Message(String subject, String content){
        this.SUBJECT = subject;
        this.CONTENT = content;
    }
    
    public String getSubject(){
        return SUBJECT;
    }
    public String getContent(){
        return CONTENT;
    }
}
