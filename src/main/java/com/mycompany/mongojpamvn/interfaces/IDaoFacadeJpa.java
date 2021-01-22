package com.mycompany.mongojpamvn.interfaces;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 * @param <E> Entity generic
 */
@Local
public interface IDaoFacadeJpa<E> {

    public void insertar(E entity);
    public void modificar(E entity);
    public void eliminar(E entity);
    public List<E> buscarTodos();
    public E buscarId(Object id);

}