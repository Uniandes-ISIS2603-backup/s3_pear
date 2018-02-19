/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import javax.persistence.Entity;
/**
 * Clase que representa la entidad de una Factura
 * @author v.chacon
 */
@Entity
public class FacturaEntity extends BaseEntity implements Serializable{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private PersonaEntity persona;
     
    private SemanaEntity semana;
    
    private CuentaCobroEntity cuenta;

    private int cantidadProductos;
    
    private int numeroFacturaDeVenta;
    
    
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
     * Determina el costo total de la transaccion
     * @param pCuenta cuenta de cobro
     */
    public void setCuentaDeCobro(CuentaCobroEntity pCuenta){
        cuenta  = pCuenta;
    }
    
    /**
     * @return costo total de la transaccion
     */
    public CuentaCobroEntity geCuentaDeCobro(){
        return cuenta;
    }
    
    /**
     * Determina la semana por la cual se esta facturando
     * @param sem semana que se quiere "cobrar"
     */
    public void setSemana(SemanaEntity sem){
        semana = sem;    
    }
    
    /**
     * @return semana que se esta facturando
     */
    public SemanaEntity getSemana (){
        return semana;
    }
    
    /**
     * Determina la cantidad de productos que se estan facturando
     * @param am cantidad
     */
    public void setCantidadDeProductos (int am){
        cantidadProductos  = am;
    }
    
    /**
     * @return cantidad de productos facturados
     */
    public int getCantidadDeProductos (){
        return cantidadProductos;
    }
    
    /**
     * Asigna un identificador unico a la factura
     * @param num numero de indentificacion de la factura
     */
    public void setNumeroFactura( int num){
        numeroFacturaDeVenta = num;
    }
    
    /**
     * @return identificador de la factura
     */
    public int getNumeroFactura(){
        return numeroFacturaDeVenta;
    }
 }
 