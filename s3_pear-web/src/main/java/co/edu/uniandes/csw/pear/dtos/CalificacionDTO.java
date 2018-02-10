/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CalificacionEntity;

/**
 * CalificacionDTO Objeto de transferencia de datos de Calificacion. Los
 * DTO contienen las represnetaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "puntuacion": double,
 *   }
 * @author ga.bejarano10
 */
public class CalificacionDTO {

    

    private double puntuacion;
    /**
     * Constructor por defecto.
     */
    public CalificacionDTO() {
    }
    
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param entidad: Es la entidad que se va a convertir a DTO
     */
    public CalificacionDTO(CalificacionEntity entidad)
    {
      this.puntuacion= entidad.getPuntuacion();
    }

    /**
     * 
     * @return la puntuacion
     */
    public double getPuntuacion() {
        return puntuacion;
    }

    /**
     * 
     * @param la nueva puntuacion 
     */
    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
   
     /**
     * Convertir DTO a Entity
     * @return  un entity con los valores de DTO
     */
     public CalificacionEntity toEntity()
    {
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setPuntuacion(this.puntuacion);
        return entidad;
    }
    

}
