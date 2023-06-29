package com.example.agendador_email.email;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnvioEmail {

    public static boolean enviarEmail(String recebedor, String assunto, String mensagem) {

        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.socketFactory.fallback","false");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication("user", "pass");
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("user"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recebedor));
            message.setSubject(assunto);
            message.setText(mensagem);

            Transport.send(message);

        } catch(MessagingException e){
            System.out.println(e);
        }

        return true;
    }
}
