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
    public List<UnidadAprendizaje> listar() {
        return dao.findAll();
    }
    
    @Override
    public UnidadAprendizaje registrar(UnidadAprendizaje p) {
        return dao.save(p);
    }
    
    @Override
    public UnidadAprendizaje buscar(Integer id) {
        return dao.find(id);
    }
}
