/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.dao;

import com.hexcrew.entidad.Administrador;
import jakarta.ejb.Stateless;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Stateless
public class AdministradorDAO extends AbstractDAO<Administrador> {
    
    public AdministradorDAO() {
        super(Administrador.class);
    }
    
}
