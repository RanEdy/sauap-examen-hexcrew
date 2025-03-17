package com.hexcrew.dao;

import java.util.List;
import jakarta.ejb.Local;
import java.util.Map;
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
    public T save(T entity);
    public T update(T entity);
    public T find(Object entity);
    public void delete(T entity);
    public List<T> findAll();
    public List<T> executeQuery(String jpql, Map<String, Object> params);
    
}
