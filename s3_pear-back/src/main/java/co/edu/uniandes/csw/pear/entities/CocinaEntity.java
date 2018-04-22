/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una Cocina en la PERSISTENCIA y permite su SERIALIZACION
 *
 * @author js.garcial1
 */
@Entity
public class CocinaEntity extends BaseEntity implements Serializable {
    
    private String ubicacion;
    private String capacidad;
    private String imagen;
    
    @PodamExclude
    @OneToMany
    private List<DietaTipoEntity> dietas = new ArrayList<>();

//-----------------------------------------------------------
//Metodos
//-----------------------------------------------------------

    /**
     * Ubicacion, direccion de la cocina
     * @return ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Cambia la ubicacion de la cocina
     * @param ubicacion 
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Capacidad de alimentos de la cocina
     * @return capacidad
     */
    public String getCapacidad() {
        return capacidad;
    }
    
    /**
     * Cambia la capacidad de la cocina
     * @param capacidad 
     */
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Lista de Dietas que son preparadas en esta cocina
     * @return 
     */
    public List<DietaTipoEntity> getDietas() {
        return dietas;
    }

    /**
     * Cambia la lsita de dietas de la cocina
     * @param dietas 
     */
    public void setDietas(List<DietaTipoEntity> dietas) {
        this.dietas = dietas;
    } 

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
}
