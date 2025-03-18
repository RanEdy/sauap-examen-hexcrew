package com.hexcrew.dao;

import com.hexcrew.entidad.Usuario;
import jakarta.ejb.Stateless;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario>
{

    public UsuarioDAO()
    {
        super(Usuario.class);
    }
    
    public List<Usuario> usuariosLogin(String email, String password)
    {
        String jpql = "SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password";
        Map<String, Object> parametros = Map.of(
                "email", email, 
                "password", password
        );
        
        return super.executeQuery(jpql, parametros);
    }
}
