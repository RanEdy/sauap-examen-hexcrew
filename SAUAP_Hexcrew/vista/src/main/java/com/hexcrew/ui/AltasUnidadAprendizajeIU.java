package com.hexcrew.ui;

import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.helper.AltasUnidadAprendizajeHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Named("AltasUnidadAprendizajeIU")
@SessionScoped
public class AltasUnidadAprendizajeIU implements Serializable{
    private Integer clave;
    private String nombre;
    private Integer horasClase;
    private Integer horasTaller;
    private Integer horasLab;
    
    @Inject
    private AltasUnidadAprendizajeHelper helper;

    public Integer getClave(){
        return clave;
    }
    public void setClave(Integer clave) {
        this.clave = clave;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getHorasClase(){
        return horasClase;
    }
    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }
    
    public Integer getHorasTaller(){
        return horasTaller;
    }
    public void setHorasTaller(Integer horasTaller) {
        this.horasTaller = horasTaller;
    }
    
    public Integer getHorasLab(){
        return horasLab;
    }
    public void setHorasLab(Integer horasLab) {
        this.horasLab = horasLab;
    }
    
    public void guardar(){
        UnidadAprendizaje unidad = new UnidadAprendizaje();
        setClave(clave);
        setNombre(nombre);
        setHorasClase(horasClase);
        setHorasTaller(horasTaller);
        setHorasLab(horasLab);

        try {
            helper.guardar(unidad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unidad de Aprendizaje guardada exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar la Unidad de Aprendizaje", e.getMessage()));
        }
    }
    
    private String contenido;
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
}
