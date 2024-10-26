package co.edu.uco.ucobet.generales.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.azure.security.keyvault.secrets.SecretClient;

@SpringBootApplication
@EntityScan(basePackages = {"co.edu.uco.ucobet.generales"})
@ComponentScan(basePackages = {"co.edu.uco.ucobet.generales"})
@EnableJpaRepositories(basePackages = {"co.edu.uco.ucobet.generales"})

public class UcobetGeneralesMsApplication implements CommandLineRunner{
	
	  private final SecretClient secretClient;

	    public UcobetGeneralesMsApplication(SecretClient secretClient) {
	        this.secretClient = secretClient;
	    }

	public static void main(String[] args) {
		SpringApplication.run(UcobetGeneralesMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Recupera el secreto desde Azure Key Vault y establece la URL de la base de datos
        String h2url = secretClient.getSecret("secreto-1").getValue();
        System.setProperty("secreto-1", h2url);
        System.out.println("h2url: " + h2url);
		
	}

}
