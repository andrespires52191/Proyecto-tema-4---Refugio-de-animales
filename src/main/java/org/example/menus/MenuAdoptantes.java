package org.example.menus;

import org.example.dao.AdoptanteDao;
import org.example.dao.AdoptanteDao;

public class MenuAdoptantes {
    private final AdoptanteDao adoptanteDao;

    public MenuAdoptantes(AdoptanteDao adoptanteDao) {
        this.adoptanteDao = adoptanteDao;

        //Gestión de los adoptantes (altas, bajas, modificaciones, visualización de los adoptantes y
        //consulta de sus solicitudes y adopciones).

        //Listado de adoptantes que se han registrado en el refugio. De cada adoptante se
        //debe registrar el DNI/NIE, nombre, apellidos, teléfono de contacto, dirección, email,
        //fecha de registro y preferencias de adopción. Además, por cada adoptante se deberán
        //poder consultar sus solicitudes y adopciones. Posibilidad de exportar dichos datos
        //como fichero XML y JSON.
    }
}
