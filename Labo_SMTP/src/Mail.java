/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class Mail {
    
   private final String MAIL_FROM;
   private final String RCPT_TO;
   private final String FROM;
   private final String TO;
   private final String SUBJECT;
   private final String CONTENT;
   
   
   public Mail(String MAIL_FROM, String RCPT_TO, String FROM, String TO, String SUBJECT, String CONTENT){
       this.MAIL_FROM = MAIL_FROM;
       this.RCPT_TO = RCPT_TO;
       this.FROM = FROM;
       this.TO = TO;
       this.SUBJECT = SUBJECT;
       this.CONTENT = CONTENT;
   }
   
   
   public String get_MAIL_FROM(){
       return this.MAIL_FROM;
   }
   
   public String get_RCPT_TO(){
       return this.RCPT_TO;
   }
   
   public String get_FROM(){
       return this.FROM;
   }
   
   public String get_TO(){
       return this.TO;
   }
   
   public String get_SUBJECT(){
       return this.SUBJECT;
   }
   
   public String get_CONTENT(){
       return this.CONTENT;
   }
   
   
   
    
}
