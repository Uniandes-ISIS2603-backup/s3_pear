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
    
    private DietaTipoDetailDTO dieta;
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    public CasoExitoDTO(CasoExitoEntity entidad){
        
        comentario = entidad.getComentario();
        
        fotos = entidad.getFotos();
        
        testimonio = entidad.getTestimonio();
        
        dieta = new DietaTipoDetailDTO(entidad.getDieta());
        
    }
}
