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
    public List<UnidadAprendizaje> obtenerLista();
    public UnidadAprendizaje guardarUnidadAprendizaje(UnidadAprendizaje u);
    public UnidadAprendizaje buscarUnidadAprendizaje(Integer id);
}
