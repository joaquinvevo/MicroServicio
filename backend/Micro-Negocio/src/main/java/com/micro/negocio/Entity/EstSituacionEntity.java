package com.micro.negocio.Entity;

import java.util.Date;

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
@Table(name="est_situacion")
public class EstSituacionEntity {
	
	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO, generator = "proyecto")
	 @SequenceGenerator(name="proyecto", sequenceName = "proyecto_seq", allocationSize= 1)
	 private Long id;
	
	 @Column
	 private Long est_submodelo_id;
	
	 @Column
	 private Long bcs_objetivo_id;
	 
	 @Column
	 private Long est_impacto_id;
	 
	 @Column
	 private Long est_importancia_id;
	 
	 @Column
	 private Integer relevancia;

	 @Column
	 private String nombre;
	 
	 @Column
	 private String alias;
	 
	 @Column
	 private String descripcion;
	 
	 @Column
	 private Integer orden;
	 
	 @Column
	 private boolean incluir;
	 
	 @Column
	 private Date fecha_registro;
	 
}
