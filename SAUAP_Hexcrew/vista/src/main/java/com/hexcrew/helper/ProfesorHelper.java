/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.helper;

import com.hexcrew.entidad.Profesor;
import com.hexcrew.negocio.ServiceFacadeLocator;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author charl
 */
@Getter
@Setter
@Named("profesorHelper")
@RequestScoped
public class ProfesorHelper implements Serializable{

    @EJB
    ServiceFacadeLocator locator;

    public List<Profesor> obtenerLista()
    {
        return locator.getProfesorFacadeInstance().obtenerLista();
    }
}
