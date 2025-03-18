package com.hexcrew.entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name ="unidadaprendizaje")

public class UnidadAprendizaje implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="claveunidadaprendizaje")
    Integer claveunidadaprendizaje;
    public Integer getclaveunidadaprendizaje() { return claveunidadaprendizaje; }
    public void setclaveunidadaprendizaje(Integer claveunidadaprendizaje) { this.claveunidadaprendizaje = claveunidadaprendizaje; }
    
    @Column(name="nombreunidad")
    String nombreunidad;
    public String getnombreunidad() { return nombreunidad; }
    public void setnombreunidad(String nombreunidad) { this.nombreunidad = nombreunidad; }
    
    @Column(name="horasclase")
    Integer horasclase;
    public Integer gethorasclase() { return horasclase; }
    public void sethorasclase(Integer horasclase) { this.horasclase = horasclase; }
    
    @Column(name="horastaller")
    Integer horastaller;
    public Integer gethorastaller() { return horastaller; }
    public void sethorastaller(Integer horastaller) { this.horastaller = horastaller; }
    
    @Column(name="horaslab")
    Integer horaslab;
    public Integer gethoraslab() { return horaslab; }
    public void sethoraslab(Integer horaslab) { this.horaslab = horaslab; }
}
