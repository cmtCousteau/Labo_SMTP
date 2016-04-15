/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.util.List;
import src.Utils;

/**
 *
 * @author marco
 */
public class Group {
    
    private String sender;
    private List<String> victim;
    
    public Group(List<String> mailList){
        this.sender = sender;
        this.victim = victim;
    }
    private String selectSender(List<String> mailList){
      
        //mailList.at(Utils.getRandomNumber(mailList.size()));
        return "";
    };
    
    public String getSender(){
        return sender;
    }
    public List<String> getVictimList(){
        return victim;
    }
    
}
