package com.hexcrew.facade;

import com.hexcrew.delegate.IUsuarioDelegate;
import com.hexcrew.delegate.UsuarioDelegate;
import com.hexcrew.entidad.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioFacade implements IUsuarioFacade
{
    @EJB(mappedName = "java:global/vista-1.0-SNAPSHOT/UsuarioDelegate")
    private IUsuarioDelegate delegate;
    
    @Override
    public Usuario getUsuarioLogin(String email, String password)
    {
        return delegate.obtenerUsuarioLogin(email, password);
    }
}
