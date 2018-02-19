/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 * @author pa.suarezm
 */
@Entity
public class CasoExitoEntity extends BaseEntity implements Serializable{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private String comentario;
    
    private List/*<TODO>*/ fotos;
    
    private String testimonio;
    
    private DietaTipoEntity dieta;
    
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * @return El comentario asociado al caso
     */
    public String getComentario(){
        return comentario;
    }
    
    /**
     * @param pComentario Nuevo comentario asociado al caso
     */
    public void setComentario(String pComentario){
        comentario = pComentario;
    }
    
    /**
     * @return La lista con las fotos respectivas del caso
     */
    public List/*<TODO>*/ getFotos(){
        return fotos;
    }
    
    /**
     * @param pFotos Nueva lista de fotos asociadas al caso 
     */
    public void setFotos(List/*<TODO>*/ pFotos){
        fotos = pFotos;
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
