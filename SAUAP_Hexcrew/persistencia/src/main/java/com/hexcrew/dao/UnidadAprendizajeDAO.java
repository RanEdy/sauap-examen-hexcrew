package com.hexcrew.dao;

import com.hexcrew.entidad.UnidadAprendizaje;
import jakarta.ejb.Stateless;

/**
 * 
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class UnidadAprendizajeDAO extends AbstractDAO<UnidadAprendizaje>{

    public UnidadAprendizajeDAO()
    {
        super(UnidadAprendizaje.class);
    }
}
