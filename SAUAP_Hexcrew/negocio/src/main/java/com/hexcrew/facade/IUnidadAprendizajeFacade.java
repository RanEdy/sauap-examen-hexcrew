package com.hexcrew.facade;

import com.hexcrew.entidad.UnidadAprendizaje;
import jakarta.ejb.Local;

@Local
public interface IUnidadAprendizajeFacade {
    public UnidadAprendizaje setUnidadAprendizaje(UnidadAprendizaje u);
}
