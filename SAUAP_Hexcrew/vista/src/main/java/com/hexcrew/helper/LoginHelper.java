/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.helper;

import com.hexcrew.entidad.Usuario;
import com.hexcrew.negocio.ServiceFacadeLocator;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Erandi
 */
@Getter @Setter
@Named("loginHelper")
@RequestScoped
public class LoginHelper implements Serializable
{
    @EJB
    ServiceFacadeLocator locator;
    
    public LoginHelper()
    {
        System.out.println("loginUI construido");
    }
    
    public Usuario iniciarSesion(String email, String password)
    {
        Usuario usuario = locator.getUsuarioFacadeInstance().getUsuarioLogin(email, password);
        return usuario;
    }
    
}
