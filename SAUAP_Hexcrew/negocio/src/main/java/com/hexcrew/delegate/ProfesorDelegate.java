package com.hexcrew.delegate;

import com.hexcrew.dao.ProfesorDAO;
import com.hexcrew.entidad.Profesor;
import com.hexcrew.entidad.UnidadAprendizaje;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class ProfesorDelegate implements IProfesorDelegate
{
    @EJB
    private ProfesorDAO dao;
    
    @Override
    public List<Profesor> listar() {
        return dao.findAll();
    }
    
    @Override
    public boolean eliminar(Profesor p)
    {
        Set<UnidadAprendizaje> Asignaciones = p.getUnidades();
        if(Asignaciones.isEmpty()){
            dao.delete(p);
            return true;
        }
        return false;
    }

    @Override
    public Profesor registrar(Profesor p) {
        return dao.save(p);
    }

    @Override
    public Profesor editar(Profesor p) {
        return dao.update(p);
    }

    @Override
    public Profesor buscar(Integer id) {
        return dao.find(id);
    }

}
