package com.hexcrew.facade;

import com.hexcrew.delegate.IUsuarioDelegate;
import com.hexcrew.delegate.UsuarioDelegate;
import com.hexcrew.entidad.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class UsuarioFacade implements IUsuarioFacade
{
    @EJB(mappedName = "java:global/vista-1.0-SNAPSHOT/UsuarioDelegate")
    private IUsuarioDelegate delegate;
    
    
}
