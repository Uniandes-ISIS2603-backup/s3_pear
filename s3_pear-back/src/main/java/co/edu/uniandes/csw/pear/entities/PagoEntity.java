/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jp.campos
 */
@Entity
public class PagoEntity extends BaseEntity implements Serializable{
    
   
    private double montoInicial; 
    private double montoFinal;
    
    @PodamExclude
    @OneToOne
    private MedioPagoEntity medioPago;
   
    /**
     * @return montoInicial
     */
    public double getMontoInicial(){
        return montoInicial;
    }
    /**
     * Cambia el monto inicial
     * @param pMonto 
     */
    public void setMontoInicial(double pMonto)
    {
        montoInicial = pMonto; 
    }
    
    /**
     * 
     * @return montoFinal
     */
    public double getMontoFinal()
    {
        return montoFinal; 
    }
    
    /**
     * Cambia el monto final
     * @param pMonto 
     */
    public void setMontoFinal(double pMonto)
    {
        montoFinal = pMonto;
    }
    
    
    /**
     * 
     * @return medioPago
     */
    public MedioPagoEntity getMedioPagoEntity(){
        return medioPago; 
    }
    
    /**
     * Cambia el medio de pago
     * @param pMedio 
     */
    public void setMedioPagoEntity(MedioPagoEntity pMedio)
    {
        medioPago = pMedio; 
    }
    
}
