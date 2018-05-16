/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;


/**
 * Clase que extiende de {@link MedioPagoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del medio de pago vaya a la documentacion de {@link MedioPagoDTO}
 * @author jp.campos
 * El formato JSON de este objeto es el siguiente:
 * {
 *  "medioPagoActual ": String,
 *  personas:
 * [{
 * "nombre": String,
 *  "apellido": String,
 *  "edad": int,
 *  "direccion": String,
 *  "correo": String,
 *  "subscrito": boolean,
 *  "identificacion": String
 *  "calificacion": {
 *                    "puntuacion": double
 *                  },
 *  "dieta": {
 *              "objetivo": String,
 *              "descripcion": String,
 *              "cuentaDeCobro": {
 *                                  "valorAPagar": double
 *                               }
 *           }
 * 
 *  "soporteContacto":[
 *                     {
 *                       "Asunto": String,
 *                       "Comentario": string,
 *                      },
 *                      ...,
 *                      {
 *                       "asunto": String,
 *                       "comentario": string,
 *                      }
 * ]}
 * 
 * ]
 * }
 */

public class MedioPagoDetailDTO extends MedioPagoDTO{
     /**
     * Constructor por defecto
     */
    public MedioPagoDetailDTO() {    
     //Constructor vacio para propositos de persistencia
    }
      
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public MedioPagoDetailDTO(MedioPagoEntity entity) {
        super(entity);
    }   
}
