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
 * @author js.cabra
 */
public class EnvioDTO {
    
    private int duracion;
    
    private boolean recibido;
    
    private ComidaEntity comida;
    
    public EnvioDTO(EnvioEntity entidad)
    {
        duracion = entidad.getDuracion();
        
        recibido = entidad.getRecibido();
        
        comida = entidad.getComida();
        
    }
    
    public int getDuracion()
    {
        return duracion;
    }
    
    public boolean getRecibido()
    {
        return recibido;
    }
    
    public ComidaEntity getComida()
    {
        return comida;
    }
    
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
    public void setComida(ComidaEntity pComida)
    {
        comida = pComida;
    }
    
}
