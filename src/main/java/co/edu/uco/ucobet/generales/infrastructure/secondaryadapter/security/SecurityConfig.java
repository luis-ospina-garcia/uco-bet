package co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@SuppressWarnings({ "deprecation", "removal" })
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests(requests -> requests
				.anyRequest().authenticated()).oauth2ResourceServer(server -> server.jwt());
		return http.build();
	}
}