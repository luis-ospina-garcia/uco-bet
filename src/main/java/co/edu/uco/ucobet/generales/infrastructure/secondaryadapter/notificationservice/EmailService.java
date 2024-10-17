package co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.notificationservice;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class EmailService {

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    public String sendEmail(String to, String subject, String content) {
        Email from = new Email("tu-email@ejemplo.com");
        Email recipient = new Email(to);
        Content emailContent = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, recipient, emailContent);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            return "Estado: " + response.getStatusCode();
        } catch (IOException ex) {
            return "Error al enviar correo: " + ex.getMessage();
        }
    }
}