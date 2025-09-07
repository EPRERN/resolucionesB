package com.eprern.resoluciones.model;

import com.eprern.resoluciones.enums.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    
    @Getter @Setter
    private String username;
 
    @Getter @Setter
    private String password;
    
    
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    
    public Usuario(Long id, String username, String password, Rol rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
    
    public Usuario(){}


}
