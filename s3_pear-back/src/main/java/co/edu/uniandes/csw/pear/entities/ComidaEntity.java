/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author js.cabra
 */
@Entity
public class ComidaEntity extends BaseEntity implements Serializable 
{
    private int cantidad;
    private String alimentos;
   private String tipo;

    
    @PodamExclude
    @ManyToOne(cascade = CascadeType.ALL)
        @JoinTable(name="DIAS_COMIDAS", 
        joinColumns=@JoinColumn(name="comidaId"),
        inverseJoinColumns=@JoinColumn(name="diaId")
    )
    private DiaEntity dia;
       
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
     * @param pAlimentos
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
        return tipo;
    }
    /**
     * Cambia el tipo de la comida
     * @param pTipo
     */
    public void setTipo(String pTipo)
    {
        tipo = pTipo;
    }
   
    /**
     * Dia de la comida 
     * @return TIPO
     */
    public DiaEntity getDia()
    {
        return dia;
    }
    /**
     * Cambia el dia de la comdia
     * @param pDia
     */
    public void setDia(DiaEntity pDia)
    {
        dia = pDia;
    }
   
    
        /**
     * Imagen de la comida 
     * @return image
     
    public String getImage()
    {
        return image;
    }
    /**
     * Cambia la imagen de la comida
     * @param pImage
     
    public void setImage(String pImage)
    {
        image = pImage;
    }*/
    
    
}
