package com.hexcrew.facade;

import com.hexcrew.entidad.Profesor;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */
@Local
public interface IProfesorFacade
{
    public List<Profesor> obtenerLista();
    public boolean eliminarProfesor(Profesor p);
    public Profesor guardarProfesor(Profesor p);
    public Profesor editarProfesor(Profesor p);
    public Profesor buscarProfesor(Integer id);
}
