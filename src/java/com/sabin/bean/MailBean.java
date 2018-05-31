/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabin.bean;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jms.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sapu
 */
@Stateless
public class MailBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void sendEmail(String fromemail, String username, String password, String toemail, String sub, String msg) throws MessagingException {
              
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSL.SocketFactory");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        
        
        Session mailSession=Session.getDefaultInstance(properties,null);
        mailSession.setDebug(true);
        
        MimeMessage mailMessage=  new MimeMessage(mailSession);
        
        mailMessage.setFrom(new InternetAddress(fromemail));
        mailMessage.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(toemail));
        mailMessage.setText(msg);
        mailMessage.setSubject(sub);
        
        Transport transport=mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com",username,password);
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
       
        
    }
}
