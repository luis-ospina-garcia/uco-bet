package co.edu.uco.ucobet.generales.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.azure.security.keyvault.secrets.SecretClient;

@ComponentScan(basePackages = {"co.edu.uco.ucobet.generales.infrastructure.primaryadapter.controller;" })

@SpringBootApplication
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
