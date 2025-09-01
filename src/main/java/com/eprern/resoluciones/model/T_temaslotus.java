package com.eprern.resoluciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class T_temaslotus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int t_temaslotusid;

    
    @Getter @Setter
    private String t_temaslotusdescripcion;
    
    public T_temaslotus(int t_temaslotusid, String t_temaslotusdescripcion) {
        this.t_temaslotusid = t_temaslotusid;
        this.t_temaslotusdescripcion = t_temaslotusdescripcion;
    }
    
    public T_temaslotus(){}


}
