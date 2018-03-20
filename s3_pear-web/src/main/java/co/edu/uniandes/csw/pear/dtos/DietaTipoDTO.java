/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
//TODO: Borrar lo que no se usa
import java.util.List;

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
        //TODO: entity puede ser null
        this.objetivo = entity.getObjetivo();
        this.descripcion = entity.getDescripcion();
        this.id = entity.getId();
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

    public DietaTipoEntity toEntity() {
        DietaTipoEntity en = new DietaTipoEntity();
        en.setDescripcion(this.descripcion);
        en.setObjetivo(this.objetivo);
        en.setId(this.id);
        return en;
    }

}
