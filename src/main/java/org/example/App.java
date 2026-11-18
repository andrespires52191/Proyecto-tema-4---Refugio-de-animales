package org.example;

import org.example.dao.AdopcionDao;
import org.example.dao.AdoptanteDao;
import org.example.dao.AnimalDao;
import org.example.dao.RefugioDao;
import org.example.menus.*;

import static org.example.utils.EntradaDatos.preguntar;

public class App {
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        AdopcionDao adopcionDao = new AdopcionDao();
        AdoptanteDao adoptanteDao = new AdoptanteDao();
        AnimalDao animalDao = new AnimalDao();
        RefugioDao refugioDao = new RefugioDao();

        final String MENU = "1) Información del Refugio\n" +
                "2) Gestionar Animales\n" +
                "3) Gestionar Adoptantes\n" +
                "4) Gestionar Adopciones\n" +
                "5) Gestionar Metadatos\n" +
                "6) Salir";

        int accion = -1;
        while (accion != 6) {
            try {
                accion = Integer.parseInt(preguntar("Elija una opción:\n" + MENU + "\n\nAcción: "));
            } catch (NumberFormatException e) {
                accion = -1;
            }

            switch (accion) {
                case 1:
                    new MenuRefugio(refugioDao);
                    break;
                case 2:
                    new MenuAnimales(animalDao);
                    break;
                case 3:
                    new MenuAdoptantes(adoptanteDao);
                    break;
                case 4:
                    new MenuAdopciones(adopcionDao);
                    break;
                case 5:
                    new MenuMetadatos();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Acción no válida");
            }
        }
    }
}
