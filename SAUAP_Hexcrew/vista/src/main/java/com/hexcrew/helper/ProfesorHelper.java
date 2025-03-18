package com.hexcrew.helper;

import com.hexcrew.entidad.Profesor;
import com.hexcrew.negocio.ServiceFacadeLocator;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Getter
@Setter
@Named("profesorHelper")
@RequestScoped
public class ProfesorHelper implements Serializable{

    @EJB
    ServiceFacadeLocator locator;

    public List<Profesor> obtenerLista()
    {
        return locator.getProfesorFacadeInstance().obtenerLista();
    }
    
    public boolean eliminarProfesor(Profesor p)
    {
        System.out.println("Profesor Eliminado: " + p.getUsuario().getNombre());
        locator.getProfesorFacadeInstance().eliminarProfesor(p);
        return true;
    }
    
    public boolean registrarProfesor(Profesor p)
    {
        locator.getProfesorFacadeInstance().guardarProfesor(p);
        return true;
    }
}
