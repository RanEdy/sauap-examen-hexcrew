/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.delegate;

import com.hexcrew.entidad.Usuario;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Local
public interface IUsuarioDelegate
{
    public Usuario guardar(Usuario u);
    public Usuario editar(Usuario u);
    public Usuario buscar(Object id);
    public void eliminar(Usuario u);
    public List<Usuario> listar();
}
