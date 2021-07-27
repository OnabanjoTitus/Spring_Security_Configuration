package com.security.security_configurations;

import com.security.security_configurations.model.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityConfigurationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityConfigurationsApplication.class, args);
	}

}
