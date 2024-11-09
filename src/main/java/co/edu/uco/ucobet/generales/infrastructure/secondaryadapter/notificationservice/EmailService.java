package co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.notificationservice;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogImpl;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.secretservice.SecretService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private final MessageCatalogImpl messageCatalogService;
    private final SecretService secretService;
    

    @Value("${email-from}")
    private String emailFrom;

    @Value("${SG-Api}")
    private String sgApi;
    
    

    public EmailService(MessageCatalogImpl messageCatalogService, SecretService secretService ) {
        this.messageCatalogService = messageCatalogService;
        this.secretService =secretService;
    }

    public void sendEmailNotification(String cityName) {
        Email from = new Email(emailFrom);
        var parametro1 = messageCatalogService.getMessage("0019");
        String subject = parametro1;
        String emailTo = secretService.getSecretValue("to-email");
        Email to = new Email(emailTo);
        var parametro2 = messageCatalogService.getMessage("0018");;
        String mensajeFormateado = String.format(parametro2, cityName);
        Content content = new Content("text/html", mensajeFormateado);
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(sgApi);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            var parametro3 = messageCatalogService.getMessage("0020");
            logger.info("{}{}", parametro3, response.getStatusCode());
        } catch (IOException ex) {
            var parametro4 = messageCatalogService.getMessage("0021");
            logger.error("{}{}", parametro4, ex.getMessage(), ex);
        }
    }
}
