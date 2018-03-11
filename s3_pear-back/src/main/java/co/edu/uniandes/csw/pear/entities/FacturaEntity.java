/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import uk.co.jemos.podam.common.PodamExclude;
/**
 * Clase que representa la entidad de una Factura
 * @author v.chacon
 */
@Entity
@Table(name = "FACTURA")
public class FacturaEntity extends  CuentaCobroEntity implements Serializable{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    

    @PodamExclude
    @ManyToOne
    private PersonaEntity persona;
  
    private Integer cantidadProductos = 0;
    
    private Integer numeroFacturaDeVenta = 0;
    
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * Determina de que persona es la factura generada
     * @param p persona nueva asignada
     */
    public void setPersona(PersonaEntity p){
        persona = p;
    }
   
    /**
     * 
     * @return persona responsable de la factura
     */
    public  PersonaEntity getPersona(){
        return persona;
    }
  
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
 }
 