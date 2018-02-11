/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author pa.suarezm
 */
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
    
    public String getComentario(){
        return comentario;
    }
    
    public List/*<TODO>*/ getFotos(){
        return fotos;
    }
    
    public String getTestimonio(){
        return testimonio;
    }
    
    public DietaTipoEntity getDieta(){
        return dieta;
    }
    
    //TODO Falta la documentacion y los setters
    
}
