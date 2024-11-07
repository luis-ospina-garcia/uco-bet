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
	
    @Value("${email-from}")
    private String emailFrom;

    @Value("${email-to}")
    private String emailTo;

    public void sendEmailNotification(String cityName) {
        Email from = new Email(emailFrom);
        String subject = "Nueva Ciudad";
        Email to = new Email(emailTo);
        String mensajeFormateado = String.format("La Nueva Ciudad Ha Sido Registrada Exitosamente: <strong>%s</strong>", cityName);
        Content content = new Content("text/html", mensajeFormateado);

        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid("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");
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("Email enviado - Status Code: " + response.getStatusCode());
        } catch (IOException ex) {
            System.err.println("Error al enviar email: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
}