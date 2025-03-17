package com.hexcrew.negocio;

import com.hexcrew.facade.AdministradorFacade;
import com.hexcrew.facade.IAdministradorFacade;
import com.hexcrew.facade.IProfesorFacade;
import com.hexcrew.facade.IUsuarioFacade;
import com.hexcrew.facade.ProfesorFacade;
import com.hexcrew.facade.UsuarioFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

/**
 *
 * @author Usuario
 */
@Singleton
@Startup
@LocalBean
public class ServiceFacadeLocator
{
    @EJB
    private IUsuarioFacade usuarioFacade;
    @EJB
    private IProfesorFacade profesorFacade;
    @EJB
    private IAdministradorFacade administradorFacade;
    
    public IUsuarioFacade getUsuarioFacadeInstance() { return usuarioFacade; }
    public IProfesorFacade getProfesorFacadeInstance() { return profesorFacade; }
    public IAdministradorFacade getAdministradorFacadeInstance() { return administradorFacade; }
}
