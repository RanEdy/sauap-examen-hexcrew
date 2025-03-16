/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 * @author Usuario
 */
public abstract class AbstractDAO<T> implements InterfaceDAO<T>
{
    private final Class<T> entityClass;
    
    public AbstractDAO(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }
    
    @PersistenceContext(unitName="SAUAP_PU")
    protected EntityManager em;
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
    @Override
    public T save(T entity)
    {
        getEntityManager().persist(entity);
        return entity;
    }
    
    @Override
    public T update(T entity)
    {
        getEntityManager().merge(entity);
        return entity;
    }
    
    @Override
    public T find(Object entityId)
    {
        return getEntityManager().find(entityClass, entityId);
    }
    
    @Override
    public void delete(T entity)
    {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    @Override
    public List<T> findAll()
    {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
