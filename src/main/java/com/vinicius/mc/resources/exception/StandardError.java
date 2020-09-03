package com.vinicius.mc.resources.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class StandardError implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timeStamp;
	
	public StandardError(Integer notFound, String msg, Long timeStamp) {
		super();
		this.setStatus(notFound);
		this.setMsg(msg);
		this.setTimeStamp(timeStamp);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
