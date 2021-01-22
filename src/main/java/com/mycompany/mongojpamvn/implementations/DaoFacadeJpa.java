package com.mycompany.mongojpamvn.implementations;

import com.mycompany.mongojpamvn.entities.TestCollection;
import com.mycompany.mongojpamvn.interfaces.IDaoFacadeJpa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author daniel
 */
@Stateless
public class DaoFacadeJpa implements IDaoFacadeJpa<TestCollection>{

    @PersistenceContext(unitName = "mongoPU")
    EntityManager em;
    
    @Override
    public List<TestCollection> buscarTodos() {
        Query query = em.createQuery("SELECT u FROM TestCollection u");
        List<TestCollection> lista = query.getResultList();
        return lista;
    }

    @Override
    public void insertar(TestCollection entity) {
        em.persist(entity);
    }

    @Override
    public void modificar(TestCollection entity) {
        em.merge(entity);
    }

    @Override
    public void eliminar(TestCollection entity) {
        em.remove(entity);
    }

    @Override
    public TestCollection buscarId(Object id) {
        Query query = em.createQuery("SELECT u FROM TestCollection u where u.id = :id").setParameter("id", id);
        TestCollection obj = (TestCollection) query.getSingleResult();
        return obj;
    }

    
}