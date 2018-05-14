/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ga.bejarano10
 */
@Entity
public class CalificacionEntity extends BaseEntity implements Serializable
{
    private Integer puntuacion;

    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private DietaTipoEntity dieta;
    /**
     * 
     * @return puntuacion. 
     */
    public Integer getPuntuacion() {
        return puntuacion;
    }

    /**
     * 
     * @param puntuacion 
     */
    public void setPuntuacion(Integer puntuacion)
    {
        this.puntuacion = puntuacion;
    }
    /**
     * Devuelve la dieta asociada a esta calificacion
     * @return Entidad de tipo dieta
     */
    public DietaTipoEntity getDieta() {
        return dieta;
    }

    /**
     * Modifica la dieta asociada a esta calificacion
     * @param dieta la nueva dieta
     */
    public void setDieta(DietaTipoEntity dieta) {
        this.dieta = dieta;
    }
    
}
