package com.hexcrew.facade;

import com.hexcrew.entidad.Usuario;
import jakarta.ejb.Local;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Local
public interface IUsuarioFacade
{
    public Usuario getUsuarioLogin(String email, String password);
}
