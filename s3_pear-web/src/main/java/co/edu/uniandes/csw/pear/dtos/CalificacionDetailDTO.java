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
 *      "puntuacion": double,
 *      "dieta": {@link DietaTipoDTO}
 *   }
 *  Por ejemplo una calificaion se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "puntuacion": 10
 *     
 *   }
 *
 * </pre>
 * @author ga.bejarano10
 */
public class CalificacionDetailDTO extends CalificacionDTO
{
    private DietaTipoDTO dieta;
//TODO: Si Calificacion no declara atributos de asociaición no debería existir
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
        if (entidad.getDieta() != null) {
            this.dieta = new DietaTipoDTO(entidad.getDieta());
        } else {
            entidad.setDieta(null);
        }
    }
    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public CalificacionEntity toEntity() {
        CalificacionEntity calificacionE = super.toEntity();
        if (this.getDieta() != null) {
            calificacionE.setDieta(this.getDieta().toEntity());
        }
        return calificacionE;
    }
    
    /**
     * Modifica la dieta asociada a esta calificacion.
     * @param dieta the dieta to set
     */
    public void setDieta(DietaTipoDTO dieta) {
        this.dieta = dieta;
    }

    /**
     * Devuelve la dieta asociada a esta calificacion
     * @return DTO de Editorial
     */
    public DietaTipoDTO getDieta() {
        return dieta;
    }
}
