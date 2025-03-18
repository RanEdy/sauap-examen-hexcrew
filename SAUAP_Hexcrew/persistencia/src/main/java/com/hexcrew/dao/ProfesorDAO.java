package com.hexcrew.dao;

import com.hexcrew.entidad.Profesor;
import jakarta.ejb.Stateless;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class ProfesorDAO extends AbstractDAO<Profesor>
{
    
    public ProfesorDAO()
    {
        super(Profesor.class);
    }

}
