package com.trabajo.obesidad.model.Medicos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medicos")
public class MedicosModel {

    @Id
    int id;
    String nombre;
    String pass;

}
