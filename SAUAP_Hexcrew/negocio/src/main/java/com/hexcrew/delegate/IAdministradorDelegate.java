/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.delegate;

import com.hexcrew.entidad.Administrador;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Usuario
 */

@Local
public interface IAdministradorDelegate {
    public Administrador guardar(Administrador u);
    public Administrador editar(Administrador u);
    public Administrador buscar(Object id);
    public void eliminar(Administrador u);
    public List<Administrador> listar();
}
