/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;
import java.io.Serializable;
import javax.persistence.Entity;



/**
 *
 * @author jp.campos
 */
@Entity
public class MedioPagoEntity extends BaseEntity implements Serializable{
    
    
   private String medioPagoActual; 
   
    
    /**
     * Da el medio de pago actual
     * @return medioActual 
     */
    public String getMedioPagoActual()
    {
        return medioPagoActual; 
    }
    
    /**
     * Cambia el medio de pago actual
     * @param pMedio 
     */
    public void setMedioPagoActual(String pMedio) 
    {
        medioPagoActual = pMedio;
    }

 
    
}
