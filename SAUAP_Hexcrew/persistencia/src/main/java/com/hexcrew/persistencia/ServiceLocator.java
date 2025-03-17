/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.persistencia;

import com.hexcrew.dao.AdministradorDAO;
import com.hexcrew.dao.ProfesorDAO;
import com.hexcrew.dao.UsuarioDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

/**
 *
 * @author Usuario
 */
@Singleton
@Startup
@LocalBean
public class ServiceLocator {

    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private ProfesorDAO profesorDAO;
    @EJB
    private AdministradorDAO administradorDAO;

    public UsuarioDAO getUsuarioDAOInstance() {
        return usuarioDAO;
    }

    public ProfesorDAO getProfesorDAOInstance() {
        return profesorDAO;
    }

    public AdministradorDAO getAdministradorDAOInstance() {
        return administradorDAO;
    }
}
