/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa la entidad de una Cocina
 *
 * @author js.garcial1
 */
public class CocinaEntity extends BaseEntity implements Serializable {
    
    private String ubicacion;

    private String capacidad;
    
    private List<DietaTipoEntity> dietas;

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
    public void setDieta(List<DietaTipoEntity> dietas) {
        this.dietas = dietas;
    } 
    
}
