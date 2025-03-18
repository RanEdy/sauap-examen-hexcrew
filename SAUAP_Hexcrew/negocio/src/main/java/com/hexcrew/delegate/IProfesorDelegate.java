package com.hexcrew.delegate;

import com.hexcrew.entidad.Profesor;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Local
public interface IProfesorDelegate
{
    public List<Profesor> listar();
    public void eliminar(Profesor p);
    public Profesor registrar(Profesor p);
}
