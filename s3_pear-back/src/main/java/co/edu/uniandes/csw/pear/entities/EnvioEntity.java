/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;

/**
 *
 * @author js.cabra
 */
public class EnvioEntity extends BaseEntity implements Serializable{
    
    private int duracion;
    
    private boolean recibido;
    
    private ComidaEntity comida;
    
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
