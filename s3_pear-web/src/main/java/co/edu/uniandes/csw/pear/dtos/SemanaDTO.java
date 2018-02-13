/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import java.util.LinkedList;
import java.util.List;

/**
 *SemanaDTO  modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 *  El formato JSON de este objeto es el siguiente:
 * {
 *  "fechaLunes":String,
 *  "dias":[{"SeEnvia": boolean,
 *           "recomendacion": String,
 *           "fecha": String
 *         }]
 * }
 *
 * @author v.chacon
 */
public class SemanaDTO {
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
     private String fechaLunes;
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    public SemanaDTO(SemanaEntity entity){
        fechaLunes = entity.getFechaLunes();
    }
    
    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------
    
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

        
        return entity;
    }
}
