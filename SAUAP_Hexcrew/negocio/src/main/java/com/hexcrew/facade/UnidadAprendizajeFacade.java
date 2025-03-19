package com.hexcrew.facade;

import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.delegate.IUnidadAprendizajeDelegate;
import com.hexcrew.facade.IUnidadAprendizajeFacade;
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
    public List<UnidadAprendizaje> obtenerLista(){
        return delegate.listar();
    }
    
    @Override
    public UnidadAprendizaje guardarUnidadAprendizaje(UnidadAprendizaje u) {
        return delegate.registrar(u);
    }
    
    @Override
    public UnidadAprendizaje buscarUnidadAprendizaje(Integer id) {
        return delegate.buscar(id);
    }
}
