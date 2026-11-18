package org.example.models;

import java.time.LocalDate;
import java.util.List;

public class Animal {
    //Animales (número identificador del animal, nombre, especie, raza, edad, sexo,
    //descripción, fecha de ingreso, estado e historial médico).

    //Listado de animales acogidos en el refugio, mostrando datos como el número
    //identificador del animal, nombre, especie, raza, edad, sexo, descripción, fecha de
    //ingreso, estado (disponible, reservado, adoptado o en tratamiento) e historial médico.
    //Este último deberá permitir almacenar diferentes registros médicos de cada animal.
    
    int id;
    String nombre;
    String especie;
    String raza;
    int edad;
    String sexo;
    String descripcion;
    LocalDate fechaIngreso;
    AnimalEstado estado; // DISPONIBLE, RESERVADO, ADOPTADO, EN_TRATAMIENTO
    List<RegistroMedico> historialMedico;
}
