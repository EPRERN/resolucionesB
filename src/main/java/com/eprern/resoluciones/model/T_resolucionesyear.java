package com.eprern.resoluciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class T_resolucionesyear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long t_resolucionesyearid;

    @Getter @Setter
    private int t_resolucionesyearnumber;
    
    public T_resolucionesyear(long t_resolucionesyearid, int t_resolucionesyearnumber) {
        this.t_resolucionesyearid = t_resolucionesyearid;
        this.t_resolucionesyearnumber = t_resolucionesyearnumber;
    }
    
    public T_resolucionesyear(){}


}
