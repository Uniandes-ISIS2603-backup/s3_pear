/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import javax.persistence.Entity;
/**
 *
 * @author js.cabra
 */
@Entity
public class ComidaEntity extends BaseEntity implements Serializable 
{
    private int cantidad;
    private String alimentos;
    private  String TIPO;
    
    public  String DESAYUNO = "desayuno";
    public  String ALMUERZO = "almuerzo";
    public  String CENA = "cena";
    public  String ADICIONAL= "adicional";
    
    
 /**
     * Cantidad de la comida 
     * @return cantidad
     */
    public int getCantidad()
            
    {
        return cantidad;
        
    }
    /**
     * Cambia los alimentos de la comida
     * @param pCantidad
     */
    public void setCantidad(int pCantidad)
    {
        cantidad = pCantidad;
    }
    /**
     * alimentos de la comida
     * @return alimentos
     */
     public String getAlimentos()
            
    {
        return alimentos;
        
    }
    /**
     * Cambia alimentos de la comida
     * @param pAlimetos
     */
    public void setAlimentos(String pAlimentos)
    {
        alimentos = pAlimentos;
    }
    /**
     * Tipo de la comida 
     * @return TIPO
     */
    public String getTipo()
    {
        return TIPO;
    }
    /**
     * Cambia el tipo de la comida
     * @param pTipo
     */
    public void setTIPO(String pTipo)
    {
        TIPO = pTipo;
    }
    
    
    
}
