/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.EnvioEntity;

/**
 * Clase que extiende de {@link EnvioDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link EnvioDTO}
 * @author js.cabra
 */
public class EnvioDetailDTO extends EnvioDTO{
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de Envio a partir de la cual se construye el objeto
     */
    public EnvioDetailDTO(EnvioEntity entidad) {
        super(entidad);
    }
    public EnvioEntity toEntity() {
        EnvioEntity en = super.toEntity();
        
           
        
        return en;
    }
}
