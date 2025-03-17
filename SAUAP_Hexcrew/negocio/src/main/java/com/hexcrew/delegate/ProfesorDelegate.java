/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.delegate;

import com.hexcrew.dao.ProfesorDAO;
import com.hexcrew.entidad.Profesor;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Stateless
public class ProfesorDelegate implements IProfesorDelegate
{
    @EJB
    private ProfesorDAO dao;
    
    @Override
    public List<Profesor> listar() {
        return dao.findAll();
    }
    
}
