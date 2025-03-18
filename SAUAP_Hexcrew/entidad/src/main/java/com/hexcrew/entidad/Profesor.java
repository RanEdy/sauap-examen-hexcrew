package com.hexcrew.entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
    
    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="asignacion", joinColumns= @JoinColumn(name="idprofe"), inverseJoinColumns = @JoinColumn(name="idunidad"))
    private Set<UnidadAprendizaje> unidades = new HashSet<>();
    public Set<UnidadAprendizaje> getUnidades() { return unidades; }
    public void setUnidades(Set<UnidadAprendizaje> unidades) { this.unidades = unidades; }
    
    public void addUnidadAprendizaje(UnidadAprendizaje unidad)
    {
        this.unidades.add(unidad);
        unidad.getProfesores().add(this);
    }
    
    public void removeUnidadAprendizaje(UnidadAprendizaje unidad)
    {
        this.unidades.remove(unidad);
        unidad.getProfesores().remove(this);
    }
}
