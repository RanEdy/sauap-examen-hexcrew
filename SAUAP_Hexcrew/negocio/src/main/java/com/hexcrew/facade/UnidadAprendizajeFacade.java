package com.hexcrew.facade;

import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.delegate.IUnidadAprendizajeDelegate;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 * 
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class UnidadAprendizajeFacade implements IUnidadAprendizajeFacade{
    @EJB
    private IUnidadAprendizajeDelegate delegate;
    
    @Override
    public UnidadAprendizaje setUnidadAprendizaje(UnidadAprendizaje u)
    {
        return delegate.guardar(u);
    }
    
    @Override
    public List<UnidadAprendizaje> obtenerListaUnidades(){
        return delegate.listar();
    }

    @Override
    public boolean validarClaveUnidad(Integer clave) {
        return delegate.validarClave(clave);
    }
}
