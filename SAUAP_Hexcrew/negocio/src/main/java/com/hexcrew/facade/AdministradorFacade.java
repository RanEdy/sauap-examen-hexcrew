package com.hexcrew.facade;

import com.hexcrew.delegate.IAdministradorDelegate;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */
@Stateless
public class AdministradorFacade implements IAdministradorFacade
{
    @EJB
    private IAdministradorDelegate delegate;
}
