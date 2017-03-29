package edu.odu.cs.cs350.red2.ExternalReporting;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;



// This will be using JavaMail 1.4.7.
// Still need to figure out whether an SMTP server is provided by ODU or do we need to use some free anon relay.


/**
 * Created by AliShaikh on 3/15/2017.
 * This class will be responsible for handling the email transmission
 */
public class SMTPServer {

    /**
     * Constructor -
     * This will load a new SMTP server
     *
     * @param userName String Username to login
     * @param password String Password to login
     */
    public SMTPServer( String userName , String password )
    {

    }

    /**
     * Use the initialized SMTP server to send a generic email
     * @param mailTo String The email the message is being sent to
     * @param subject_Fake String The subject of the email -- Disabled for now
     * @param body String The main body of the email
     */
    public void sendEmail(String mailTo, String subject_Fake, String body) {

        String host = "your smtp host";
        String to = "bbbb@ddddd.com";
        String from = "xxxx@yyy.com";
        String subject = "My First Email";
        String messageText = "I am sending a message using the"
                + " JavaMail API.\n" + "Here type your message.";
        boolean sessionDebug = false;
        Properties props = System.getProperties();
        props.put("mail.host", host);
        props.put("mail.transport.protocol", "smtp");
        Session session = Session.getDefaultInstance(props, null);
        // Set debug on the Session so we can see what is going on
        // Passing false will not echo debug info, and passing true
        // will.
        session.setDebug(sessionDebug);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = { new InternetAddress(to) };
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport.send(msg);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}


