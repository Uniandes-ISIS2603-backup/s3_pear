/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;
import java.util.List;

/**
 * CasoExitoDTO modela el objeto que se transfiere entre el cliente y el
 * servidor en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
 * {
 *  "comentario": String,
 *  "fotos": List,
 *  "testimonio": String,
 *  "dieta": {
 *            "objetivo": String,
 *            "descripcion": String,
 *            "cuentaDeCobro": {
 *                              "valor a pagar": double
 *                             }
 * }
 *  //TODO *******ACTUALIZAR A MEDIDA QUE ESTEN HECHAS LAS DEMAS CLASES********
 * @author pa.suarezm
 */
public class CasoExitoDTO {
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private String comentario;
    
    private String testimonio;
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor de un dto de caso exito a partir de un entity
     * @param entidad Entidad a partir de la cual se construye el dto
     */
    public CasoExitoDTO(CasoExitoEntity entidad){
        
        comentario = entidad.getComentario();
        
        testimonio = entidad.getTestimonio();        
    }
    
    /**
     * Constructor vacío para propósitos de persistencia
     */
    public CasoExitoDTO(){
        
    }
    
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
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    public CasoExitoEntity toEntity(){
        CasoExitoEntity entidad = new CasoExitoEntity();
        
        entidad.setComentario(comentario);
        entidad.setTestimonio(testimonio);
        
        return entidad;
    }
}
