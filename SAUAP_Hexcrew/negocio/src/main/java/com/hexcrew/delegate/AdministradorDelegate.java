/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.delegate;

import com.hexcrew.dao.AdministradorDAO;
import com.hexcrew.entidad.Administrador;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Stateless
public class AdministradorDelegate implements IAdministradorDelegate {

    @EJB
    private AdministradorDAO dao;
    
    @Override
    public Administrador guardar(Administrador u) {
        return dao.save(u);
    }

    @Override
    public Administrador editar(Administrador u) {
        return dao.update(u);
    }

    @Override
    public Administrador buscar(Object id) {
        return dao.find(id);
    }

    @Override
    public void eliminar(Administrador u) {
        dao.delete(u);
    }

    @Override
    public List<Administrador> listar() {
        return dao.findAll();
    }
    
}
