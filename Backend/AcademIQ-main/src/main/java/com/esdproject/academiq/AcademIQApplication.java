package com.esdproject.academiq;


import com.amazonaws.services.appconfig.model.Application;
import com.esdproject.academiq.auth.AuthenticationService;
import com.esdproject.academiq.auth.RegisterRequest;

import com.esdproject.academiq.user.Role;
import com.esdproject.academiq.user.User;
import com.esdproject.academiq.user.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AcademIQApplication {

//	private static final Logger LOGGER = LogManager.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(AcademIQApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserRepository userRepository,

			AuthenticationService authService
	) {

		return args -> {

			try {

			


			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		};
	}
}
