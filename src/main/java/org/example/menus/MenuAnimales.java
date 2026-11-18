package org.example.menus;

import org.example.dao.AnimalDao;

public class MenuAnimales {
    private final AnimalDao animalDao;

    public MenuAnimales(AnimalDao animalDao) {
        this.animalDao = animalDao;

        //Gestión de los animales (altas, bajas, modificaciones, visualización de los animales y sus
        //características, consulta del historial médico).

        //Listado de animales acogidos en el refugio, mostrando datos como el número
        //identificador del animal, nombre, especie, raza, edad, sexo, descripción, fecha de
        //ingreso, estado (disponible, reservado, adoptado o en tratamiento) e historial médico.
        //Este último deberá permitir almacenar diferentes registros médicos de cada animal.
        //Posibilidad de exportar dichos datos como fichero XML y JSON.


        //Altas de animales, adoptantes y adopciones.
        //Modificaciones de animales, adoptantes y adopciones ya existentes.
        //Bajas de animales, adoptantes y adopciones ya existentes. Se podrá optar por eliminar
        //los documentos y/o por marcarlos como eliminados, teniendo en cuenta las referencias existentes entre las diferentes colecciones.
        //Listado y exportación de los metadatos de las bases de datos:
        //BBDD (nombre, colecciones, índices...).
        //Colecciones de la BBDD (nombre de la colección, número de documentos, índices
        //asociados...).
        //Índices de las colecciones (nombre, campos sobre los que se aplican y tipo de índice).
        //Los datos de animales, adoptantes y adopciones deberán poder exportarse a ficheros XML y
        //JSON.
        //La aplicación deberá permitir consultar y exportar los metadatos de la base de datos,
        //sus colecciones e índices.
        //Se deberán utilizar documentos anidados y arrays para almacenar información relacionada
        //cuando corresponda.
        //La aplicación deberá gestionar correctamente las referencias entre las diferentes
        //colecciones.


    }
}
