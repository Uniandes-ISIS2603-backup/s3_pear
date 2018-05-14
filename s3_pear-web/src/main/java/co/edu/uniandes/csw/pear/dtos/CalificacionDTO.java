/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CalificacionEntity;

/**
 * CalificacionDTO Objeto de transferencia de datos de Calificacion. Los DTO
 * contienen las represnetaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "puntuacion": int
 *   }
 *  Por ejemplo una calificaion se representa asi:<br>
 * </pre>
 * <pre>
 *
 *   {
 *      "puntuacion": 10
 *   }
 *
 * </pre>
 *
 * @author ga.bejarano10
 */
public class CalificacionDTO {

 
    private Long id;

    private int puntuacion;


    /**
     * Constructor por defecto.
     */
    public CalificacionDTO() {
      //Constructor vacio  
    }
    
    
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param entidad: Es la entidad que se va a convertir a DTO
     */
    public CalificacionDTO(CalificacionEntity entidad) {
        if(entidad != null){
            this.puntuacion = entidad.getPuntuacion();
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
     *
     * @return la puntuacion
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     *
     * @param puntuacion nueva puntuacion
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return un entity con los valores de DTO
     */
    public CalificacionEntity toEntity() {
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setPuntuacion(this.puntuacion);
        entidad.setId(this.id);
        return entidad;
    }

}
