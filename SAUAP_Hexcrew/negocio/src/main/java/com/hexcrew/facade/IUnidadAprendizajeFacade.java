package com.hexcrew.facade;

import com.hexcrew.entidad.UnidadAprendizaje;
import jakarta.ejb.Local;
import java.util.List;

/**
 * 
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Local
public interface IUnidadAprendizajeFacade {
    public UnidadAprendizaje setUnidadAprendizaje(UnidadAprendizaje u);
    
    public List<UnidadAprendizaje> obtenerListaUnidades();
    public boolean validarClaveUnidad(Integer clave);
}
