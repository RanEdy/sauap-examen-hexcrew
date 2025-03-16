/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.dao;

import com.hexcrew.entidad.Usuario;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario>
{

    public UsuarioDAO()
    {
        super(Usuario.class);
    }
    
}
