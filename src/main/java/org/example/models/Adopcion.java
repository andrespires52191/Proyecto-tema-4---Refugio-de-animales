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
}
