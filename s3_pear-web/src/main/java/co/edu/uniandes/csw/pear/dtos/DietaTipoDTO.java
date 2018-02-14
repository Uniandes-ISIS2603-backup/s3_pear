/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import java.util.List;

/**
 * DietaTipoDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
 * {
 *  "objetivo": String,
 *  "descripcion": String,
 *  "cuentaDeCobro": {
 *                    "valorAPagar": double
 *                  }
 * }
 * @author js.garcial1
 */
public class DietaTipoDTO {
    
    private String objetivo;
    
    private String descripcion;
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * Contructor de DietaTipoDTO
     */
    public DietaTipoDTO(   ) {
        
    }
    /**
     * Constructor a partir de una Entity
     * @param entity entidad a partir de la cual se construira el dto 
     */
    public DietaTipoDTO( DietaTipoEntity entity ) {
        this.objetivo = entity.getObjetivo();
        this.descripcion = entity.getDescripcion();
    }

    
    
    
    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DietaTipoEntity toEntity() {
        DietaTipoEntity en = new DietaTipoEntity();
        en.setDescripcion(this.descripcion);
        en.setObjetivo(this.objetivo);
        return en;
    }

    
}
