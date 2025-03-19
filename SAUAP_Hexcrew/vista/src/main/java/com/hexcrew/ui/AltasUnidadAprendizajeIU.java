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
import java.util.List;
import org.primefaces.PrimeFaces;

/**
 * 
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@NoArgsConstructor
@Named("AltasUnidadAprendizajeIU")
@SessionScoped
public class AltasUnidadAprendizajeIU implements Serializable{
    
    private String nombre;
    private Integer horasClase;
    private Integer horasTaller;
    private Integer horasLab;
    
    //Campos de Registro
    private UnidadAprendizaje UnidadAprendizajeRegistrar;
    public UnidadAprendizaje getUnidadAprendizajeRegistrar() { return UnidadAprendizajeRegistrar; }
    
    
    private List<UnidadAprendizaje> listaUnidadAprendizaje;

    public List<UnidadAprendizaje> getListaUnidadAprendizaje() {
        return listaUnidadAprendizaje;
    }

    public void setListaUnidadAprendizaje(List<UnidadAprendizaje> lista) {
        listaUnidadAprendizaje = lista;
    }

    private UnidadAprendizaje UnidadAprendizajeSeleccionado;

    public UnidadAprendizaje getUnidadAprendizajeSeleccionado() {
        return UnidadAprendizajeSeleccionado;
    }

    public void setUnidadAprendizajeSeleccionado(UnidadAprendizaje u) {
        UnidadAprendizajeSeleccionado = u;
    }
    
    @Inject
    private AltasUnidadAprendizajeHelper helper;

    @PostConstruct
    public void init(){
        UnidadAprendizajeRegistrar = new UnidadAprendizaje();

        if (listaUnidadAprendizaje == null) {
            listaUnidadAprendizaje = helper.obtenerLista();
        }

        System.out.println("Unidades Bean UI creado!");
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
    
    public void registrarUnidadAprendizaje(){
        // Crear una nueva instancia si es null
        if (UnidadAprendizajeRegistrar == null) {
            UnidadAprendizajeRegistrar = new UnidadAprendizaje();
        }

        // Establecer los valores desde los campos de la UI
        UnidadAprendizajeRegistrar.setnombreunidad(nombre);
        UnidadAprendizajeRegistrar.sethorasclase(horasClase);
        UnidadAprendizajeRegistrar.sethorastaller(horasTaller);
        UnidadAprendizajeRegistrar.sethoraslab(horasLab);

        // Validar los campos
        if (nombre == null || nombre.trim().isEmpty() ||
            horasClase == null || horasTaller == null || horasLab == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN REGISTRO:", "La Unidad de Aprendizaje no cuenta con campos válidos"));
            return;
        }

        // Registrar la unidad de aprendizaje
        helper.registrarUnidadAprendizaje(UnidadAprendizajeRegistrar);

        // Actualizar la lista de unidades de aprendizaje
        listaUnidadAprendizaje = helper.obtenerLista();

        // Mostrar mensaje de éxito
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "La Unidad de Aprendizaje ha sido registrada"));

        // Actualizar la UI
        PrimeFaces.current().ajax().update("form:mensajes");
        PrimeFaces.current().executeScript("PF('form:registrarDialog').hide()");

        // Resetear los campos después de registrar
        reset();
    }
    
    public void reset() {
        System.out.println("Unidades: Método Reset llamado");
        this.nombre = null;
        this.horasClase = null;
        this.horasTaller = null;
        this.horasLab = null;
    }
}
