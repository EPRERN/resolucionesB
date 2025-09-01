package com.eprern.resoluciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class T_distribuidoras {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long t_distribuidorasid;
    
    @Getter @Setter
    private String t_distribuidorasnombre;
    
    public T_distribuidoras(int t_distribuidorasid, String t_distribuidorasnombre) {
        this.t_distribuidorasid = (long) t_distribuidorasid;
        this.t_distribuidorasnombre = t_distribuidorasnombre;
    }
    
    public T_distribuidoras(){}


}
