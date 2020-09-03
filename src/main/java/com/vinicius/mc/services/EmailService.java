package com.vinicius.mc.services;

import org.springframework.mail.SimpleMailMessage;

import com.vinicius.mc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
	
}
