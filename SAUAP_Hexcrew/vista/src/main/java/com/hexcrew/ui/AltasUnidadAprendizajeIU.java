package com.hexcrew.ui;

import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.helper.AltasUnidadAprendizajeHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@NoArgsConstructor
@Named("unidadesUI")
@ViewScoped
public class AltasUnidadAprendizajeIU implements Serializable{
    
    private String nombre;
    private Integer horasClase;
    private Integer horasTaller;
    private Integer horasLab;
    
    private List<UnidadAprendizaje> listaUnidades;
    public List<UnidadAprendizaje> getListaUnidades() {return listaUnidades; }
    public void setListaUnidades(List<UnidadAprendizaje> u) { listaUnidades = u; }
    
    private UnidadAprendizaje unidadSeleccionada;
    
    public UnidadAprendizaje getUnidadSeleccionada(){
        return unidadSeleccionada;
    }
    
    public void setUnidadSeleccionada(UnidadAprendizaje unidadSeleccionada){
        this.unidadSeleccionada = unidadSeleccionada;
    }
    
    @Inject
    private AltasUnidadAprendizajeHelper helper;

    @PostConstruct
    public void init()
    {
        System.out.println("Unidades Bean UI creado!");
        
        if (listaUnidades == null) {
            listaUnidades = helper.obtenerListaUnidades();
        }
        
        if (listaUnidades != null && !listaUnidades.isEmpty()) {
            listaUnidades.sort(Comparator.comparing(p -> p.getnombreunidad()));
        }
        
        System.out.println("profesoresUI Bean Creado!");
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
        System.out.println("Unidades: Metodo Guardar llamado");
        UnidadAprendizaje unidad = new UnidadAprendizaje();
       
        unidad.setnombreunidad(nombre);
        unidad.sethorasclase(horasClase);
        unidad.sethorastaller(horasTaller);
        unidad.sethoraslab(horasLab);

        try {
            helper.guardar(unidad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unidad de Aprendizaje guardada exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar la Unidad de Aprendizaje", e.getMessage()));
        }
    }
    
    public void seleccionarUnidad(UnidadAprendizaje unidad) {
        this.unidadSeleccionada = unidad;
        // Para eliminar o para consultar
        System.out.println("Profesor seleccionado: " 
                + (unidad != null ? unidad.getnombreunidad(): "NULL"));
    }
}
