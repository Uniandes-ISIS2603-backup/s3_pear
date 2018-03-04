/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CalificacionEntity;

/**
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "puntuacion": double
 *   }
 *  Por ejemplo una calificaion se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "puntuacion": 10
 *   }
 *
 * </pre>
 * @author ga.bejarano10
 */
public class CalificacionDetailDTO extends CalificacionDTO
{

     /**
     * Constructor por defecto
     */
    public CalificacionDetailDTO() {
    }

     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public CalificacionDetailDTO(CalificacionEntity entidad) {
        super(entidad);
    }
    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public CalificacionEntity toEntity() {
        CalificacionEntity calificacionE = super.toEntity();
        return calificacionE;
    }
}
