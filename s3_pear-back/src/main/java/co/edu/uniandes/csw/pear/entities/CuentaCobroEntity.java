/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.*;

import uk.co.jemos.podam.common.PodamExclude;
/**
 * 
 *
 * @author jp.campos
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class CuentaCobroEntity extends BaseEntity implements Serializable {
    
    private Double valorAPagar;
  
    @PodamExclude
    @OneToOne
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
    
    
}
