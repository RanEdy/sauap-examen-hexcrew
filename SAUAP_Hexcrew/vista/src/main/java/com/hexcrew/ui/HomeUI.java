/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.ui;

import com.hexcrew.entidad.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import lombok.NoArgsConstructor;

/**
 *
 * @author Usuario
 */

@NoArgsConstructor
@Named("homeUI")
@ViewScoped
public class HomeUI implements Serializable
{
    @Inject
    private LoginUI loginUI;
    
    private Usuario usuarioActual;
    public Usuario getUsuarioActual() { return usuarioActual; }
    
    private String contenido;
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    
    @PostConstruct
    public void Init()
    {
        System.out.println("homeUI construido");
        contenido = "";
        if (loginUI != null)
        {
            usuarioActual = loginUI.getUsuarioSesion();
            System.out.println("Usuario obtenido: " + usuarioActual.getEmail() + " | " + usuarioActual.getNombre());
        }
    }
    
}
