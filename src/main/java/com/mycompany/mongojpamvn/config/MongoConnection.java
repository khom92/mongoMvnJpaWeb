/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongojpamvn.config;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author daniel
 */
@ApplicationScoped
public class MongoConnection {
    
    private String databaseName;
    private String collectionName;
    private static DB dataBaseMongo;
    public static DBCollection collection;
    private static MongoConnection mongoConection;
    private static Logger logger;
    
    private MongoConnection(String databaseName, String collectionName){
        this.databaseName = databaseName;
        this.collectionName = collectionName;
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    public static MongoConnection genConnection(String databaseName, String collectionName){
        if(mongoConection == null){
            mongoConection = new MongoConnection(databaseName, collectionName);
            try {
                Mongo mongo = new Mongo("localhost", 27017);
                dataBaseMongo = mongo.getDB(databaseName);
                collection = dataBaseMongo.getCollection(collectionName);
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage(), e.getStackTrace()[0].toString());
            }
        }
        return mongoConection;
    }
    
    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public DB getDataBaseMongo() {
        return dataBaseMongo;
    }

    public void setDataBaseMongo(DB dataBaseMongo) {
        MongoConnection.dataBaseMongo = dataBaseMongo;
    }

}