/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;

/**
 *
 * @author ga.bejarano10
 */
public class QuejasyReclamosDetailDTO extends QuejasyReclamosDTO
{

    /**
     * generado por defecto
     */
    public QuejasyReclamosDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public QuejasyReclamosDetailDTO(QuejasyReclamosEntity entidad) {
        super(entidad);
    }
    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public QuejasyReclamosEntity toEntity() {
        QuejasyReclamosEntity quejasYreclamosE = super.toEntity();
        return quejasYreclamosE;
    }
    
}
