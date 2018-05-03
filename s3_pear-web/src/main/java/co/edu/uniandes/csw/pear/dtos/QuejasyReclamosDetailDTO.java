/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;

/**
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "Asunto": String,
 *      "Comentario": string,
 *   }
 *  Por ejemplo una queja y reclamo  se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "Asunto": "Queja",
 *      "Comentario": "Mas puntual con la entrega"
 *   }
 *
 * </pre>
 * @author ga.bejarano10
 */
public class QuejasyReclamosDetailDTO extends QuejasyReclamosDTO
{
//TODO: Si la clase no tiene atributos no debería existir
    /**
     * generado por defecto
     */
    
    
    private DietaTipoDTO dieta;
    public QuejasyReclamosDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public QuejasyReclamosDetailDTO(QuejasyReclamosEntity entidad) {
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
    public QuejasyReclamosEntity toEntity() {
        QuejasyReclamosEntity quejasYreclamosE = super.toEntity();
        if (this.getDieta() != null) {
            quejasYreclamosE.setDieta(this.getDieta().toEntity());
        }
        return quejasYreclamosE;
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
