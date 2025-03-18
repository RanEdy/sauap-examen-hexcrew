package com.hexcrew.dao;

import com.hexcrew.entidad.Administrador;
import jakarta.ejb.Stateless;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class AdministradorDAO extends AbstractDAO<Administrador> {
    
    public AdministradorDAO() {
        super(Administrador.class);
    }
    
    public List<Administrador> AdministradoresLogin(String email, String password)
    {
        String jpql = "SELECT a FROM Administrador a WHERE a.usuario.email = :email AND a.usuario.password = :password";
        Map<String, Object> parametros = Map.of(
                "email", email, 
                "password", password
        );
        
        return super.executeQuery(jpql, parametros);
    }
}
