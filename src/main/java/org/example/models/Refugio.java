package org.example.models;

import java.time.LocalDate;

public class Refugio {
    //Visualización de un menú principal con los datos más relevantes del refugio (por ejemplo
    //nombre, fecha de apertura, dirección, CIF, información de contacto...).
    //Refugio (visualización y modificación de los datos del refugio: razón social, CIF, dirección,
    //información de contacto...).

    String nombre;
    LocalDate fechaApertura;
    String informacionContacto;
    String cif;
    String razonSocial;
    String direccion;

    public Refugio(String nombre, LocalDate fechaApertura, String informacionContacto, String cif, String razonSocial, String direccion) {
        this.nombre = nombre;
        this.fechaApertura = fechaApertura;
        this.informacionContacto = informacionContacto;
        this.cif = cif;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getInformacionContacto() {
        return informacionContacto;
    }

    public void setInformacionContacto(String informacionContacto) {
        this.informacionContacto = informacionContacto;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
