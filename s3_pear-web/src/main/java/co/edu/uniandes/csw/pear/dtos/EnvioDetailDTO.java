/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import co.edu.uniandes.csw.pear.entities.EnvioEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;

/**
/**
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "duraciom": number,
 *      "recibidio": boolean,
 *      "direccio":String
 *   }
 *  Por ejemplo un envio  se representa asi:<br>
 * </pre>
 * @author js.cabra
 */
public class EnvioDetailDTO extends EnvioDTO{
 
    
        private ComidaDTO comida;
    
    private PersonaDTO persona;
    /**
     * Constructor vacio
     */
    
    public EnvioDetailDTO()
    {
        super();
    }
    
        /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entidad La entidad de Envio a partir de la cual se construye el objeto
     */
    
    public EnvioDetailDTO(EnvioEntity entidad) {
        super(entidad);
        if(entidad!=null)
        {
        if(entidad.getComida()!=null)
        {
            comida = new ComidaDTO(entidad.getComida());
        
        }
        else
        {
            comida = new ComidaDTO();
        }
        if (entidad.getPersona()!=null)
        {
            persona = new PersonaDTO(entidad.getPersona());
        }
        else
        {
            persona = new PersonaDTO();
        }
        }
    }
    
      /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public EnvioEntity toEntity() {
        EnvioEntity en = super.toEntity();
        
        if(this.getComida()!=null)
        {
            en.setComida(comida.toEntity());
        }
        if(this.getPersona()!=null)
        {
            en.setPersona(persona.toEntity());
        }
        
        return en;
    }
    
    
        /**
     *
     * @return la comida que se va a entregar.
     */
    public ComidaDTO getComida() {
        return comida;
    }
    
     /**
     * Cambia la comida
     *
     * @param pComida nueva comida
     */
    public void setComida(ComidaDTO pComida) {
        comida = pComida;
    }

    /**
     * persona de entrega
     *
     * @return persona
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * Cambia la persona de el envio
     *
     * @param pPersona
     */
    public void setPersona(PersonaDTO pPersona) {
        persona = pPersona;
    }
}
