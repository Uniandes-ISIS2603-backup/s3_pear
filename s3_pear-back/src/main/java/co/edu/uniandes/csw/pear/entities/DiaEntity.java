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
 * Clase que representa la entidad de un dia
 * @author v.chacon
 */

@Entity
public class DiaEntity extends BaseEntity implements Serializable {
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private boolean seEnvia;
 
    private String recomendacion;
    
    private String fecha;
    
    private List<ComidaEntity> comidas;
    
    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------
    
    
    /**
     * Determina si la comida se envia o no (Esto varia segun la disponibilidad del cliente)
     * @param pSeEnvia boolean para indicar si se debe o no enviar la comida programada
     */
    public void setSeEnvia (boolean pSeEnvia){
        seEnvia = pSeEnvia;
    }
    
    /**
     * @return si se debe o no enviar la comida ese dia
     */
    public boolean getSenEnvia(){
        return seEnvia;
    }
    /**
     * Determina las recomendaciones adicionales que hay para el cliente
     * @param rec las recomendaciones
     */
    public void setRecomendacion(String rec){
        recomendacion  = rec;
    }
    
    /**
     * @return las recomendaciones que se le deben entregar al cliente ese dia
     */
    public String getRecomendacion(){
        return recomendacion;
    }
    
    /**
     * Determina las comidas programadas para ese dia
     * @param pComidas comidas programadas
     */
    public void setComidas(List<ComidaEntity> pComidas){
        comidas = pComidas;
    }
    
    /**
     * @return las comidas programadas ese dia para el cliente
     */
    public List<ComidaEntity> getComidas(){
        return comidas;
    } 
    
    /**
     * Determina la fecha de este dia
     * @param pFecha 
     */
    public void setFecha(String pFecha){
        fecha = pFecha;
    }
    
    /**
     * @return fecha del dia
     */
    public String getFecha(){
        return fecha;
    }
}
