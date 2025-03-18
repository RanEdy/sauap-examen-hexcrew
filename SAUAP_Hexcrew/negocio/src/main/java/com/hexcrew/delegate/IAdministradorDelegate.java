package com.hexcrew.delegate;

import com.hexcrew.entidad.Administrador;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Local
public interface IAdministradorDelegate {
    public Administrador guardar(Administrador u);
    public Administrador editar(Administrador u);
    public Administrador buscar(Object id);
    public void eliminar(Administrador u);
    public List<Administrador> listar();
    public Administrador obtenerAdministradorLogin(String email, String password);
}
