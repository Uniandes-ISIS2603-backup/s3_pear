/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity;
/**
 * CuentaCobroDTO modela el objeto que se transfiere entre el cliente y el
 * servidor en formato JSON.
 *
 * El formato JSON de este objeto es el siguiente: { "valorAPagar": 15.0, "id":
 * 1, "pago" : { "montoInicial":7.0, "montoFinal": 8.0 } }
 *
 * @author jp.campos
 */
public class CuentaCobroDTO {

    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    private Long id;
    
    private Double valorAPagar;

    private Integer cantidadProductos;
    
    private Integer numeroFacturaDeVenta;
    
    
    
    /**
     * Contructor por defecto
     */
    public CuentaCobroDTO() {
       //Constructor para propositos de persistencia
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el
     * objeto
     */
    public CuentaCobroDTO(CuentaCobroEntity entity) {
        if(entity!= null){
        
        this.valorAPagar = entity.getValorAPagar();
        this.id = entity.getId(); 
        this.cantidadProductos = entity.getCantidadProductos(); 
        this.numeroFacturaDeVenta = entity.getNumeroFacturaDeVenta(); 
        }
    }

    /**
     * @return El ID de la cuenta
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return valor a pagar
     */
    public Double getValorAPagar() {
        return valorAPagar;
    }

    /**
     * @param pValorAPagar nuevo valor para asignar
     */
    public void setValorAPagar(Double pValorAPagar) {
        valorAPagar = pValorAPagar;
    }

    /**
     * Convierte este objeto DTO a una entidad
     *
     * @return Un nuevo entity con los valores del DTO
     */
    public CuentaCobroEntity toEntity() {
        CuentaCobroEntity entidad = new CuentaCobroEntity();
        entidad.setId(this.id);
        entidad.setValorAPagar(this.valorAPagar);
        entidad.setNumeroFacturaDeVenta(this.numeroFacturaDeVenta);
        entidad.setCantidadProductos(this.cantidadProductos);
        return entidad;
    }

    /**
     * @return the cantidadProductos
     */
    public Integer getCantidadProductos() {
        return cantidadProductos;
    }

    /**
     * @param cantidadProductos the cantidadProductos to set
     */
    public void setCantidadProductos(Integer cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    /**
     * @return the numeroFacturaDeVenta
     */
    public Integer getNumeroFacturaDeVenta() {
        return numeroFacturaDeVenta;
    }

    /**
     * @param numeroFacturaDeVenta the numeroFacturaDeVenta to set
     */
    public void setNumeroFacturaDeVenta(Integer numeroFacturaDeVenta) {
        this.numeroFacturaDeVenta = numeroFacturaDeVenta;
    }

}
