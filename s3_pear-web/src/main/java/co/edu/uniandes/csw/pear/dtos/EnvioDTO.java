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
 * EnvioDTO Objeto de transferencia de datos de Envios. Los DTO contienen las
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
 * </pre> 
 *
 * @author js.cabra
 */
public class EnvioDTO {

    private Integer duracion;

    private Boolean recibido;

    private Long id;
    


    private String direccion;

    /**
     * Constructor vacio
     */
    public EnvioDTO() {
        //Constructor para propositos de persistencia
    }

    /**
     * Constructor EnvioDTIO a partir de la Entity
     *
     * @param entidad
     */
    public EnvioDTO(EnvioEntity entidad) {
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

   

    public Long getId() {
        return id;
    }

    public void setId(Long pId) {
        id = pId;
    }

    public EnvioEntity toEntity() {
        EnvioEntity en = new EnvioEntity();
        
        en.setDireccion(direccion);
        en.setDuracion(duracion);
        
        if (recibido) {
            en.setRecibidoVerdadero();
        }
        else{
            en.setRecibidoFalso();
        }
        en.setId(this.id);

        return en;
    }
}
