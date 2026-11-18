package org.example.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Database {
    MongoClient mongo;

    public Database() {
        mongo = new MongoClient("localhost", 27017);
    }

    public MongoDatabase getDatabase() {
        return mongo.getDatabase("RefugioAnimales");
    }
}

//    private static void ejemplo() {
//        MongoClient mongo = new MongoClient("localhost", 27017);
//
//        MongoDatabase db = mongo.getDatabase("Concesionario");
//
//        MongoCollection<Document> coches = db.getCollection("Coches");
//
//        Document coche = new Document("id", 1)
//                .append("marca", "Toyota")
//                .append("modelo", "Corolla")
//                .append("anio", 2022)
//                .append("precio", 24500.50)
//                .append("color", "Blanco")
//                .append("electrico", false);
//
//        coches.insertOne(coche);
//
//        for (Document document : coches.find()) {
//            System.out.println(document);
//        }
//
//        mongo.close();
//    }
