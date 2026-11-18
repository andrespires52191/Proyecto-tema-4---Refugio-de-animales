package org.example.menus;

import org.example.dao.AdopcionDao;

public class MenuAdopciones {
    private final AdopcionDao adopcionDao;

    public MenuAdopciones(AdopcionDao adopcionDao) {
        this.adopcionDao = adopcionDao;

        //Gestión de las adopciones (altas, bajas, modificaciones, visualización de las adopciones
        //y de las personas y animales asociados, posibilidad de registrar solicitudes y modificar su
        //estado).

        //Listado de adopciones gestionadas por el refugio. Cada adopción tendrá asociada
        //un animal, una persona adoptante, una fecha de solicitud, una fecha de resolución si
        //la hubiera, un estado (pendiente, aprobada o rechazada) y observaciones. Además,
        //se deberá poder registrar un seguimiento de las adopciones aprobadas. Posibilidad de
        //exportar dichos datos como fichero XML y JSON.
    }
}
