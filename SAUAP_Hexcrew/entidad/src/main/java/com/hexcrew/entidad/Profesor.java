package com.hexcrew.entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luis Aponte, Enrique Gudiño, Erandi Moreno, Xavier Ortiz y Angel Villagomez 
 */

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name ="profesor")
public class Profesor implements Serializable
{
    @Id
    private Integer idUsuario;
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    
    @Column(name="numprofesor")
    private Integer numProfesor;
    public Integer getNumProfesor() { return numProfesor; }
    public void setNumProfesor(Integer numProfesor) { this.numProfesor = numProfesor; }
    
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
