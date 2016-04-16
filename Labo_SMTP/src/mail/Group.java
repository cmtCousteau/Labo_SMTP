/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.util.ArrayList;
import java.util.List;
import src.Utils;

/**
 *
 * @author marco
 */
public class Group {
    
    private String sender;
    private List<String> victimList;

    public Group(List<String> mailList){
        // Choose randomly a sender in the list.
        int senderIndex = Utils.getRandomNumber(mailList.size());
        // Set the sender and remove it from the list.
        this.sender = mailList.get(senderIndex);
        // Parse the mails list and put all the mails thoose are not the sender
        // into the victims list.
        // I work with index to avoid problem if some mail are duplicated.
        victimList = new ArrayList();
        for(int i = 0; i < mailList.size(); i++){
            if(i != senderIndex){
                victimList.add(mailList.get(i));
            }
        }
    }
    
    public String getSender(){
        return sender;
    }
    public List<String> getVictimList(){
        return victimList;
    }
    
}
