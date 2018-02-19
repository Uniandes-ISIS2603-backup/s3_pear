/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.FacturaEntity;



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

    
    private Integer cantidadProductos;
    
    private Integer numeroFacturaDeVenta;
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor de la clase
     * @param entity entidad a partir de la cual se hara el dto
     */
    public FacturaDTO(FacturaEntity entity){
        cantidadProductos = entity.getCantidadDeProductos();
        numeroFacturaDeVenta = entity.getNumeroFactura();
    }
    
    /**
     * Constructor de la clase
     */
    public FacturaDTO(){
        
    }
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
  
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
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    
    public FacturaEntity toEntity(){
        FacturaEntity entity = new FacturaEntity();
        
        entity.setCantidadDeProductos(cantidadProductos);
        entity.setNumeroFactura(numeroFacturaDeVenta); 
        return entity;
    }
 }
 
