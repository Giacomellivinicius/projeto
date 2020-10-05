package com.vinicius.mc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vinicius.mc.domain.Cliente;
import com.vinicius.mc.repositories.ClienteRepository;
import com.vinicius.mc.services.exception.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Cliente não cadastrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
		
	}

	private String newPassword() {
		char[] vet = new char[5];
		for( int i=0;i<5;i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 0) {//gera um dígito
			return (char)(rand.nextInt(10)+48);
		}else if(opt == 1) {//gera uma letra maiúscula
			return(char)(rand.nextInt(26)+65);
		}else {//gera uma letra minúscula
			return(char)(rand.nextInt(26)+97);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
