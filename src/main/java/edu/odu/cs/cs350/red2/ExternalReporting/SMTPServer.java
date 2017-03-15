package edu.odu.cs.cs350.red2.ExternalReporting;

import java.io.File;
//Need to find an SMTP Library


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
     * @param subject String The subject of the email
     * @param body String The main body of the email
     */
    public void sendEmail(String mailTo, String subject, String body) {};
}


