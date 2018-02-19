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
public class ComidaEntity extends BaseEntity implements Serializable 
{
    private int cantidad;
    private String alimentos;
    private String TIPO;
    private String direccion;
    private Long id;
    
 
    public int getCantidad()
            
    {
        return cantidad;
        
    }
    
    public void setCantidad(int pCantidad)
    {
        cantidad = pCantidad;
    }
    
     public String getAlimentos()
            
    {
        return alimentos;
        
    }
    
    public void setAlimentos(String pAlimentos)
    {
        alimentos = pAlimentos;
    }
    
    public String getTipo()
    {
        return TIPO;
    }
    public void setTIPO(String pTipo)
    {
        TIPO = pTipo;
    }
    public String getDireccion()
    {
        return direccion;
    }
    public void setDireccion(String pDireccion)
    {
        direccion = pDireccion;
    }
    
    /**
     *
     * @return id de la comida
     */
    @Override
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long pId)
    {
        id = pId;
    }
}
