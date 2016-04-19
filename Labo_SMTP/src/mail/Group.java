/**
 * @author Monzione Marco, Anastasia Zharkova
 * 
 * File : Group.java
 * 
 * Purpose : The purpose of this class is to create a object Group containing a
 * list of victim mail adresses and a sender mail adress.
 * The sender is randomly choosen in the constructor from the list of mails
 * received in parameter.
 * 
 */
package mail;

import java.util.ArrayList;
import java.util.List;
import src.Utils;

public class Group {
    
    private final String sender;
    private final List<String> victimList;

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
