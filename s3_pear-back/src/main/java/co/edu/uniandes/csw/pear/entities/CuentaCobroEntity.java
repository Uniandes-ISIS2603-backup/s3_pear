/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.*;

import uk.co.jemos.podam.common.PodamExclude;
/**
 * @author jp.campos
 */
@Entity
public class CuentaCobroEntity extends BaseEntity implements Serializable {
    
    
    
    
    @PodamExclude
    @OneToOne
    private DietaTipoEntity dieta;
    
    
    private Double valorAPagar;
    
    
    private Integer cantidadProductos;
    
    private Integer numeroFacturaDeVenta;
  
    @PodamExclude
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private PagoEntity pago;
    
    
     /**
     * Devuelve el valor a pagar
     * @return valorAPagar
     */
    public Double getValorAPagar() {
        return valorAPagar;
    }

    /**
     * Cambia el valor a pagar
     * @param pValor 
     */
    public void setValorAPagar(Double pValor) {
        this.valorAPagar = pValor;
    }
    
    /**
     * 
     * @return Pago
     */
    public PagoEntity getPagoEntity()
    {
        return pago; 
    }
    
    /**
     * Cambia el pago actual
     * @param pPago
     */
    public void  setPagoEntity (PagoEntity pPago)
    {
        pago = pPago;
    }

    /**
     * @return the dieta
     */
    public DietaTipoEntity getDieta() {
        return dieta;
    }

    /**
     * @param dieta the dieta to set
     */
    public void setDieta(DietaTipoEntity dieta) {
        this.dieta = dieta;
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
