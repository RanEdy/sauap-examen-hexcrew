package com.hexcrew.dao;

import com.hexcrew.entidad.UnidadAprendizaje;
import jakarta.ejb.Stateless;

@Stateless
public class UnidadAprendizajeDAO extends AbstractDAO<UnidadAprendizaje>{

    public UnidadAprendizajeDAO()
    {
        super(UnidadAprendizaje.class);
    }
}
