package com.hexcrew.dao;

import com.hexcrew.entidad.Administrador;
import jakarta.ejb.Stateless;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class AdministradorDAO extends AbstractDAO<Administrador> {
    
    public AdministradorDAO() {
        super(Administrador.class);
    }
    
}
