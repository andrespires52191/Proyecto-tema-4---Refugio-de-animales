package org.example.models;

import java.time.LocalDate;

public class RegistroMedico {
    String objectId;
    int animalId;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    String comentarios;

    public RegistroMedico(int animalId, LocalDate fechaInicio, LocalDate fechaFin, String comentarios) {
        this.animalId = animalId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.comentarios = comentarios;
    }

    public RegistroMedico(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "RegistroMedico{" +
                "objectId=" + objectId +
                ", animalId=" + animalId +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
