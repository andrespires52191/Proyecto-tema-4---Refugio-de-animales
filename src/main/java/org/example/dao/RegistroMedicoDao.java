package org.example.dao;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.models.Animal;
import org.example.models.RegistroMedico;
import org.example.utils.DatabaseConnection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//    String objectId;
//    int animalId;
//    LocalDate fechaInicio;
//    LocalDate fechaFin;
//    String comentarios;

public class RegistroMedicoDao extends Dao {
    private MongoCollection<Document> getCollection() {
        return DatabaseConnection.getInstance().getDatabase().getCollection("RegistroMedico");
    }

    public Document asDocument(RegistroMedico registroMedico) throws Exception {
        try {
            Document doc = new Document()
                    .append("animalId", registroMedico.getAnimalId())
                    .append("fechaInicio", registroMedico.getFechaInicio().toString())
                    .append("fechaFin", registroMedico.getFechaFin().toString())
                    .append("comentarios", registroMedico.getComentarios());
            return doc;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public RegistroMedico asRegistroMedico(Document doc) throws Exception {
        try {
            RegistroMedico registro = new RegistroMedico(
                    doc.getInteger("animalId"),
                    LocalDate.parse(doc.getString("fechaInicio")),
                    LocalDate.parse(doc.getString("fechaFin")),
                    doc.getString("comentarios")
            );
            return registro;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<RegistroMedico> findAll() {
        List<RegistroMedico> lista = new ArrayList<>();
        try {
            for (Document doc : getCollection().find()) {
                lista.add(asRegistroMedico(doc));
            }
        } catch (Exception e) {
            //throw new Exception(e);
        }
        return lista;
    }

    public List<RegistroMedico> findByAnimal(Animal animal) {
        List<RegistroMedico> historial = new ArrayList<>();
        try {
            for (Document doc : getCollection().find(new Document("animalId", animal.getId()))) {
                historial.add(asRegistroMedico(doc));
            }
        } catch (Exception e) {
//            throw new Exception(e);
        }
        return historial;
    }

    public void create(RegistroMedico registro) throws Exception {
        try {
            Document doc = asDocument(registro);
            getCollection().insertOne(doc);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void update(RegistroMedico registro) throws Exception {
        try {
            Document doc = asDocument(registro);
            getCollection().replaceOne(new Document("_id", registro.getObjectId()), doc);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void delete(int registroMedicoObjectId) throws Exception {
        try {
            getCollection().deleteOne(new Document("_id", registroMedicoObjectId));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
