package com.eprern.resoluciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class T_temas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long t_temasid;

    @Getter @Setter
    private String t_temasdescripcion;

    @Getter @Setter
    private int t_temaslotusid;
    
    
    
    public T_temas(Long t_temasid, String t_temasdescripcion, int t_temaslotusid) {
        this.t_temasid = t_temasid;
        this.t_temasdescripcion = t_temasdescripcion;
        this.t_temaslotusid = t_temaslotusid;
    }
    
    public T_temas(){}


}
