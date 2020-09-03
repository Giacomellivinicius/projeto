package com.vinicius.mc.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable{

	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;
	
	
	//Construtores
	
	public FieldMessage() {}
	
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	
	//Getters e Setters
	
	public String getFieldName() {
		return this.fieldName;
	}
	
	public void setName(String name) {
		this.fieldName = name;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
