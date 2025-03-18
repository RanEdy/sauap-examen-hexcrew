package com.hexcrew.helper;

import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.negocio.ServiceFacadeLocator;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

@Getter @Setter
@Named("AltasUnidadAprendizajeHelper")
@RequestScoped
public class AltasUnidadAprendizajeHelper implements Serializable{
    @EJB
    ServiceFacadeLocator locator;
    
    public AltasUnidadAprendizajeHelper()
    {
        System.out.println("AltasUnidadAprendizajeUI construido");
    }
    
    public UnidadAprendizaje guardar(UnidadAprendizaje u)
    {
        UnidadAprendizaje unidadAprendizaje = locator.getUnidadAprendizajeFacadeInstance().setUnidadAprendizaje(u);
        return unidadAprendizaje;
    }
}
