/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una Dieta en la PERSISTENCIA y permite su SERIALIZACION
 * @author js.garcial1
 */
@Entity
public class DietaTipoEntity extends BaseEntity implements Serializable {
    
    private String objetivo;
    private String descripcion;
    /*Actuaizacion Ciclo 2*/
    private String imagen;
    private Integer stars;
    /*Actuaizacion Ciclo 2*/
 
    
    @PodamExclude
    @OneToMany( mappedBy = "dieta", cascade = CascadeType.PERSIST)
    private List<SemanaEntity> semanas = new ArrayList<>();
    
    @PodamExclude
    @ManyToOne( cascade = CascadeType.PERSIST)
    private CocinaEntity cocina;
   
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------

    /**
     * Objetivo o meta de la dieta
     * @return objetivo
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * Cambia el objetivo de la dieta
     * @param objetivo 
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Descripcion detallada de la dieta (calorias, alimentos, semanas, etc)
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripcion de la dieta
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    /**
     * Semanas, duracion de la dieta
     * @return lista de tipo Semana
     */
    public List<SemanaEntity> getSemanas() {
        return semanas;
    }

    /**
     * Cambia la lista de semanas
     * @param semanas 
     */
    public void setSemanas(List<SemanaEntity> semanas) {
        this.semanas = semanas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public CocinaEntity getCocina() {
        return cocina;
    }

    public void setCocina(CocinaEntity cocina) {
        this.cocina = cocina;
    }
   
    
    public void add_semana ( SemanaEntity sem ) {
        this.semanas.add(sem);
    }
    
    
}