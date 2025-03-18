/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.ui;


import com.hexcrew.entidad.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import lombok.NoArgsConstructor;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Usuario
 */

@NoArgsConstructor
@Named("homeUI")
@SessionScoped
public class HomeUI implements Serializable
{
    @Inject
    private LoginUI loginUI;
    private String contenido;
    private Usuario usuarioActual;
    public Usuario getUsuarioActual() { return usuarioActual; }
    

    public void setContenido(String contenido)
    {
        this.contenido=contenido;
        PrimeFaces.current().ajax().update("contenidoPanel");
        /*
        try {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().redirect(contenido);
            } catch (IOException e) {
                System.out.println("No se pudo redirigir la pagina");
            }
        */
    }
    public String getContenido() { return contenido; }
    
    @PostConstruct
    public void Init()
    {
        System.out.println("homeUI construido");
        usuarioActual = loginUI.getUsuarioSesion();
    }
    
}
