package com.hexcrew.delegate;

import com.hexcrew.dao.UnidadAprendizajeDAO;
import com.hexcrew.entidad.UnidadAprendizaje;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 * 
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class UnidadAprendizajeDelegate implements IUnidadAprendizajeDelegate{
    @EJB
    private UnidadAprendizajeDAO dao;
    
    @Override
    public UnidadAprendizaje guardar(UnidadAprendizaje u) {
        return dao.save(u);
    }

    @Override
    public UnidadAprendizaje editar(UnidadAprendizaje u) {
        return dao.update(u);
    }

    @Override
    public UnidadAprendizaje buscar(Object id) {
        return dao.find(id);
    }

    @Override
    public void eliminar(UnidadAprendizaje u) {
        dao.delete(u);
    }

    @Override
    public List<UnidadAprendizaje> listar() {
        return dao.findAll();
    }

    @Override
    public boolean validarClave(Integer clave) {
        List<UnidadAprendizaje> unidades = dao.findAll();
        for (UnidadAprendizaje unidad : unidades)
        {
            if (unidad.getclaveunidadaprendizaje().equals(clave)) 
            {
                return false;
            }
        }
        return true;
    }
}
