/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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
}
