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
@Table(name = "CUENTACOBROENTITY")
public class CuentaCobroEntity implements Serializable {
    
    private Double valorAPagar;
  
    @PodamExclude
    @OneToOne
    private PagoEntity pago;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
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
