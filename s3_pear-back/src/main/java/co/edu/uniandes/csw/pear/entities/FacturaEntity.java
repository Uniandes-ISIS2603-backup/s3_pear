/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
/**
 * Clase que representa la entidad de una Factura
 * @author v.chacon
 */
@Entity
public class FacturaEntity extends BaseEntity implements Serializable{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    



    private Integer cantidadProductos = 0;
    
    private Integer numeroFacturaDeVenta = 0;


    @PodamExclude
    @ManyToOne(cascade = CascadeType.MERGE)
    private PersonaEntity persona;
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * Determina de que persona es la factura generada
     * @param p persona nueva asignada
     */
   
    /**
     * 
     * @return persona responsable de la factura
     */

/**
     * Determina la cantidad de productos que se estan facturando
     * @param am cantidad
     */
    public void setCantidadDeProductos (Integer am){
        cantidadProductos  = am;
    }
    
    /**
     * @return cantidad de productos facturados
     */
    public Integer getCantidadDeProductos (){
        return cantidadProductos;
    }
    
    /**
     * Asigna un identificador unico a la factura
     * @param num numero de indentificacion de la factura
     */
    public void setNumeroFactura( Integer num){
        numeroFacturaDeVenta = num;
    }
    
    /**
     * @return identificador de la factura
     */
    public Integer getNumeroFactura(){
        return numeroFacturaDeVenta;
    }

    /**
     * @return the persona
     */
    public PersonaEntity getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }
 }
 