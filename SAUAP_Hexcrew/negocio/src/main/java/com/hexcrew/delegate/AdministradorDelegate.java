package com.hexcrew.delegate;

import com.hexcrew.dao.AdministradorDAO;
import com.hexcrew.entidad.Administrador;
import com.hexcrew.persistencia.ServiceLocator;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class AdministradorDelegate implements IAdministradorDelegate {

    @EJB
    ServiceLocator locator;
    
    @Override
    public Administrador guardar(Administrador u) {
        //return dao.save(u);
        return locator.getAdministradorDAOInstance().save(u);
    }

    @Override
    public Administrador editar(Administrador u) {
        //return dao.update(u);
        return locator.getAdministradorDAOInstance().update(u);
    }

    @Override
    public Administrador buscar(Object id) {
        //return dao.find(id);
        return locator.getAdministradorDAOInstance().find(id);
    }

    @Override
    public void eliminar(Administrador u) {
        //dao.delete(u);
        locator.getAdministradorDAOInstance().delete(u);
    }

    @Override
    public List<Administrador> listar() {
        //return dao.findAll();
        return locator.getAdministradorDAOInstance().findAll();
    }
    
    @Override
    public Administrador obtenerAdministradorLogin(String email, String password)
    {
        //List<Administrador> administradores = dao.AdministradoresLogin(email, password);
        List<Administrador> administradores = locator.getAdministradorDAOInstance().AdministradoresLogin(email, password);
        
        return administradores.size() == 1 ? administradores.get(0) : null;
    }
    
}
