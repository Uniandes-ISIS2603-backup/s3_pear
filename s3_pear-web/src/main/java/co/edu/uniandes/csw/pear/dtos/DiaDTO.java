/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.DiaEntity;
/**
 *DiaDTO  modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
 * {"SeEnvia": boolean,
 *  "recomendacion": String,
 *  "fecha": String,
 *  "comida": [{
 *              "cantidad":int,
 *              "alimentos":String,
 *              "direccion": String,
 *              "tipo":String
 *            }]
 * }
 * @author v.chacon
 */
public class DiaDTO {
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private boolean seEnvia;
 
    private String recomendacion;
    
    private String fecha;
    
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor de la clase DiaDTO
     * @param entity entidad a apartir de la cual se construye el dto
     */
    public DiaDTO(DiaEntity entity){
        seEnvia = entity.getSenEnvia();
        recomendacion = entity.getRecomendacion();
        fecha = entity.getRecomendacion();
    }
    
    /**
     * Constructor de la clase DiaDTO
     */
    public DiaDTO(){
        
    }
    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------
 
    /**
     * Determina si la comida se envia o no (Esto varia segun la disponibilidad del cliente)
     * @param pSeEnvio boolean para indicar si se debe o no enviar la comida programada
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
     
    /**
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    
    public DiaEntity toEntity(){
        DiaEntity entity  = new DiaEntity();
        entity.setSeEnvia(seEnvia);
        entity.setRecomendacion(recomendacion);
        entity.setFecha(fecha);
        
        return entity;
    }
}

