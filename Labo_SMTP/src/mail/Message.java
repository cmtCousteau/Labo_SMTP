/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
