package org.example.models;

import java.time.LocalDate;

public class Adoptante {
    //Adoptantes (DNI/NIE, nombre, apellidos, teléfono, dirección, email, fecha de registro y
    //preferencias de adopción).

    int id;
    String dni;
    String nombre;
    String apellidos;
    String telefono;
    String direccion;
    String email;
    LocalDate fechaRegistro;
    String preferenciasAdopcion;

    public Adoptante(String dni, String nombre, String apellidos, String telefono, String direccion, String email, LocalDate fechaRegistro, String preferenciasAdopcion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.preferenciasAdopcion = preferenciasAdopcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getPreferenciasAdopcion() {
        return preferenciasAdopcion;
    }

    public void setPreferenciasAdopcion(String preferenciasAdopcion) {
        this.preferenciasAdopcion = preferenciasAdopcion;
    }
}
