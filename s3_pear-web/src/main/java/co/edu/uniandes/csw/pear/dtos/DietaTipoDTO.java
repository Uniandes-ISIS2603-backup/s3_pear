/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
//TODO: DONE Borrar lo que no se usa

/**
 * DietaTipoDTO modela el objeto que se transfiere entre el cliente y el
 * servidor en formato JSON.
 *
 * {
 * "id" : 123, "objetivo": "un objetivo", "descripcion": "una descripcion",
 * "cuentaCobro": { "valorAPagar": 23.00 }, "semanas":[ {
 * "fechaLunes":"2012-04-23T18:25:43.511Z", "dias":[ { "SeEnvia": true,
 * "recomendacion": "una recomendacion", "fecha": "2012-04-23T18:25:43.511Z" } ]
 * } ] }
 *
 *
 *
 * @author js.garcial1
 */
public class DietaTipoDTO {
    
    private Long id;
    private String objetivo;
    private String descripcion;
    private String name;
    
    private String imagen;
    private Integer stars;
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    /**
     * Contructor de DietaTipoDTO
     */
    public DietaTipoDTO() {
        
    }
    
    /**
     * Constructor a partir de una Entity
     *
     * @param entity entidad a partir de la cual se construira el dto
     */
    public DietaTipoDTO(DietaTipoEntity entity) {
        //TODO: DONE entity puede ser null
        if ( entity != null  ) {
            this.objetivo = entity.getObjetivo();
            this.descripcion = entity.getDescripcion();
            this.name = entity.getName();
            this.id = entity.getId();
            this.imagen = entity.getImagen();
            this.stars = entity.getStars();
        }
        
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
    
    
    
    
    
    public DietaTipoEntity toEntity() {
        DietaTipoEntity en = new DietaTipoEntity();
        en.setDescripcion(this.descripcion);
        en.setObjetivo(this.objetivo);
        en.setName(this.name);
        en.setId(this.id);
        en.setImagen(this.imagen);
        en.setStars(this.stars);
        return en;
    }
    
}
