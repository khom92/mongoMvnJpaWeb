package com.mycompany.mongojpamvn.implementations;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mycompany.mongojpamvn.config.MongoConnection;
import com.mycompany.mongojpamvn.interfaces.IDaoFacade;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author daniel
 */
@Stateless
public class DaoFacade implements IDaoFacade<DBObject,DBCursor> {

    @Override
    public void insertar(List<DBObject> list) {
        MongoConnection.collection.insert(list);
    }

    @Override
    public void modificar(DBObject antiguo, DBObject nuevo) {
        MongoConnection.collection.findAndModify(antiguo, nuevo);
    }

    @Override
    public void eliminar(DBObject dbo) {
        MongoConnection.collection.remove(dbo);
    }

    @Override
    public DBCursor buscarTodos() {
        return MongoConnection.collection.find();
    }
    
    @Override
    public DBCursor buscarNombre() {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("nombre", "Daniel");
        return MongoConnection.collection.find(whereQuery);
    }
    
}