package com.hexcrew.ui;

import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.helper.AltasUnidadAprendizajeHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
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
    
    private List<UnidadAprendizaje> listaUnidades;
    public List<UnidadAprendizaje> getListaUnidades() {return listaUnidades; }
    public void setListaUnidades(List<UnidadAprendizaje> u) { listaUnidades = u; }
    
    private UnidadAprendizaje unidadSeleccionada;
    private UnidadAprendizaje unidadRegistrar;
    
    public UnidadAprendizaje getUnidadRegistrar(){return unidadRegistrar;}
    public void setUnidadRegistrar(UnidadAprendizaje unidadRegistrar ){this.unidadRegistrar = unidadRegistrar;}
    
    
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
        unidadSeleccionada = new UnidadAprendizaje();
        unidadRegistrar = new UnidadAprendizaje();
        
        if (listaUnidades == null) {
            listaUnidades = helper.obtenerListaUnidades();
        }
        
        if (listaUnidades != null && !listaUnidades.isEmpty()) {
            listaUnidades.sort(Comparator.comparing(p -> p.getnombreunidad()));
        }
        
        System.out.println("profesoresUI Bean Creado!");
    }
    
    
    public void seleccionarUnidad(UnidadAprendizaje unidad) {
        this.unidadSeleccionada = unidad;
        // Para eliminar o para consultar
        System.out.println("Profesor seleccionado: " 
                + (unidad != null ? unidad.getnombreunidad(): "NULL"));
    }
    
    public void registrarUnidad()
    {
        System.out.println("UnidadAprendizaje: ");
        System.out.println("Nombre: " + unidadRegistrar.getnombreunidad());
        System.out.println("Clave: " + unidadRegistrar.getclaveunidadaprendizaje());
        System.out.println("Horas Clase: " + unidadRegistrar.gethorasclase());
        System.out.println("Horas Taller: " + unidadRegistrar.gethorastaller());
        System.out.println("Horas Laboratorio: " + unidadRegistrar.gethoraslab());
        System.out.println("Prueba 1.1");
        boolean valor = helper.registrarUnidad(unidadRegistrar);
        System.out.println(valor);
        if (valor)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Unidad de Aprendizaje registrada exitosamente"));
            listaUnidades = helper.obtenerListaUnidades();
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Unidad de Aprendizaje no se pudo registrar"));
        }
        
    }
}
