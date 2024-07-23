package com.trabajo.obesidad.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "usuarios")
public class UsuarioModel {

	@Id
	int id;
	String cedula;
	String nombres;
	String apellidos;
	String telefono;
	String correo;
	int edad;
	double altura;
	double peso;
	boolean historialfamiliar;
	String entrecomidas;
	boolean comidascaloricas;
	String prediacnostico;
	String recomendacion;
}
