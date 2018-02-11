/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.FacturaEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;


/**
 * FacturaDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSon que representa el objeto es el siguiente: 
 * {
 *  "persona":{
 *          "nombre": String,
 *          "identificacion": String,
 *            },
 * "semana":{
 *          "fechaLunes":String
 *          },
 * "cuenta":{
 *          "valorAPagar":double
 *          }
 *  "cantidadProductos": int,
 *  "numeroFacturaDeVenta": int,
 * }
 * 
 * @author v.chacon
 */
public class FacturaDTO {
    
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
 
    
    private PersonaDTO persona;
     
    private SemanaDTO semana;
    
   // private CuentaDeCobroDTO cuenta;
    
    private int cantidadProductos;
    
    private int numeroFacturaDeVenta;
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    public FacturaDTO(FacturaEntity entity){
        
        persona = new PersonaDTO(entity.getPersona());
        semana = new SemanaDTO(entity.getSemana());
        //cuenta = new CuentaDeCobroDTO(entity.getCuentaDeCobro());
        cantidadProductos = entity.getCantidadDeProductos();
        numeroFacturaDeVenta = entity.getNumeroFactura();
    }
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
  /**
     * Determina de que persona es la factura generada
     * @param p persona nueva asignada
     */
    public void setPersona(PersonaDTO p){
        persona = p;
    }
   
    /**
     * 
     * @return persona responsable de la factura
     */
    public  PersonaDTO getPersona(){
        return persona;
    }

    /**
     * Determina el costo total de la transaccion
     * @param pCuenta cuenta de cobro
     */
//    public void setCuentaDeCobro(CuentaDeCobroDTO pCuenta){
//        cuenta  = pCuenta;
//    }
//    
    /**
     * @return costo total de la transaccion
     */
//    public CuentaDeCobroDTO geCuentaDeCobro(){
//        return cuenta;
//    }
    
    /**
     * Determina la semana por la cual se esta facturando
     * @param sem semana que se quiere "cobrar"
     */
    public void setSemana(SemanaDTO sem){
        semana = sem;    
    }
    
    /**
     * @return semana que se esta facturando
     */
    public SemanaDTO getSemana (){
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
    
    
     /**
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    
    public FacturaEntity toEntity(){
        FacturaEntity entity = new FacturaEntity();
        
        entity.setCantidadDeProductos(cantidadProductos);
        entity.setSemana(semana.toEntity());
        entity.setCantidadDeProductos(cantidadProductos);
        entity.setPersona(persona.toEntity());
        //entity.setCuentaDeCobro(cuenta.toEntity());
        
        return entity;
    }
 }
 
