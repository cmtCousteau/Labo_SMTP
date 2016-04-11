
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Mail(String MAIL_FROM, String RCPT_TO, String FROM, String TO, String SUBJECT, String CONTENT) {
        this.MAIL_FROM = "MAIL FROM: " + MAIL_FROM;
        this.RCPT_TO   = "RCPT TO: " + RCPT_TO;
        this.FROM      = "From: " + FROM;
        this.TO        = "To: " + TO;
        this.SUBJECT   = "Subject: " + SUBJECT + "\n\n";
        this.CONTENT   = CONTENT + "\n.\n";
    }

    public String get_MAIL_FROM() {
        return this.MAIL_FROM;
    }

    public String get_RCPT_TO() {
        return this.RCPT_TO;
    }

    public String get_FROM() {
        return this.FROM;
    }

    public String get_TO() {
        return this.TO;
    }

    public String get_SUBJECT() {
        return this.SUBJECT;
    }

    public String get_CONTENT() {
        return this.CONTENT;
    }

    public void sendMail(Socket socket) {

        String strTmp = "";
        PrintWriter out   = null;
        BufferedReader in = null;

        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
    
            System.out.println(Utils.readMessage(in));
            Utils.sendMessage(out, "EHLO Marco");
            while (true) {

                strTmp = Utils.readMessage(in);
                System.out.println(strTmp);

                if (strTmp.contains("250 ")) {
                    break;
                }
            }
            

            Utils.sendMessage(out, this.MAIL_FROM);
            System.out.println(Utils.readMessage(in));
            Utils.sendMessage(out, this.RCPT_TO);
            System.out.println(Utils.readMessage(in));
            Utils.sendMessage(out, "DATA");
            System.out.println(Utils.readMessage(in));
            Utils.sendMessage(out, this.FROM);
            Utils.sendMessage(out, this.TO);
            //out.println("Cc: marco.monzione@heid-vd.ch");
            Utils.sendMessage(out, this.SUBJECT + this.CONTENT);
            System.out.println(Utils.readMessage(in));
            Utils.sendMessage(out, "quit");
    }

}
