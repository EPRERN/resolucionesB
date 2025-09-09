package com.eprern.resoluciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;

@Entity
public class T_resoluciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long t_resolucionesid;

    @Getter @Setter
    private String t_resolucionesnro;
    
    @ManyToOne
    @JoinColumn(name = "t_distribuidorasid", nullable = false)
    @Getter @Setter
    private T_distribuidoras distribuidora;
	
	
	@ManyToOne
	@JoinColumn(name = "t_temasid", nullable = false)
	private T_temas tema;

    
    @Getter @Setter
    @Column(columnDefinition = "bytea", nullable = true)
    @JdbcTypeCode(SqlTypes.BINARY)
    private byte[] t_resolucionesblob;
    
    @Getter @Setter
    private String t_resolucionesexpte;
    
    @Getter @Setter
    private String t_resolucionestitulo;
    
    @Getter @Setter
    private String t_resolucionesexptecaratula;
    
    @Getter @Setter
    private Date t_resolucionesdate;
	
	
	public T_resoluciones(Long t_resolucionesid, String t_resolucionesnro, T_distribuidoras distribuidora, T_temas tema, byte[] t_resolucionesblob, String t_resolucionesexpte, String t_resolucionestitulo, String t_resolucionesexptecaratula, Date t_resolucionesdate) {
		this.t_resolucionesid = t_resolucionesid;
		this.t_resolucionesnro = t_resolucionesnro;
		this.distribuidora = distribuidora;
		this.tema = tema;
		this.t_resolucionesblob = t_resolucionesblob;
		this.t_resolucionesexpte = t_resolucionesexpte;
		this.t_resolucionestitulo = t_resolucionestitulo;
		this.t_resolucionesexptecaratula = t_resolucionesexptecaratula;
		this.t_resolucionesdate = t_resolucionesdate;
	}
	
	public T_resoluciones(){}


}
