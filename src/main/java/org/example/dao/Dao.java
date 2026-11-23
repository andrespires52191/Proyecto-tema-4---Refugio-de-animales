package org.example.dao;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.utils.DatabaseConnection;

abstract public class Dao {
    protected MongoCollection<Document> getCounters() {
        return DatabaseConnection.getInstance().getDatabase().getCollection("Counters");
    }

    protected int getNextId(Document filter) {
        int id = 0;

        // Usar la colección de contadores
        MongoCollection<Document> counters = getCounters();

        // Obtener el siguiente valor del contador
        Document counterDoc = counters.find(filter).first();
        if (counterDoc == null) {
            // Crear el contador si no existe
            counters.insertOne(filter.append("seq", 1));
            id = 1;
        } else {
            // Incrementar el valor del contador
            id = counterDoc.getInteger("seq") + 1;
            counters.updateOne(filter, new Document("$set", new Document("seq", id)));
        }

        return id;
    }
}
