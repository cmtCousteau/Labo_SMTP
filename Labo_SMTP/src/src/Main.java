/**
 * @author Monzione Marco, Anastasia Zharkova
 * 
 * File : Main.java
 * 
 * Purpose : The purpose of this class is to use all other classes and
 * make prank mails messages and send them to a list of victims.
 * 
 */

package src;

import mail.ReadMails;
import mail.ReadMessages;
import mail.Mail;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import mail.Group;
import mail.Message;

public class Main {
    
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {
        
        List<String> mailList;
        List<Group> groupList;
        List<Message> messageList;

        int numberOfGroups;
        int groupSize;
        int messageIndex;
        Group group;
        SmtpServer smtp;

        ReadProperties properties = new ReadProperties();
        mailList = ReadMails.readMailList();

        numberOfGroups = properties.getNumberOfGroups();
        groupSize = mailList.size() / numberOfGroups;
        
        groupList = new ArrayList();
        // Test if the number of group is OK with the number of mail adresses.
        if(groupSize >= 3){
            for(int i = 0; i < numberOfGroups; i++){
                // If we are at the end we put all the remaining mail in the last group.
                if(i == numberOfGroups-1){
                    group = new Group(mailList.subList(groupSize*i, mailList.size()));
                }
                else{
                    group = new Group(mailList.subList(groupSize*i, groupSize*(i+1)));
                }
                groupList.add(group);
            }
        }
        else
        {
            LOG.info("Group size is too big !!!");
            return;
        }
        
        // Get the list of prank message from the file.
        messageList = ReadMessages.readMessage();

        smtp = new SmtpServer(properties.getSmtpServerAdress(),properties.getSmtpServerPort());
        smtp.openConnexion();
           
        // Parse all the groups in the list, create a message from a random prank,
        // and create the mail, and finaly send the mail.
        for(Group g : groupList){
            // Get a random index number to select the message to send.
            messageIndex = Utils.getRandomNumber(messageList.size());
            // Create a new mail.
            Mail mail = new Mail(g, messageList.get(messageIndex));
            // Send the mail.
            smtp.sendMail(mail);
        }
        
        smtp.closeConnexion();
    }
}
