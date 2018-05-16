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
public class EnvioEntity extends BaseEntity implements Serializable{
    
    private Integer duracion;
    
    private String direccion;
    
    @PodamExclude
  
    private Boolean recibido;   
    
    @PodamExclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name="ENVIOS_DIAS", 
        joinColumns=@JoinColumn(name="envioID"),
        inverseJoinColumns=@JoinColumn(name="diaId")
    )
    private DiaEntity dia;
    
    
    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------
    
    
    
    public DiaEntity getDia(){
        return dia;
    }
    
    public void setDia(DiaEntity pDia){
        dia = pDia;
    }

    /**
     * duracion de entrega
     * @return duracion
     */
    public Integer getDuracion()
    {
        return duracion;
    }
    /**
     * Recibido,sì la entrega fue recibida 
     * @return recibido
     */
    public boolean getRecibido()
    {
        return recibido;
    }
    
    
     /**
     * Cambia la duracion de la entrega
     * @param pDuracion 
     */
    public void setDuracion(Integer pDuracion)
    {
        this.duracion = pDuracion;
    }
    /**
     * Cambia el recibidio a falso
     * @param pRecibido
     */
    public void setRecibido(Boolean pRecibido)
    {
        this.recibido = pRecibido;
    }


    /**
     * direccion de entrega
     * @return ubicacion
     */
    public String getDireccion()
    {
        return direccion;
    }
    
    /**
     * Cambia la direccion de el envio
     * @param pDireccion 
     */
    public void setDireccion(String pDireccion)
    {
        direccion = pDireccion;
    }

}
