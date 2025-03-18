 package com.hexcrew.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
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
    @Transactional
    public T save(T entity)
    {
        getEntityManager().persist(entity);
        return entity;
    }
    
    @Override
    @Transactional
    public T update(T entity)
    {
        getEntityManager().merge(entity);
        return entity;
    }
    
    @Override
    @Transactional
    public T find(Object entityId)
    {
        return getEntityManager().find(entityClass, entityId);
    }
    
    @Override
    @Transactional
    public void delete(T entity)
    {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    @Override
    @Transactional
    public List<T> findAll()
    {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    @Override
    @Transactional
    public List<T> executeQuery(String jpql, Map<String, Object> params)
    {
        TypedQuery<T> query = getEntityManager().createQuery(jpql, entityClass);
    
        // Asignar parámetros si existen
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        return query.getResultList();
    }
}
