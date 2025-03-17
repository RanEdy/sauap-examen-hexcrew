/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.facade;

import com.hexcrew.delegate.IAdministradorDelegate;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author Usuario
 */
@Stateless
public class AdministradorFacade implements IAdministradorFacade
{
    @EJB
    private IAdministradorDelegate delegate;
}
