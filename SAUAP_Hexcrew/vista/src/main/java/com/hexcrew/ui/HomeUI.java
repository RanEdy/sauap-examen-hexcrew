package com.hexcrew.ui;

import com.hexcrew.entidad.Administrador;
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
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@NoArgsConstructor
@Named("homeUI")
@SessionScoped
public class HomeUI implements Serializable
{
    @Inject
    private LoginUI loginUI;
    private String contenido;
    private Administrador usuarioActual;
    public Administrador getUsuarioActual() { return usuarioActual; }
    

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
        usuarioActual = loginUI.getAdministradorSesion();
    }
    
}
