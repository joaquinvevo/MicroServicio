package com.micro.negocio.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bsc_objetivo")
public class BcsObjetivoEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "linea_gen")
    @SequenceGenerator(name = "linea_gen", sequenceName = "linea_seq", allocationSize = 1)
    private Long id;
    
    @Column
    private Long bsc_tipo_objetivo_id;
    
    @Column
    private Long bcs_tema_id;
    
    @Column
    private Long org_departamento_id_responsable_id;
    
    @Column
    private String nombre;  

    @Column
    private String alias; 

    @Column
    private String descripcion; 
    
    @Column
    private Integer orden;
    
    @Column
    private String codigo;
    
    @Column
    private Date fechaRegistro;
}