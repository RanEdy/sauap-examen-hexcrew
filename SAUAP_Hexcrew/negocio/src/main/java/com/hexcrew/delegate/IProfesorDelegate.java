package com.hexcrew.delegate;

import com.hexcrew.entidad.Profesor;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Usuario
 */

@Local
public interface IProfesorDelegate
{
    public List<Profesor> listar();
}
