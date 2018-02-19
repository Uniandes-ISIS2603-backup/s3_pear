/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import co.edu.uniandes.csw.pear.entities.EnvioEntity;

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
 *      "comida": ComidaDTO
 *   }
 * </pre>
 * Por ejemplo un envio se representa asi:<br>
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

 * @author js.cabra
 */
public class EnvioDTO {
    
    private int duracion;
    
    private boolean recibido;
    
    private ComidaEntity comida;
    
    private int id;
    
    public EnvioDTO(EnvioEntity entidad)
    {
        duracion = entidad.getDuracion();
        
        recibido = entidad.getRecibido();
        
        comida = entidad.getComida();
        
    }
    
       public int getId()
    {
        return id;
    }
    
    public void setId(int pId)
    {
        id = pId;
    }
        /**
     * 
     * @return la duracion.
     */
    public int getDuracion()
    {
        return duracion;
    }
        /**
     * 
     * @return sì fue recibido el envio.
     */
    public boolean getRecibido()
    {
        return recibido;
    }
        /**
     * 
     * @return la comida que se va a entregar.
     */
    public ComidaEntity getComida()
    {
        return comida;
    }
        /**
     * 
     * @param la nueva duraciòn.
     */
    public void setDuracion(int pDuracion)
    {
        duracion = pDuracion;
    }
    
    public void setRecibidoFalso()
    {
        recibido = false;
    }
    public void setRecibidoVerdadero()
    {
        recibido = true;
    }
        /**
     * 
     * @param la nueva comida
     */
    public void setComida(ComidaEntity pComida)
    {
        comida = pComida;
    }
    
}
