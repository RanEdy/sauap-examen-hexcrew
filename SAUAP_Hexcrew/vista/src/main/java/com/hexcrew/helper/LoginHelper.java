package com.hexcrew.helper;

import com.hexcrew.entidad.Administrador;
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
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
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
    
    public Administrador iniciarSesion(String email, String password)
    {
        Administrador admin = locator.getAdministradorFacadeInstance().getAdministradorLogin(email, password);
        return admin;
    }
    
}
