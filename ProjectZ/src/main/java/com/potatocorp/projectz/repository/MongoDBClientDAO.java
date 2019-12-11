/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.potatocorp.projectz.entity.Client;
import org.bson.Document;

/**
 *
 * @author Pierre
 */
public class MongoDBClientDAO {
    public void saveClient(Client cl){
        String Url ="mongodb://devlo54:EZ54kBwnJky3HU4@database-shard-00-00-kldkd.mongodb.net:27017,database-shard-00-01-kldkd.mongodb.net:27017,database-shard-00-02-kldkd.mongodb.net:27017/test?ssl=true&replicaSet=Database-shard-0&authSource=admin&retryWrites=true&w=majority";
        MongoClientURI uri = new MongoClientURI(Url);

         MongoClient mongoClient = new MongoClient(uri);
         MongoDatabase database = mongoClient.getDatabase("LO54");
         MongoCollection<Document> collection = database.getCollection("inscriptions");
        
       
        Document client = new Document("FirstName", cl.getFirstName())
                .append("LastName", cl.getLastName())
                .append("Address", cl.getAddress())
                .append("Phone", cl.getPhone())
                .append("CourseSession", cl.getSession().getId());
        collection.insertOne(client);
        mongoClient.close();
        
    }
}
