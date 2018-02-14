/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;


import co.edu.uniandes.csw.pear.entities.FacturaEntity;
/**
 *
 * @author v.chacon
 */
public class FacturaDetailDTO extends FacturaDTO{
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
 
    private CuentaCobroDTO cuenta;
    
    private PersonaDTO persona;
     
    private SemanaDTO semana;
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor de la clase FacturaDetailDTO
     * @param entity entidad a partir de la cual se construira el dto
     */
    public FacturaDetailDTO(FacturaEntity entity){
        super(entity);
    }   
    
    /**
     * Constructor de la aplicación
     */
    public FacturaDetailDTO(){
        super();
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
    public void setCuentaDeCobro(CuentaCobroDTO pCuenta){
        cuenta  = pCuenta;
    }
    
    /**
     * @return costo total de la transaccion
     */
    public CuentaCobroDTO geCuentaDeCobro(){
        return cuenta;
    }
    
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
}
