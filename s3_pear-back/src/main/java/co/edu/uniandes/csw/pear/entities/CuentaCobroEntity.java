/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
/**
 * 
 *
 * @author jp.campos
 */
@Entity
public class CuentaCobroEntity extends BaseEntity implements Serializable {
    
    private double valorAPagar;
    
    @OneToOne
    private PagoEntity pago; 
    
  
    
    
    
     /**
     * Devuelve el valor a pagar
     * @return valorAPagar
     */
    public double getValorAPagar() {
        return valorAPagar;
    }

    /**
     * Cambia el valor a pagar
     * @param pValor 
     */
    public void setValorAPagar(double pValor) {
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
