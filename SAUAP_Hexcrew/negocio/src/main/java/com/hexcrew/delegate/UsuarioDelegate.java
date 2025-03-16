/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.delegate;

import com.hexcrew.dao.UsuarioDAO;
import com.hexcrew.entidad.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioDelegate implements IUsuarioDelegate
{
    @EJB
    UsuarioDAO dao;
    
    public Usuario guardar(Usuario u)
    {
        return dao.save(u);
    }
    
    public Usuario editar(Usuario u)
    {
        return dao.update(u);
    }
    
    public List<Usuario> listar()
    {
        return dao.findAll();
    }

    @Override
    public Usuario buscar(Object id) {
        return dao.find(id);
    }

    @Override
    public void eliminar(Usuario u) {
        dao.delete(u);
    }
}
