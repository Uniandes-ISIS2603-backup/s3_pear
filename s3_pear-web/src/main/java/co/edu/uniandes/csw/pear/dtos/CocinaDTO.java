/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
//TODO: DONE borrar lo que no se usa


/**
 * CocinaDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:

 
 {
   "id": 123,
  "ubicacion": "Una ubicacion",
  "capacidad": "una capacidad",
  "dietas": [
              
       {
            "objetivo": "un objetivo",
            "descripcion": "una descripcion",
            "cuentaDeCobro": {
                     "valorAPagar": 23.00
                   },
            "semanas":[
                    {
   		"fechaLunes":"2012-04-23T18:25:43.511Z",
   		"dias":[
   			{
   				"SeEnvia": true,
   				"recomendacion": "una recomendacion",
            	"fecha": "2012-04-23T18:25:43.511Z"
                        }
                    ]
                }
               ]
        }
  
  
    ]
  }
 
 
 * @author js.garcial1
 */
public class CocinaDTO {
    
    private Long id;
    private String ubicacion;
    private String capacidad;  
    private String name;
    private String imagen;
    
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
        //TODO: DONE entity podría ser null
        if ( entity != null ) {
            this.capacidad = entity.getCapacidad();
            this.ubicacion = entity.getUbicacion();
            this.id = entity.getId();
            this.name = entity.getName();
            this.imagen = entity.getImagen();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
    public CocinaEntity toEntity() {
        CocinaEntity en = new CocinaEntity();
        en.setCapacidad(this.capacidad);
        en.setUbicacion(this.ubicacion);
        en.setId(this.id);
        en.setName(this.name);
        en.setImagen(this.imagen);
        return en;
    }
    
}
