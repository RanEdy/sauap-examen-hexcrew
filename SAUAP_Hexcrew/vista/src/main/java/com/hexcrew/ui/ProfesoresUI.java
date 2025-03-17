/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.ui;

import com.hexcrew.entidad.Profesor;
import com.hexcrew.helper.ProfesorHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author charl
 */
@Getter @Setter
@NoArgsConstructor
@Named("profesoresUI")
@ViewScoped
public class ProfesoresUI implements Serializable {
    private List<Profesor> listaProfesores;
    public List<Profesor> getListaProfesores() { return listaProfesores; }
    public void setListaProfesores(List<Profesor> lista) { listaProfesores = lista; }
    
    @Inject
    private ProfesorHelper helper;
    
    @PostConstruct
    public void init(){
        listaProfesores = helper.obtenerLista();
    }
    
}
