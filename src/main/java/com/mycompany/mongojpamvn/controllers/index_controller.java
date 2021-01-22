/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongojpamvn.controllers;

import com.mycompany.mongojpamvn.entities.TestCollection;
import com.mycompany.mongojpamvn.interfaces.IDaoFacadeJpa;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author daniel
 */
@ManagedBean
public class index_controller {

    private List<TestCollection> dataList;
    private static Logger logger;
    @EJB
    private IDaoFacadeJpa<TestCollection> daoJpa;
    //Basic conection
//    private List<TestCollectionPojo> dataList;
//    private List<DBObject> list;
//    private BasicDBObject documento;
//    private MongoConnection conexion;
//    @EJB
//    private IDaoFacade<DBObject, DBCursor> dao;

    
    @PostConstruct
    public void init() {
        dataList = new ArrayList<>();
//        list = new ArrayList<>();
//        documento = new BasicDBObject();
//        conexion = MongoConnection.genConnection("test", "TESTCOLLECTION"); //TODO mover a dao implementation
        logger = Logger.getLogger(this.getClass().getName());
        generaData();
    }

    public List<TestCollection> getDataList() {
        return dataList;
    }

    public void generaData() {

//        JPA
        
//        Insertar con jpa
//        TestCollection entity = new TestCollection();
//        entity.setId("1");
//        entity.setNombre("nuevo");
//        daoJpa.insertar(entity);
//        entity = new TestCollection();
//        entity.setId("2");
//        entity.setNombre("daniel");
//        daoJpa.insertar(entity);
        
//        Modificar con jpa
//        TestCollection entity = (TestCollection) daoJpa.buscarId("1");
//        entity.setNombre("modificado");
//        daoJpa.modificar(entity);

//        Eliminar con jpa
//        TestCollection entity = (TestCollection) daoJpa.buscarId("1");
//        daoJpa.eliminar(entity);
        
        
        dataList = daoJpa.buscarTodos();

//      Ejemplo de listar todos los elementos con conexion TIPO JDBC BASICO

//        List<TestCollectionPojo> resultado = new ArrayList<>();
//        DBCursor lista = dao.buscarNombre();
//        for (DBObject registro : lista) {
//            TestCollectionPojo pojo = new TestCollectionPojo();
//            pojo.setId((String) registro.get("id"));
//            pojo.setNombre((String) registro.get("nombre"));
//            resultado.add(pojo);
//        }
//        dataList = resultado;

//        Ejemplo de Insertar, probado Ok
//        documento.put("id", "3");
//        documento.put("nombre", "daniel");
//        list.add(documento);
//        documento = new BasicDBObject();
//        documento.put("id", "4");
//        documento.put("nombre", "enrique");
//        list.add(documento);
//        dao.insertar(list);

//        Ejemplo de Eliminar, probado Ok
//        documento.put("id", "4");
//        documento.put("nombre", "qwer");
//        dao.eliminar(documento);

//        Ejemplo de Modificar, probado Ok
//        documento.put("id", "3");
//        documento.put("nombre", "asd");
//        BasicDBObject documentoNuevo = new BasicDBObject();
//        documentoNuevo.put("id", "3");
//        documentoNuevo.put("nombre", "ortiz");
//        dao.modificar(documento, documentoNuevo);
    }

}
