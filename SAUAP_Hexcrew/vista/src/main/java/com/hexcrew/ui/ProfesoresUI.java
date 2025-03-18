package com.hexcrew.ui;

import com.hexcrew.entidad.Profesor;
import com.hexcrew.entidad.Usuario;
import com.hexcrew.helper.ProfesorHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.primefaces.model.SortOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.model.SortMeta;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@Getter
@Setter
@NoArgsConstructor
@Named("profesoresUI")
@ViewScoped
public class ProfesoresUI implements Serializable {

    //Campos de Registro
    private Profesor profesorRegistrar;
    public Profesor getProfesorRegistrar() { return profesorRegistrar; }
    
    
    private List<Profesor> listaProfesores;

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> lista) {
        listaProfesores = lista;
    }

    private Profesor profesorSeleccionado;

    public Profesor getProfesorSeleccionado() {
        return profesorSeleccionado;
    }

    public void setProfesorSeleccionado(Profesor p) {
        profesorSeleccionado = p;
    }

    @Inject
    private ProfesorHelper helper;

    @PostConstruct
    public void init() {
        profesorRegistrar = new Profesor();
        profesorRegistrar.setUsuario(new Usuario());
        
        if (listaProfesores == null) {
            listaProfesores = helper.obtenerLista();
        }

        //Ordenar la lista
        if (listaProfesores != null && !listaProfesores.isEmpty()) {
            listaProfesores.sort(Comparator.comparing(p -> p.getUsuario().getNombre()));
        }
        System.out.println("profesoresUI Bean Creado!");
    }

    
    public void registrarProfesor()
    {
        if (profesorRegistrar == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN REGISTRO:", "El profesor no cuenta con campos validos"));
            return;
        }
        if (profesorRegistrar.getUsuario() == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN REGISTRO:", "El profesor no cuenta con campos validos"));
            return;
        }
        Usuario u = profesorRegistrar.getUsuario();
        if (u.getNombre() == ""
                || u.getApellido() == ""
                || u.getEmail() == ""
                || u.getPassword() == ""
                || u.getRfc() == ""
                ||
                profesorRegistrar.getNumProfesor() == null)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN REGISTRO:", "Campos no validos"));
            return;
        }
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "El profesor ha sido registrado"));
        PrimeFaces.current().ajax().update("form:mensajes");
        PrimeFaces.current().executeScript("PF('form:registrarDialog').hide()");
        
        helper.registrarProfesor(profesorRegistrar);
        listaProfesores = helper.obtenerLista();
    }
    
    public void seleccionarProfesor(Profesor profesor) {
        this.profesorSeleccionado = profesor;
        // Para eliminar o para consultar
        System.out.println("Profesor seleccionado: " 
                + (profesor != null ? profesor.getUsuario().getNombre() : "NULL"));
    }

   
    public void eliminarProfesor() {
        try {
            if (profesorSeleccionado == null) {
                System.out.println("ERROR: Profesor seleccionado es NULL");
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se seleccionó ningún profesor"));
                return;
            }
            if (helper.eliminarProfesor(profesorSeleccionado)) {
                listaProfesores.remove(profesorSeleccionado);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación exitosa", "El profesor ha sido eliminado"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminación fallida", "El profesor tiene unidades asignadas"));
            }
        } catch (Exception e) {
            System.out.println("EXCEPCIÓN AL ELIMINAR: " + e.getMessage());
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error inesperado: " + e.getMessage()));
        }
        
        
    }

}
