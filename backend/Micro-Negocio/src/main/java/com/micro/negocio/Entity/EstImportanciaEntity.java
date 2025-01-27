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
@Table(name="est_importancia")

public class EstImportanciaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator= "proyecto")
	@SequenceGenerator(name="proyecto", sequenceName="proyecto_seq", allocationSize = 1)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String alias;
	
	@Column
	private Date fecha_registro;
	
}
