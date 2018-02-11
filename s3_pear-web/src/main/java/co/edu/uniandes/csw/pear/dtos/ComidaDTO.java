/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.BaseEntity;
import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import java.io.Serializable;

/**
 *
 * @author js.cabra
 */
public class ComidaDTO

{
    public int cantidad ;
    
    public String alimentos;
    
    public String TIPO;
    
    public String  direccion;
    
    public ComidaDTO(ComidaEntity entidad)    
    {
        cantidad = entidad.getCantidad();
        
        alimentos = entidad.getAlimentos();
        
        TIPO = entidad.getTipo();
        
        direccion = entidad.getDireccion();
    }
    
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
}
