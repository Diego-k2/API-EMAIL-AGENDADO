package com.example.agendador_email.email;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;

public class EnvioEmail {

    public static boolean enviarEmail(String recebedor, String assunto, String mensagem){

        Email email = new Email();

        final String EMAIL_DE = "degosantosiva@gmail.com";

        email.setFrom("Root", EMAIL_DE);
        email.addRecipient("User", recebedor);
        email.setSubject(assunto);
        email.setPlain(mensagem);

        MailerSend mailerSend = new MailerSend();
        mailerSend.setToken("mlsn.a3d03f20550de79b2741aa2b7540e106d63225e57d531304b6a8ffaf582289b9");

        try{
            MailerSendResponse mailerSendResponse = mailerSend.emails().send(email);

            if(!mailerSendResponse.messageId.isBlank()) {
                return true;
            }else {
                return false;
            }
        } catch(MailerSendException e){

            System.out.println(e);
            return false;
        }
    }
}
