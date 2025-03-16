/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hexcrew.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Erandi
 */

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="usuario")
public class Usuario implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idusuario")
    Integer idUsuario;
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    
    @Column(name="rfc")
    String rfc;
    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }
    
    @Column(name="email")
    String email;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Column(name="password")
    String password;
    public String getPassword() { return password; }
    public void setPassword(String nombre) { this.password = password; }
    
    @Column(name="nombre")
    String nombre;
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    @Column(name="apellido")
    String apellido;
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
     
}
