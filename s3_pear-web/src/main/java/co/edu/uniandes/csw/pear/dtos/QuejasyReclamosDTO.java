/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;

/**
 * QuejasyReclamosDTO Objeto de transferencia de datos de QuejasYReclamos. Los
 * DTO contienen las represnetaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 *
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
 *
 * @author ga.bejarano10
 */
public class QuejasyReclamosDTO {

    private String comentario;
    private String asunto;
    //TODO: debe ser Long 
    private long id;

    /**
     * Constructor por defecto
     */
    public QuejasyReclamosDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param entidad: Es la entidad que se va a convertir a DTO
     */
    public QuejasyReclamosDTO(QuejasyReclamosEntity entidad) {
        //TODO: entity puede ser null 
        this.comentario = entidad.getComentario();
        this.asunto = entidad.getAsunto();
        this.id = entidad.getId();
    }

    /**
     * @return el comentario.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param nuevo comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     *
     * @return el asunto.
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param nuevo asunto
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return un entity con los valores de DTO
     */
    public QuejasyReclamosEntity toEntity() {
        QuejasyReclamosEntity entidad = new QuejasyReclamosEntity();
        entidad.setAsunto(this.asunto);
        entidad.setComentario(this.comentario);
        entidad.setId(this.id);
        return entidad;
    }

}
