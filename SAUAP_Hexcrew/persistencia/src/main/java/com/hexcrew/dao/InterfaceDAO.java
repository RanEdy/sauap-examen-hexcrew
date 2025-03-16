package com.hexcrew.dao;

import java.util.List;
import jakarta.ejb.Local;
/**
 *
 * @author Erandi
 * 15/03/2025
 * 
 * @param T 
 * Nombre de la clase del modelo de dato o Entidad (Ejemplo: Usuario)
 */
@Local
public interface InterfaceDAO<T>
{
    T save(T entity);
    T update(T entity);
    T find(T entity);
    void delete(T entity);
    List<T> findAll();
    
}
