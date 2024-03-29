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
 * </pre>
 *
 * @author ga.bejarano10
 */
public class QuejasyReclamosDTO {

    private String comentario;
    private String asunto;
    private Long id;

    /**
     * Constructor por defecto
     */
    public QuejasyReclamosDTO() {
       //Constructor para propositos de persistencia
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param entidad: Es la entidad que se va a convertir a DTO
     */
    public QuejasyReclamosDTO(QuejasyReclamosEntity entidad) {
        if(entidad != null){
        this.comentario = entidad.getComentario();
        this.asunto = entidad.getAsunto();
        this.id = entidad.getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el comentario.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario comentario
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
     * @param asunto nuevo
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * Convertir DTO a Entity
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
