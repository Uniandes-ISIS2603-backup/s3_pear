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
    
    private List/*<TODO>*/ fotos;
    
    private String testimonio;
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    public CasoExitoDTO(CasoExitoEntity entidad){
        
        comentario = entidad.getComentario();
        
        fotos = entidad.getFotos();
        
        testimonio = entidad.getTestimonio();        
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
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    public CasoExitoEntity toEntity(){
        CasoExitoEntity entidad = new CasoExitoEntity();
        
        entidad.setComentario(comentario);
        entidad.setFotos(fotos);
        entidad.setTestimonio(testimonio);
        
        return entidad;
    }
}
