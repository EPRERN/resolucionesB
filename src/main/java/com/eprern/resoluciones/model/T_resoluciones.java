package com.eprern.resoluciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class T_resoluciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int t_resolucionesid;

    @Getter @Setter
    private String t_resolucionesnro;
    
    @ManyToOne
    @JoinColumn(name = "t_distribuidorasid", nullable = false)
    @Getter @Setter
    private T_distribuidoras distribuidora;
    
    
    @Getter @Setter
    private int t_temasid;
    
    @Getter @Setter
    @Lob  // Indica que es un campo grande (Large OBject)
    @Column(columnDefinition = "bytea")
    private byte[] t_resolucionesblob;
    
    @Getter @Setter
    private String t_resolucionesexpte;
    
    @Getter @Setter
    private String t_resolucionestitulo;
    
    @Getter @Setter
    private String t_resolucionesexptecaratula;
    
    @Getter @Setter
    private Date t_resolucionesdate;
    
    public T_resoluciones(int t_resolucionesid, String t_resolucionesnro, T_distribuidoras distribuidora, int t_temasid, byte[] t_resolucionesblob, String t_resolucionesexpte, String t_resolucionestitulo, String t_resolucionesexptecaratula, Date t_resolucionesdate) {
        this.t_resolucionesid = t_resolucionesid;
        this.t_resolucionesnro = t_resolucionesnro;
        this.distribuidora = distribuidora;
        this.t_temasid = t_temasid;
        this.t_resolucionesblob = t_resolucionesblob;
        this.t_resolucionesexpte = t_resolucionesexpte;
        this.t_resolucionestitulo = t_resolucionestitulo;
        this.t_resolucionesexptecaratula = t_resolucionesexptecaratula;
        this.t_resolucionesdate = t_resolucionesdate;
    }
    

    
    public T_resoluciones(){}


}
