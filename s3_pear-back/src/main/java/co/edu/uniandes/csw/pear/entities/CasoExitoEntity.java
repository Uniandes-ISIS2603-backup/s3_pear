/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * @author pa.suarezm
 */
@Entity
public class CasoExitoEntity extends BaseEntity implements Serializable{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private String comentario;
    
    private String testimonio;
    
    private String fotoAntesyDespues;
    
    
    @PodamExclude
    @OneToOne(cascade = CascadeType.PERSIST)
    private DietaTipoEntity dieta;

    

    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    public String getFotoAntesyDespues(){
        return fotoAntesyDespues;
    }

    public void setFotoAntesyDespues(String fotoAntesyDespues) {
        this.fotoAntesyDespues = fotoAntesyDespues;
    }

    

    /**
     * @return El comentario asociado al caso
     */
    public String getComentario() {
        return comentario;
    }
    
    /**
     * @param pComentario Nuevo comentario asociado al caso
     */
    public void setComentario(String pComentario){
        comentario = pComentario;
    }
    
    /**
     * @return El testimonio del caso
     */
    public String getTestimonio(){
        return testimonio;
    }
    
    /**
     * @param pTestimonio Nuevo testimonio del caso 
     */
    public void setTestimonio(String pTestimonio){
        testimonio = pTestimonio;
    }
    
    /**
     * @return Dieta para la cual el caso fue exitoso 
     */
    public DietaTipoEntity getDieta(){
        return dieta;
    }
    
    /**
     * @param pDieta Nueva dieta asociada al caso exitoso
     */
    public void setDieta(DietaTipoEntity pDieta){
        dieta = pDieta;
    }
}
