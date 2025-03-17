package com.hexcrew.delegate;

import com.hexcrew.entidad.UnidadAprendizaje;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface IUnidadAprendizajeDelegate {
    UnidadAprendizaje guardar(UnidadAprendizaje u);
    UnidadAprendizaje editar(UnidadAprendizaje u);
    UnidadAprendizaje buscar(Object id);
    void eliminar(UnidadAprendizaje u);
    List<UnidadAprendizaje> listar();
}
