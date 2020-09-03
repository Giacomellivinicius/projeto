package com.vinicius.mc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.mc.services.DBService;
import com.vinicius.mc.services.EmailService;
import com.vinicius.mc.services.MockEmailService;

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
	
	@Bean 
	public EmailService emailService() {
		return new MockEmailService();
	}
	
	
}
