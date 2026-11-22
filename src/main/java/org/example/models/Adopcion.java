package org.example.models;

import java.time.LocalDate;

public class Adopcion {
    //Adopciones (número identificador de la adopción, animal asociado, adoptante asociado,
    //fecha de solicitud, fecha de resolución, estado, observaciones y seguimiento).

    //Listado de adopciones gestionadas por el refugio. Cada adopción tendrá asociada
    //un animal, una persona adoptante, una fecha de solicitud, una fecha de resolución si
    //la hubiera, un estado (pendiente, aprobada o rechazada) y observaciones. Además,
    //se deberá poder registrar un seguimiento de las adopciones aprobadas. Posibilidad de
    //exportar dichos datos como fichero XML y JSON.

    int id;
    Animal animal;
    Adoptante adoptante;
    LocalDate fechaSolicitud;
    LocalDate fechaResolucion;
    AdopcionEstado estado; // PENDIENTE, APROBADA, RECHAZADA
    String observaciones;
    String seguimiento;

    public Adopcion(Animal animal, Adoptante adoptante, LocalDate fechaSolicitud, LocalDate fechaResolucion, AdopcionEstado estado, String observaciones, String seguimiento) {
        this.animal = animal;
        this.adoptante = adoptante;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaResolucion = fechaResolucion;
        this.estado = estado;
        this.observaciones = observaciones;
        this.seguimiento = seguimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDate fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public AdopcionEstado getEstado() {
        return estado;
    }

    public void setEstado(AdopcionEstado estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }
}
