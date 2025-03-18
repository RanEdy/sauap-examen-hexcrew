package com.hexcrew.ui;

import com.hexcrew.entidad.Usuario;
import com.hexcrew.helper.LoginHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import lombok.NoArgsConstructor;

/**
 *
 * @author Erandi
 */
@NoArgsConstructor
@Named("loginUI")
@SessionScoped
public class LoginUI implements Serializable {

    @Inject
    private LoginHelper helper;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Usuario usuarioSesion;
    public Usuario getUsuarioSesion() { return usuarioSesion; }
    @PostConstruct
    public void Init() {
        System.out.println("loginUI construido");
        resetFields();
    }

    public void resetFields() {
        email = "";
        password = "";
    }

    public void iniciarSesion() {
        usuarioSesion = helper.iniciarSesion(email, password);
        if (usuarioSesion != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Sesion Iniciada"));
            resetFields();
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().redirect("index.xhtml");
            } catch (IOException e) {
                System.out.println("No se pudo redirigir la pagina");
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Usuario no encontrado"));
            resetFields();
        }
    }

}
