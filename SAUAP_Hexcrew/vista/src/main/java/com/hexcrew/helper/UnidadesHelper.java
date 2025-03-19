package com.hexcrew.helper;

import com.hexcrew.entidad.Profesor;
import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.negocio.ServiceFacadeLocator;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel
 * Villagomez
 */
@Getter
@Setter
@Named("AltasUnidadAprendizajeHelper")
@RequestScoped
public class UnidadesHelper implements Serializable {

    @EJB
    ServiceFacadeLocator locator;

    public UnidadesHelper() {
        System.out.println("AltasUnidadAprendizajeUI construido");
    }

    public UnidadAprendizaje guardar(UnidadAprendizaje u) {
        UnidadAprendizaje unidadAprendizaje = locator.getUnidadAprendizajeFacadeInstance().setUnidadAprendizaje(u);
        return unidadAprendizaje;
    }

    public List<UnidadAprendizaje> obtenerListaUnidades()
    {
        return locator.getUnidadAprendizajeFacadeInstance().obtenerListaUnidades();
    }
    
    public boolean registrarUnidad(UnidadAprendizaje u){
        boolean validacion = locator.getUnidadAprendizajeFacadeInstance().validarClaveUnidad(u.getclaveunidadaprendizaje());
        if (validacion)
        {
            locator.getUnidadAprendizajeFacadeInstance().setUnidadAprendizaje(u);
        }
        return validacion;
    }
    
    public boolean remover(Profesor profe, UnidadAprendizaje unidad)
    {
        if(profe==null || unidad==null) return false;
        
        System.out.println("Profesor removido");
        profe.removeUnidadAprendizaje(unidad);
        locator.getProfesorFacadeInstance().editarProfesor(profe);
        return true;
    }
    
    public boolean asignarProfesor(Integer numProfesor, UnidadAprendizaje unidad){
        Profesor seleccionado = null;
        
        //Buscar en todos los profesores para obtener el profesor que coincida con el numero
        List<Profesor> listaProfesores = locator.getProfesorFacadeInstance().obtenerLista();
        
        System.out.println("========================= Buscando Profesores: =========================");
        System.out.println("Numero recibido: " + numProfesor);
        
        for (Profesor actual : listaProfesores){
            System.out.println("Num Profe: " + actual.getNumProfesor());
            
            if(actual.getNumProfesor().equals(numProfesor)){
                System.out.println("UnidadesHelper[62]: profesor obtenido ");
                seleccionado = actual;
                break;
            }
        }
        
        if(seleccionado != null){
            System.out.println("UnidadesHelper[69]: profesor asignado ");
            seleccionado.addUnidadAprendizaje(unidad);
            locator.getProfesorFacadeInstance().editarProfesor(seleccionado);
            return true;
        } 
            return false;      
    }
    
    public boolean validarProfesor(Integer numProfesor, UnidadAprendizaje unidad){
        Set<Profesor> listaProfesores = unidad.getProfesores();
        
        for (Profesor actual : listaProfesores){
            if(actual.getNumProfesor().equals(numProfesor)){
                return false;
            }
        }
        return true;
    }
    
}
