package com.hexcrew.ui;

import com.hexcrew.entidad.Profesor;
import com.hexcrew.entidad.UnidadAprendizaje;
import com.hexcrew.helper.UnidadesHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@NoArgsConstructor
@Named("unidadesUI")
@ViewScoped
public class UnidadesUI implements Serializable{
    
    private List<UnidadAprendizaje> listaUnidades;
    public List<UnidadAprendizaje> getListaUnidades() {return listaUnidades; }
    public void setListaUnidades(List<UnidadAprendizaje> u) { listaUnidades = u; }
    
    private UnidadAprendizaje unidadSeleccionada;
    private UnidadAprendizaje unidadRegistrar;
    
    public UnidadAprendizaje getUnidadRegistrar(){return unidadRegistrar;}
    public void setUnidadRegistrar(UnidadAprendizaje unidadRegistrar ){this.unidadRegistrar = unidadRegistrar;}
    
    private Set<Profesor> listaProfesores;
    private Integer numProfesor;
    
    public Set<Profesor> getListaProfesores(){
        return listaProfesores;
    }
    
    public void setListaProfesores(Set<Profesor> listaProfesores){
        this.listaProfesores =  listaProfesores;
    }
    
    public Integer getNumProfesor(){
        return numProfesor;
    }
    
    public void setNumProfesor(Integer numProfesor){
        this.numProfesor =  numProfesor;
    }
    
    
    public UnidadAprendizaje getUnidadSeleccionada(){
        return unidadSeleccionada;
    }
    
    public void setUnidadSeleccionada(UnidadAprendizaje unidadSeleccionada){
        this.unidadSeleccionada = unidadSeleccionada;
    }
    
    @Inject
    private UnidadesHelper helper;

    @PostConstruct
    public void init()
    {
        System.out.println("Unidades Bean UI creado!");
        unidadSeleccionada = new UnidadAprendizaje();
        unidadRegistrar = new UnidadAprendizaje();
        numProfesor = 0;
        
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

        listaProfesores = unidadSeleccionada.getProfesores();
        
        System.out.println("Unidad seleccionada: " 
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
    
    public void remover(Profesor profe)
    {
        if(helper.remover(profe, unidadSeleccionada))
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Profesor Removido")); 
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR AL REMOVER PROFESOR:", "El profesor o la unidad no son validos"));
        }
    }
    
    public void asignarProfesor(){
        System.out.println("UnidadesUI[124]: asignarProfesor llamada ");
        //Validar que no sea repetido
        if(helper.validarProfesor(numProfesor, unidadSeleccionada)){
            //Validar que exista
            if(helper.asignarProfesor(numProfesor, unidadSeleccionada)){
                listaProfesores = unidadSeleccionada.getProfesores();
                
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Asignacion exitosa")); 
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN ASIGNACION:", "El profesor no existe"));
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN ASIGNACION:", "El profesor ya estaba asignado"));
        }
    }
}
