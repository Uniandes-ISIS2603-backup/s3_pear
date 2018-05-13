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
 *
 *  * EnvioDTO Objeto de transferencia de datos de Envios. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "duraciom": number,
 *      "recibidio": boolean,
 *      "direccio":String
 *   }
 * </pre> Por ejemplo un envio se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "duracion": 1hora,
 *      "recibido": true,
 *      "comida": UnaComida
 *   }
 *
 * </pre>
 *
 * @author js.cabra
 */
public class EnvioDTO {

    public Integer duracion;

    public Boolean recibido;

    public Long id;
    
    public ComidaEntity comida;
    
    public PersonaEntity persona;

    public String direccion;

    /**
     * Constructor vacio
     */
    public EnvioDTO() {

    }

    /**
     * Constructor EnvioDTIO a partir de la Entity
     *
     * @param entidad
     */
    public EnvioDTO(EnvioEntity entidad) {//TODO:DONE entity puede ser null
        if(entidad!=null)
        {
        duracion = entidad.getDuracion();

        recibido = entidad.getRecibido();
        }

    }

    /**
     * direccion del envio
     *
     * @return la direccion.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Cambia la direccion del envio
     *
     * @param pDireccion nueva direccion
     */
    public void setDireccion(String pDireccion) {
        direccion = pDireccion;
    }

    /**
     *
     * @return duracion del envio.
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     *
     * @return recibido el envio.
     */
    public Boolean getRecibido() {
        return recibido;
    }

    /**
     *
     * @return la comida que se va a entregar.
     */
    public ComidaEntity getComida() {
        return comida;
    }

    /**
     * Cambia la duracion
     *
     * @param pDuracion nueva duraciòn.
     */
    public void setDuracion(Integer pDuracion) {
        duracion = pDuracion;
    }

    /**
     * Cambia a falso sì fue recibido
     */
    public void setRecibidoFalso() {
        recibido = false;
    }

    /**
     * Cambia a verdadero sì fue recibido
     */
    public void setRecibidoVerdadero() {
        recibido = true;
    }

    /**
     * Cambia la comida
     *
     * @param pComida nueva comida
     */
    public void setComida(ComidaEntity pComida) {
        comida = pComida;
    }

    /**
     * persona de entrega
     *
     * @return persona
     */
    public PersonaEntity getPersona() {
        return persona;
    }

    /**
     * Cambia la persona de el envio
     *
     * @param pPersona
     */
    public void setPersona(PersonaEntity pPersona) {
        persona = pPersona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long pId) {
        id = pId;
    }

    public EnvioEntity toEntity() {
        EnvioEntity en = new EnvioEntity();
        en.setComida(comida);
        en.setDireccion(direccion);
        en.setDuracion(duracion);
        en.setPersona(persona);
        if (recibido == false) {
            en.setRecibidoFalso();
        }

        if (recibido == true) {
            en.setRecibidoVerdadero();
        }
        en.setId(this.id);

        return en;
    }
}
