package com.eprern.resoluciones.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginResponse {
    
    private boolean success;
    private String rol;
    
    public LoginResponse(boolean success, String rol) {
        this.success = success;
        this.rol = rol;
    }
    
    
}