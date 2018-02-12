/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import java.util.LinkedList;
import java.util.List;

/**
 * CocinaDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
 * {
 *  "ubicacion": String,
 *  "capacidad": String,
 *  "dietas": [
 *              {
 *                  "objetivo" : String,
 *                  "descripcion" : String,
 *                  "cuentadecobro": {
 *                    "valorapagar": double
 *                  },
 *                  "semanas" : [
 *                                  {
 *                                      //ATRIBUTOS DE SEMANAS POR DEFINIR
 *                                  }
 *                              ]
 *              }  
 *            ]
 * }
 * @author js.garcial1
 */
public class CocinaDTO {
    
    private String ubicacion;
    
    private String capacidad;    
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * Constructor de tipo CocinaDTO
     * @param entidad 
     */
    public CocinaDTO( ) {
        
    }
    
    /**
     * Constructor CocinaDTO a partir de la Entity
     * @param entity 
     */
    public CocinaDTO( CocinaEntity entity ) {
        this.capacidad = entity.getCapacidad();
        this.ubicacion = entity.getUbicacion();
    }
    
    

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    
    public CocinaEntity toEntity() {
        CocinaEntity en = new CocinaEntity();
        en.setCapacidad(this.capacidad);
        en.setUbicacion(this.ubicacion);
        return en;
    }
    
}
