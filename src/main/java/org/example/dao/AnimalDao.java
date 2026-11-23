package org.example.dao;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.models.Animal;
import org.example.models.AnimalEstado;
import org.example.utils.DatabaseConnection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//    String objectId;
//    int id;
//    String nombre;
//    String especie;
//    String raza;
//    int edad;
//    String sexo;
//    String descripcion;
//    LocalDate fechaIngreso;
//    AnimalEstado estado; // DISPONIBLE, RESERVADO, ADOPTADO, EN_TRATAMIENTO

public class AnimalDao extends Dao {
    private MongoCollection<Document> getCollection() {
        return DatabaseConnection.getInstance().getDatabase().getCollection("Animales");
    }

    public Animal asAnimal(Document doc) throws Exception {
        try {
            Animal animal = new Animal(
                    doc.getString("nombre"),
                    doc.getString("especie"),
                    doc.getString("raza"),
                    doc.getInteger("edad"),
                    doc.getString("sexo"),
                    doc.getString("descripcion"),
                    LocalDate.parse(doc.getString("fechaIngreso")),
                    AnimalEstado.valueOf(doc.getString("estado"))
            );
            animal.setObjectId(doc.getObjectId("_id").toString());
            animal.setId(doc.getInteger("id"));
            return animal;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Document asDocument(Animal animal) throws Exception {
        try {
            Document doc = new Document()
                    .append("id", animal.getId())
                    .append("nombre", animal.getNombre())
                    .append("especie", animal.getEspecie())
                    .append("raza", animal.getRaza())
                    .append("edad", animal.getEdad())
                    .append("sexo", animal.getSexo())
                    .append("descripcion", animal.getDescripcion())
                    .append("fechaIngreso", animal.getFechaIngreso().toString())
                    .append("estado", animal.getEstado().toString());
            return doc;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Animal> findAll() {
        List<Animal> lista = new ArrayList<>();
        try {
            for (Document doc : getCollection().find()) {
                lista.add(asAnimal(doc));
            }
        } catch (Exception e) {
            //throw new Exception(e);
        }
        return lista;
    }

    public Animal findById(int id) {
        Document doc = getCollection().find(new Document("id", id)).first();
        if (doc == null) {
            return null;
        }
        Animal animal = null;
        try {
            animal = asAnimal(doc);
        } catch (Exception e) {
            //throw new Exception(e);
        }
        return animal;
    }

    public void create(Animal animal) throws Exception {
        try {
            // Asignar un ID único antes de insertarlo.
            int id = animal.getId();
            if (id == 0) {
                id = getNextId(new Document("_id", "animal_id"));
                animal.setId(id);
            }

            Document doc = asDocument(animal);
            getCollection().insertOne(doc);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void update(Animal animal) throws Exception {
        try {
            Document doc = asDocument(animal);
            getCollection().replaceOne(new Document("id", animal.getId()), doc);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void delete(int animalId) throws Exception {
        try {
            getCollection().deleteOne(new Document("id", animalId));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
