/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.facade;

import com.hexcrew.entidad.Profesor;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Local
public interface IProfesorFacade
{
    public List<Profesor> obtenerLista();
}
