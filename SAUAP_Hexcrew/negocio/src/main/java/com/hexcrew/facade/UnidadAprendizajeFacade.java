package com.hexcrew.facade;

import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.delegate.IUnidadAprendizajeDelegate;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class UnidadAprendizajeFacade implements IUnidadAprendizajeFacade{
    @EJB
    private IUnidadAprendizajeDelegate delegate;
    
    @Override
    public UnidadAprendizaje setUnidadAprendizaje(UnidadAprendizaje u)
    {
        return delegate.guardar(u);
    }
}
