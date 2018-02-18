/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author jp.campos
 */
@Entity
public class MedioPagoEntity extends BaseEntity implements Serializable{
    
    
    private String medioActual; 
    
    private List<PersonaEntity> personas; 
    
    /**
     * Da el medio de pago actual
     * @return medioActual 
     */
    public String getMedioActual()
    {
        return medioActual; 
    }
    
    /**
     * Cambia el medio de pago actual
     * @param pMedio 
     */
    public void setMedioActual(String pMedio) 
    {
        medioActual = pMedio;
    }

    /**
     * @return Las personas con el medio de pago
     */
    public List<PersonaEntity> getPersonas() {
        return personas;
    }
    /**
     * Cambia la lista de peronas que usan el medio de pago actual
     * @param pPersonas 
     */
    public void setPersonas(List<PersonaEntity> pPersonas)
    {
        personas = pPersonas; 
    }
    
}
