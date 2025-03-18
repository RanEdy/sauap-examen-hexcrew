package com.hexcrew.facade;

import com.hexcrew.delegate.IProfesorDelegate;
import com.hexcrew.entidad.Profesor;
import com.hexcrew.facade.IProfesorFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class ProfesorFacade implements IProfesorFacade
{
    @EJB
    private IProfesorDelegate delegate;
    
    @Override
    public List<Profesor> obtenerLista(){
        return delegate.listar();
    }

    @Override
    public boolean eliminarProfesor(Profesor p) {
        return delegate.eliminar(p);
    }

    @Override
    public Profesor guardarProfesor(Profesor p) {
        return delegate.registrar(p);
    }

    @Override
    public Profesor editarProfesor(Profesor p) {
        return delegate.editar(p);
    }

    @Override
    public Profesor buscarProfesor(Integer id) {
        return delegate.buscar(id);
    }
    
}
