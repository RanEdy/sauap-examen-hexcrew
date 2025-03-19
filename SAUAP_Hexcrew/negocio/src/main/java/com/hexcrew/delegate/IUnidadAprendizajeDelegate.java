package com.hexcrew.delegate;

import com.hexcrew.entidad.UnidadAprendizaje;
import jakarta.ejb.Local;
import java.util.List;

/**
 * 
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Local
public interface IUnidadAprendizajeDelegate {
    public List<UnidadAprendizaje> listar();
    public UnidadAprendizaje registrar(UnidadAprendizaje u);
    public UnidadAprendizaje buscar(Integer id);
}
