/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.EnvioEntity;

/**
/**
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "duraciom": number,
 *      "recibidio": boolean,
 *      "direccio":String
 *   }
 *  Por ejemplo un envio  se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "duracion": 1hora,
 *      "recibido": true,
 *      "direccion": UnaDireccion
 *   }
 *
 * </pre>
 * @author js.cabra
 */
public class EnvioDetailDTO extends EnvioDTO{
    
    //TODO: si no hay atributos esta clase no se necesita
    /**
     * Constructor vacio
     */
    
    public EnvioDetailDTO()
    {
        super();
    }
    
        /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de Envio a partir de la cual se construye el objeto
     */
    
    public EnvioDetailDTO(EnvioEntity entidad) {
        super(entidad);
    }
    
      /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public EnvioEntity toEntity() {
        EnvioEntity en = super.toEntity();
        
           
        
        return en;
    }
}
