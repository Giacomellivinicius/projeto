package com.vinicius.mc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.vinicius.mc.security.UserSS;

public class UserService {

	//Retorna o usuário atualmente logado no sistema
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
			}catch (Exception e) {
			return null;	
			}
	}
	
	
}
