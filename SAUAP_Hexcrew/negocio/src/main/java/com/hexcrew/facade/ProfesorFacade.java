/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.facade;

import com.hexcrew.delegate.IProfesorDelegate;
import com.hexcrew.entidad.Profesor;
import com.hexcrew.facade.IProfesorFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Stateless
public class ProfesorFacade implements IProfesorFacade
{
    @EJB
    private IProfesorDelegate delegate;
    
    @Override
    public List<Profesor> obtenerLista(){
        return delegate.listar();
    }
}
