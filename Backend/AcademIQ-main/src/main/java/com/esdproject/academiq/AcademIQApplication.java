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
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AcademIQApplication extends SpringBootServletInitializer {

	private static final Logger LOGGER = LogManager.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(AcademIQApplication.class, args);
		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
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
