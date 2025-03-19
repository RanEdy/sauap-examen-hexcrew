package com.hexcrew.delegate;

import com.hexcrew.dao.UnidadAprendizajeDAO;
import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.persistencia.ServiceLocator;
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
    ServiceLocator locator;
    
    @Override
    public UnidadAprendizaje guardar(UnidadAprendizaje u) {
        //return dao.save(u);
        return locator.getUnidadAprendizajeDAOInstance().save(u);
    }

    @Override
    public UnidadAprendizaje editar(UnidadAprendizaje u) {
        //return dao.update(u);
        return locator.getUnidadAprendizajeDAOInstance().update(u);
    }

    @Override
    public UnidadAprendizaje buscar(Object id) {
        //return dao.find(id);
        return locator.getUnidadAprendizajeDAOInstance().find(id);
    }

    @Override
    public void eliminar(UnidadAprendizaje u) {
        //dao.delete(u);
        locator.getUnidadAprendizajeDAOInstance().delete(u);
    }

    @Override
    public List<UnidadAprendizaje> listar() {
        //return dao.findAll();
        return locator.getUnidadAprendizajeDAOInstance().findAll();
    }

    @Override
    public boolean validarClave(Integer clave) {
        //List<UnidadAprendizaje> unidades = dao.findAll();
        List<UnidadAprendizaje> unidades = locator.getUnidadAprendizajeDAOInstance().findAll();
        
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
