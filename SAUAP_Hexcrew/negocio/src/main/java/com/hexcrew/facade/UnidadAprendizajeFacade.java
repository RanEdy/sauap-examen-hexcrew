package com.hexcrew.facade;

import com.hexcrew.delegate.IUnidadAprendizajeDelegate;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

public class UnidadAprendizajeFacade implements IUnidadAprendizajeFecade{
    @EJB
    private IUnidadAprendizajeDelegate delegate;
}
