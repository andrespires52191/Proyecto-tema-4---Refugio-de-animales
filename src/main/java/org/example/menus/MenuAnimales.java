package org.example.menus;

import org.example.dao.AnimalDao;
import org.example.dao.RegistroMedicoDao;
import org.example.models.Animal;
import org.example.models.AnimalEstado;
import org.example.models.RegistroMedico;
import org.example.utils.ExportadorJSON;
import org.example.utils.ExportadorXML;

import java.time.LocalDate;
import java.util.List;

import static org.example.utils.EntradaDatos.preguntar;

public class MenuAnimales {
    private final AnimalDao animalDao;
    private final RegistroMedicoDao registroMedicoDao;

    public MenuAnimales(AnimalDao animalDao, RegistroMedicoDao registroMedicoDao) {
        this.animalDao = animalDao;
        this.registroMedicoDao = registroMedicoDao;

        //Gestión de los animales (altas, bajas, modificaciones, visualización de los animales y sus
        //características, consulta del historial médico).

        final String MENU = "1) Listado de animales\n" +
                "2) Alta de animal\n" +
                "3) Baja de animal\n" +
                "4) Modificación de animal\n" +
                "5) Ver historial médico del animal\n" +
                "6) Introducir registro médico de animal\n" +
                "7) Exportar datos a XML\n" +
                "8) Exportar datos a JSON\n" +
                "9) Volver al menú principal";

        int accion = -1;
        while (accion != 9) {
            try {
                accion = Integer.parseInt(preguntar("Elija una opción:\n" + MENU + "\n\nAcción: "));
            } catch (NumberFormatException e) {
                accion = -1;
            }

            switch (accion) {
                case 1:
                    listarAnimales();
                    break;
                case 2:
                    alta();
                    break;
                case 3:
                    baja();
                    break;
                case 4:
                    modificar();
                    break;
                case 5:
                    listarHistorial();
                    break;
                case 6:
                    introducirRegistro();
                    break;
                case 7:
                    exportarXML();
                    break;
                case 8:
                    exportarJSON();
                    break;
                case 9:
                    // Volver al menú principal
                    break;
                default:
                    System.out.println("Acción no válida");
            }

            System.out.println();
        }
    }

    private Animal buscarAnimal() {
        Animal animal = null;
        try {
            int id = Integer.parseInt(preguntar("Introduzca el ID del animal: "));
            animal = animalDao.findById(id);
        } catch (Exception e) {
            System.out.println("Error al buscar el animal: " + e.getMessage());
        }
        return animal;
    }

    private Animal pedirDatosAnimal() {
        Animal animal = null;
        try {
            String nombre = preguntar("Nombre del animal: ");

            String especie = preguntar("Especie del animal: ");

            String raza = preguntar("Raza del animal: ");

            int edad = Integer.parseInt(preguntar("Edad del animal: "));

            String sexo = preguntar("Sexo del animal (M/H): ").toUpperCase();
            if (!sexo.equals("M") && !sexo.equals("H")) {
                System.out.println("Error: El sexo debe ser 'M' o 'H'.");
                return null;
            }

            String descripcion = preguntar("Descripción del animal: ");

            LocalDate fechaIngreso = LocalDate.parse(preguntar("Fecha de ingreso (YYYY-MM-DD): "));

            AnimalEstado estado = AnimalEstado.valueOf(preguntar("Estado del animal (DISPONIBLE, RESERVADO, ADOPTADO, EN_TRATAMIENTO): ").toUpperCase());

            animal = new Animal(nombre, especie, raza, edad, sexo, descripcion, fechaIngreso, estado);
        } catch (Exception e) {
//            throw new Exception(e);
        }
        return animal;
    }

    private void listarAnimales() {
        List<Animal> animales = animalDao.findAll();
        for (Animal animal : animales) {
            System.out.println(animal);
        }
    }

    private void alta() {
        Animal animal = pedirDatosAnimal();
        if (animal == null) {
            System.out.println("Datos no válidos, no se puede dar de alta el animal");
            return;
        }

        try {
            animalDao.create(animal);
            System.out.println("Animal modificado correctamente");
        } catch (Exception e) {
            System.out.println("Error al modificar el animal: " + e.getMessage());
        }
    }

    private void baja() {
        // Se podrá optar por eliminar los documentos y/o por marcarlos como eliminados,
        // teniendo en cuenta las referencias existentes entre las diferentes colecciones.
        Animal animal = buscarAnimal();
        if (animal == null) {
            System.out.println("Animal no encontrado");
            return;
        }

        try {
            animalDao.delete(animal.getId());
            System.out.println("Animal eliminado correctamente");
        } catch (Exception e) {
            System.out.println("Error al eliminar el animal: " + e.getMessage());
        }
    }

    private void modificar() {
        Animal animal = buscarAnimal();
        if (animal == null) {
            System.out.println("Animal no encontrado");
            return;
        }

        Animal datosAnimal = pedirDatosAnimal();
        if (datosAnimal == null) {
            System.out.println("Datos no válidos, no se puede modificar el animal");
            return;
        }

        animal.setNombre(datosAnimal.getNombre());
        animal.setEspecie(datosAnimal.getEspecie());
        animal.setRaza(datosAnimal.getRaza());
        animal.setEdad(datosAnimal.getEdad());
        animal.setSexo(datosAnimal.getSexo());
        animal.setDescripcion(datosAnimal.getDescripcion());
        animal.setFechaIngreso(datosAnimal.getFechaIngreso());
        animal.setEstado(datosAnimal.getEstado());

        try {
            animalDao.update(animal);
            System.out.println("Animal modificado correctamente");
        } catch (Exception e) {
            System.out.println("Error al modificar el animal: " + e.getMessage());
        }
    }

    private void listarHistorial() {
        Animal animal = buscarAnimal();
        if (animal == null) {
            System.out.println("Animal no encontrado");
            return;
        }

        List<RegistroMedico> historial = registroMedicoDao.findByAnimal(animal);
        if (historial.isEmpty()) {
            System.out.println("Aún no hay registros médicos para este animal");
            return;
        }
        for (RegistroMedico registro : historial) {
            System.out.println(registro);
        }
    }

    private void introducirRegistro() {
        Animal animal = buscarAnimal();
        if (animal == null) {
            System.out.println("Animal no encontrado");
            return;
        }

        try {
            LocalDate fechaInicio = LocalDate.parse(preguntar("Fecha de inicio (YYYY-MM-DD): "));
            LocalDate fechaFin = LocalDate.parse(preguntar("Fecha de fin (YYYY-MM-DD): "));
            String comentarios = preguntar("Comentarios: ");

            RegistroMedico registro = new RegistroMedico(animal.getId(), fechaInicio, fechaFin, comentarios);
            registroMedicoDao.create(registro);
            System.out.println("Entrada de historial médico creada correctamente");
        } catch (Exception e) {
            System.out.println("Error al crear la entrada de historial médico: " + e.getMessage());
        }
    }

    private void exportarXML() {
        if (ExportadorXML.exportar("animales.xml", animalDao.findAll(), Animal.class)
                && ExportadorXML.exportar("historial_medico.xml", registroMedicoDao.findAll(), RegistroMedico.class)) {
            System.out.println("Exportado con éxito.");
        } else {
            System.out.println("Fallo al exportar.");
        }
    }

    private void exportarJSON() {
        if (ExportadorJSON.exportar("animales.json", animalDao.findAll())
                && ExportadorJSON.exportar("historial_medico.json", registroMedicoDao.findAll())
        ) {
            System.out.println("Exportado con éxito.");
        } else {
            System.out.println("Fallo al exportar.");
        }
    }
}
