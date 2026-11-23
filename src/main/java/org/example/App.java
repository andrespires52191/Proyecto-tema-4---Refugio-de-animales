package org.example;

import org.example.dao.*;
import org.example.menus.*;

import static org.example.utils.EntradaDatos.preguntar;

public class App {
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        RefugioDao refugioDao = new RefugioDao();
        AnimalDao animalDao = new AnimalDao();
        RegistroMedicoDao registroMedicoDao = new RegistroMedicoDao();
        AdoptanteDao adoptanteDao = new AdoptanteDao();
        AdopcionDao adopcionDao = new AdopcionDao();

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
                    new MenuAnimales(animalDao, registroMedicoDao);
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

            System.out.println();
        }
    }
}
