package com.vinicius.mc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message = "Email Inválido")
	private String email;
	
	public EmailDTO() {}

	//Getters e Setters
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
