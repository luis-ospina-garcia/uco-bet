package co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.notification.config;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendGridConfig {

	@Value("${sengrid-api-key}")
	private String sendGridApiKey;

	@Bean
	public SendGrid sendGrid() {
		return new SendGrid(sendGridApiKey);
	}
}