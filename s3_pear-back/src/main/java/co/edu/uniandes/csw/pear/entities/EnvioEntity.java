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
import javax.persistence.OneToOne;
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
    @ManyToOne( cascade = CascadeType.PERSIST)
        @JoinTable(name="ENVIOS_PERSONAS", 
        joinColumns=@JoinColumn(name="envioId"),
        inverseJoinColumns=@JoinColumn(name="personaId")
    )
    private PersonaEntity persona;
    
    private boolean recibido;
    @PodamExclude
     @OneToOne( mappedBy = "envio", cascade = CascadeType.ALL)
    private ComidaEntity comida;
    
    
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
     * persona de entrega
     * @return persona
     */
    public PersonaEntity getPersona()
    {
        return persona;
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
     * Comida de la entrega
     * @return comida
     */
    public ComidaEntity getComida()
    {
        return comida;
    }
    
    
     /**
     * Cambia la duracion de la entrega
     * @param pDuracion 
     */
    public void setDuracion(Integer pDuracion)
    {
        duracion = pDuracion;
    }
    /**
     * Cambia el recibidio a falso
     */
    public void setRecibidoFalso()
    {
        recibido = false;
    }
    /**
     * Cambia el recibidio a verdadero
     */
    public void setRecibidoVerdadero()
    {
        recibido = true;
    }
    /**
     * Cambia la comida de el envio
     * @param pComida 
     */
    public void setComida(ComidaEntity pComida)
    {
        comida = pComida;
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
        /**
     * Cambia la persona de el envio
     * @param pPersona 
     */
    public void setPersona(PersonaEntity pPersona)
    {
        persona = pPersona;
    }
}
