package com.hexcrew.facade;

import com.hexcrew.entidad.Administrador;
import jakarta.ejb.Local;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */
@Local
public interface IAdministradorFacade
{
    public Administrador getAdministradorLogin(String email, String password);
}
