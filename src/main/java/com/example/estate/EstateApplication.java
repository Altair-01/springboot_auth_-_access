package com.example.estate;

import com.example.estate.model.Role;
import com.example.estate.model.User;
import com.example.estate.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class EstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstateApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner commandLineRunner (UserService userService) {
		return args -> {

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Oumar Sonko", "Altair", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Alioune Sall", "linzo",  "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Moussa Coulibaly",  "elMoussa", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Alexandre Ndene", "Lex",  "1234", new ArrayList<>()));

			userService.addRoleToUser("Altair", "ROLE_USER");
			userService.addRoleToUser("Altair", "ROLE_MANAGER");
			userService.addRoleToUser("linzo", "ROLE_USER");
			userService.addRoleToUser("linzo", "ROLE_ADMIN");
			userService.addRoleToUser("linzo", "ROLE_SUPER_ADMIN");

		};
	}

}
