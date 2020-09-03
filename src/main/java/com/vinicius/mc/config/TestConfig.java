package com.vinicius.mc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.mc.services.DBService;
<<<<<<< HEAD
import com.vinicius.mc.services.EmailService;
import com.vinicius.mc.services.MockEmailService;
=======
>>>>>>> 4e104d9691e03ebae799a5570871c14b91288ea1

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

	//O método deve ter um retorno diferente de void
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
<<<<<<< HEAD
	@Bean 
	public EmailService emailService() {
		return new MockEmailService();
	}
=======
	
>>>>>>> 4e104d9691e03ebae799a5570871c14b91288ea1
	
	
}
