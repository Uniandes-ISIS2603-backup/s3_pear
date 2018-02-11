/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.PagoEntity;



/**
 *
 * @author jp.campos
 */
public class PagoDetailDTO extends PagoDTO{
    
      
     /**
     * Constructor por defecto
     */
    public PagoDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public PagoDetailDTO(PagoEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public PagoEntity toEntity() {
        PagoEntity entity = super.toEntity();
       
        
        return entity;
    }

    
    
    
    
}
