package com.hexcrew.persistencia;

import com.hexcrew.dao.AdministradorDAO;
import com.hexcrew.dao.ProfesorDAO;
import com.hexcrew.dao.UsuarioDAO;
import com.hexcrew.dao.UnidadAprendizajeDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */
@Singleton
@Startup
@LocalBean
public class ServiceLocator {

    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private ProfesorDAO profesorDAO;
    @EJB
    private AdministradorDAO administradorDAO;
    @EJB
    private UnidadAprendizajeDAO unidadAprendizajeDAO;

    public UsuarioDAO getUsuarioDAOInstance() {
        return usuarioDAO;
    }

    public ProfesorDAO getProfesorDAOInstance() {
        return profesorDAO;
    }

    public AdministradorDAO getAdministradorDAOInstance() {
        return administradorDAO;
    }
    
    public UnidadAprendizajeDAO getUnidadAprendizajeDAOInstance() {
        return unidadAprendizajeDAO;
    }
}
