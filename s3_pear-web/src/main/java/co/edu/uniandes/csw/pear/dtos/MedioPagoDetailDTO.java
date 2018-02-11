/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
/**
 *
 * @author jp.campos
 */
public class MedioPagoDetailDTO extends MedioPagoDTO{
    
     /**
     * Constructor por defecto
     */
    public MedioPagoDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public MedioPagoDetailDTO(MedioPagoEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public MedioPagoEntity toEntity() {
        MedioPagoEntity entity = super.toEntity();
        return entity;
    }

    
    
}
