package com.eprern.resoluciones.dto;

public class LoginResponse {
	private boolean success;
	private String rol;
	
	public LoginResponse(boolean success, String rol) {
		this.success = success;
		this.rol = rol;
	}
	
	
	public boolean isSuccess() {
		return success;
	}
	
	public String getRol() {
		return rol;
	}
}
