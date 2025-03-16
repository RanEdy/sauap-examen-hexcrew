/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.helper;

import com.hexcrew.delegate.IUsuarioDelegate;
import com.hexcrew.delegate.UsuarioDelegate;
import com.hexcrew.entidad.Usuario;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Usuario
 */
@Getter @Setter
@Named(value="usuarioHelper")
@ViewScoped
public class UsuarioHelper implements Serializable
{
    @EJB
    IUsuarioDelegate uDelegate;
    
    private Usuario usuario;
    
    public void nuevo()
    {
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() { return usuario; }
    
    public void save()
    {
        if (usuario.getIdUsuario() == null)
        {
            uDelegate.guardar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Registrado"));
        }
        else
        {
            uDelegate.editar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Editado"));
        }
        nuevo();
        PrimeFaces.current().executeScript("PF('usuarioRegistroDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages");
    }
}
