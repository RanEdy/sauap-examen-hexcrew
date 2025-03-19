package com.hexcrew.delegate;

import com.hexcrew.dao.AdministradorDAO;
import com.hexcrew.dao.ProfesorDAO;
import com.hexcrew.dao.UsuarioDAO;
import com.hexcrew.entidad.Administrador;
import com.hexcrew.entidad.Profesor;
import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.persistencia.ServiceLocator;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel
 * Villagomez
 */
@Stateless
public class ProfesorDelegate implements IProfesorDelegate {

    @EJB
    ServiceLocator locator;

    @Override
    public List<Profesor> listar() {
        //return dao.findAll();
        return locator.getProfesorDAOInstance().findAll();
    }

    @Override
    public boolean eliminar(Profesor p) {
        //Validar que no tenga unidades asignadas
        Set<UnidadAprendizaje> Asignaciones = p.getUnidades();

        if (Asignaciones.isEmpty()) {
            locator.getProfesorDAOInstance().delete(p);
            //dao.delete(p);
            
            List<Administrador> administradores = locator.getAdministradorDAOInstance().findAll();
            for (Administrador admin : administradores) {
                if (!admin.getIdUsuario().equals(p.getIdUsuario())) {
                    locator.getUsuarioDAOInstance().delete(p.getUsuario());
                    //usuariodao.delete(p.getUsuario());
                    break;
                }
            }
            return true;
        }

        return false;

    }

    @Override
    public Profesor registrar(Profesor p) {
        //List<Profesor> profesores = dao.findAll();
        List<Profesor> profesores = locator.getProfesorDAOInstance().findAll();
        for (Profesor profe : profesores) {
            if (profe.getNumProfesor().equals(p.getNumProfesor())) {
                return null;
            }
        }
        //return dao.save(p);
        return locator.getProfesorDAOInstance().save(p);
    }

    @Override
    public Profesor editar(Profesor p) {
        //return dao.update(p);
        return locator.getProfesorDAOInstance().update(p);
    }

    @Override
    public Profesor buscar(Integer id) {
        //return dao.find(id);
        return locator.getProfesorDAOInstance().find(id);
    }

}
