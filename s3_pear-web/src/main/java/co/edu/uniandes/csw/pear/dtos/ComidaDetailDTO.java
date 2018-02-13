/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.ComidaEntity;

/**
 * Clase que extiende de {@link ComidaDetail} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link ComidaDTO}
 * @author js.cabra
 */
public class ComidaDetailDTO extends ComidaDTO{
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de comida a partir de la cual se construye el objeto
     */
    public ComidaDetailDTO(ComidaEntity entidad) {
        super(entidad);
    }
    
}
