/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import java.util.ArrayList;
import java.util.List;


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
    
    
    private List<PersonaDTO> personas = new ArrayList();
    
     /**
     * Constructor por defecto
     */
    public MedioPagoDetailDTO() {
        
        
    }
      

    
    /**
     * Retorna las personas que usen este medio de pago
     * @return personas
     */
    public List<PersonaDTO> getPersonas()
    {
        return personas; 
    }
    
    /**
     * Cambia la lista de personas que usan el medio de pago
     * @param pPersonas 
     */
    public void setPersonas(ArrayList<PersonaDTO> pPersonas)
    {
       personas = pPersonas; 
    }
   
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public MedioPagoDetailDTO(MedioPagoEntity entity) {
        super(entity);
        //TODO DONE: entity puede ser null
        
        if(entity != null){
        if(entity.getPersonas() != null)
        {
            personas = new ArrayList<>(); 
            for (PersonaEntity persona : entity.getPersonas()) {
                personas.add( new PersonaDTO(persona));
            }
        }
        else 
        {
            this.personas = new ArrayList<>(); 
        }
        }    
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public MedioPagoEntity toEntity() {
        MedioPagoEntity entity = super.toEntity();
        
        if(personas != null)
        {
            List<PersonaEntity> personasEntity = new ArrayList<>();
            for (PersonaDTO persona : personas) {
                personasEntity.add(persona.toEntity());
            }
        }
        return entity;
    }

    
    
}
