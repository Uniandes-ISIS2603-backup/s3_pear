/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.FacturaEntity;

/*
 * 
 * El formato JSon que representa el objeto es el siguiente: 
 * {
 *      "cantidadDeProductos": Integer,
 *      "numeroFactura": Integer,
 *      "persona":  [ {
 *                   "nombre": String,
 *                   "apellido": String,
 *                   "edad": int,
 *                   "direccion": String,
 *                   "correo": String,
 *                      "subscrito": boolean,
 *                   "identificacion": String
 *                   "calificacion": {
 *                              "puntuacion": double
 *                                   },
 *                    "dieta": {
 *                              "objetivo": String,
 *                              "descripcion": String,
 *                              "cuentaDeCobro": {
 *                                  "valorAPagar": double
 *                               }
 *                              }
 * 
 *                    "soporteContacto":[
 *                     {
 *                       "Asunto": String,
 *                       "Comentario": string,
 *                      },
 *                      ...,
 *                      {
 *                       "asunto": String,
 *                       "comentario": string,
 *                      }
 *                    ]
 *   }
 * }
 * @author v.chacon
 */
public class FacturaDetailDTO extends FacturaDTO{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    private PersonaDTO persona;
  
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor de la clase FacturaDetailDTO
     * @param entity entidad a partir de la cual se construira el dto
     */
    public FacturaDetailDTO(FacturaEntity entity){
        super(entity);
        if(entity != null){
        if(entity.getPersona() != null){
            persona = new PersonaDTO(entity.getPersona());
        }
        else{
            persona = null;
        }
        }
    }   
    
    /**
     * Constructor de la aplicación
     */
    public FacturaDetailDTO(){
        super();
    }
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * Determina de que persona es la factura generada
     * @param p persona nueva asignada
     */
    public void setPersona(PersonaDTO p){
        persona = p;
    }
   
    /**
     * 
     * @return persona responsable de la factura
     */
    public  PersonaDTO getPersona(){
        return persona;
    }
    
    @Override
    public FacturaEntity toEntity(){
        FacturaEntity entity = super.toEntity();
        if(this.getPersona() != null){
            entity.setPersona(this.getPersona().toEntity());
        }
        return entity;
    }

}
