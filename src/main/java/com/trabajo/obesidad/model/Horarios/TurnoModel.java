package com.trabajo.obesidad.model.Horarios;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "turnos")
public class TurnoModel {

    @Id
    int id;
    LocalDate fecha;
    LocalTime hora;
    int id_usuario;
    int id_medico;
    boolean estado;
}