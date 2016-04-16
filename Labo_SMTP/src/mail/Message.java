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

/**
 *
 * @author marco
 */
public class Message {
    
    private String subject;
    private String content;
    
    public Message(String subject, String content){
        this.subject = subject;
        this.content = content;
    }
    
    public String getSubject(){
        return subject;
    }
    public String getContent(){
        return content;
    }
}
