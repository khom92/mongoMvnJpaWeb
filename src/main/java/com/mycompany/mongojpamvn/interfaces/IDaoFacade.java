package com.mycompany.mongojpamvn.interfaces;

import java.util.List;

/**
 *
 * @author daniel
 * @param <I> Input object
 * @param <O> Output object
 */
public interface IDaoFacade<I,O> {

    public void insertar(List<I> list);
    public void modificar(I antiguo, I nuevo);
    public void eliminar(I dbo);
    public O buscarTodos();
    public O buscarNombre();

}