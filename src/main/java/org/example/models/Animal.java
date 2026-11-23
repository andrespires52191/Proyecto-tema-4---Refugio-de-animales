package org.example.models;

import java.time.LocalDate;

public class Animal {
    //Animales (número identificador del animal, nombre, especie, raza, edad, sexo,
    //descripción, fecha de ingreso, estado e historial médico).

    //Listado de animales acogidos en el refugio, mostrando datos como el número
    //identificador del animal, nombre, especie, raza, edad, sexo, descripción, fecha de
    //ingreso, estado (disponible, reservado, adoptado o en tratamiento) e historial médico.
    //Este último deberá permitir almacenar diferentes registros médicos de cada animal.

    String objectId;
    int id;
    String nombre;
    String especie;
    String raza;
    int edad;
    String sexo;
    String descripcion;
    LocalDate fechaIngreso;
    AnimalEstado estado; // DISPONIBLE, RESERVADO, ADOPTADO, EN_TRATAMIENTO

    public Animal(String nombre, String especie, String raza, int edad, String sexo, String descripcion, LocalDate fechaIngreso, AnimalEstado estado) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public AnimalEstado getEstado() {
        return estado;
    }

    public void setEstado(AnimalEstado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "objectId='" + objectId + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", estado=" + estado +
                '}';
    }
}
