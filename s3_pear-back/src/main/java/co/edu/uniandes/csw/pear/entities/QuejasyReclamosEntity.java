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
public class QuejasyReclamosEntity extends BaseEntity implements Serializable
{
    private String comentario;
    private String asunto;
    
    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private DietaTipoEntity dieta;

    /**
     * 
     * @return el comentario. 
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * 
     * @param nuevo comentario 
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
  
    /**
     * 
     * @return el asunto 
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * 
     * @param asunto nuevo comentario
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    /**
     * Devuelve la dieta asociada a esta queja o recomendacion
     * @return Entidad de tipo dieta
     */
    public DietaTipoEntity getDieta() {
        return dieta;
    }

    /**
     * Modifica la dieta asociada a esta queja o recomendacion
     * @param dieta la nueva dieta
     */
    public void setDieta(DietaTipoEntity dieta) {
        this.dieta = dieta;
    }
    
}
