/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
//TODO: Borrar lo simport que no se usan
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import java.util.LinkedList;
import java.util.List;

/**
 *SemanaDTO  modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 *  El formato JSON de este objeto es el siguiente:
 * {
 *  "id": 123,
 *  "fechaLunes": "14/02/2018",
 *  "dias":[
 *      {    "SeEnvia": true,
 *           "recomendacion": "evitar la sal",
 *           "fecha": "14/02/2018"
 *      }
 *         ]
 * }
 *
 * @author v.chacon
 */
public class SemanaDTO {
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
     private Long id;
     
     private String fechaLunes;
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
     
     
     /**
      * Constructor de la clase SemanaDTO
      * @param entity entidad a partir de la cual se construira el dto
      */
     public SemanaDTO(SemanaEntity entity){
         //TODO: entity puede ser null
        fechaLunes = entity.getFechaLunes();
        id = entity.getId();
    }
     
     /**
      * Contructor de la clase SemanaDTO
      */
    public SemanaDTO(){
        
    }
    
    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------
    
    
    public Long getId() {
        return id;
    }
     
    public void setId(Long pId) {
        id = pId;
    }
    /**
     * Determina la fecha inicial de la semana
     * @param date fecha inicial
     */
    public void setFechaLunes(String date){
        fechaLunes = date;
    }
    
    /**
     * @return fecha en la que inicion la semana, esta comenzara cada lunes
     */
    public String getFechaLunes(){
        return fechaLunes;
    }
   
  
    /**
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    
    public SemanaEntity toEntity(){
        SemanaEntity entity = new SemanaEntity();
        
        entity.setFechaLunes(fechaLunes);
        entity.setId(id); 
        return entity;
    }
}
