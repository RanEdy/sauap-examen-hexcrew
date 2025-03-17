/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.facade;

import com.hexcrew.entidad.Usuario;
import jakarta.ejb.Local;

/**
 *
 * @author Usuario
 */

@Local
public interface IUsuarioFacade
{
    public Usuario getUsuarioLogin(String email, String password);
}
