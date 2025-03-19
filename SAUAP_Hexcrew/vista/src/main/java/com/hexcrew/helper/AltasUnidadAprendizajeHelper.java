package com.hexcrew.helper;

import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.negocio.ServiceFacadeLocator;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * 
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Getter @Setter
@Named("AltasUnidadAprendizajeHelper")
@RequestScoped
public class AltasUnidadAprendizajeHelper implements Serializable{
    @EJB
    ServiceFacadeLocator locator;
    
    public List<UnidadAprendizaje> obtenerLista()
    {
        return locator.getUnidadAprendizajeFacadeInstance().obtenerLista();
    }
    
    public boolean registrarUnidadAprendizaje(UnidadAprendizaje u)
    {
        locator.getUnidadAprendizajeFacadeInstance().guardarUnidadAprendizaje(u);
        return true;
    }
}
