package com.security.security_configurations;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class SecurityConfigurationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityConfigurationsApplication.class, args);
	}

}
