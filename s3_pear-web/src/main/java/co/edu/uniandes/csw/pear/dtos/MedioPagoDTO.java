/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.MedioPagoEntity; 

/**
 * DietaTipoDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
 * {
 *  "medioPagoActual ": String
 * }
 * @author jp.campos
 */
public class MedioPagoDTO {
    
   //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    
    public final static String CREDITO  = "Crédito";  
    
    public final static String DEBITO = "Débito"; 
    
    public final static String EFECTIVO = "Efectivo";
    
    public final static String BALOTO = "Baloto";
    
    private String medioPagoActual;
    
    
    private Long id; 
    public MedioPagoDTO()
    {
        
    }
    
    
    public MedioPagoDTO(MedioPagoEntity entity)
    {
        medioPagoActual = entity.getMedioActual(); 
    }
    
    /**
     * Retorna el medio de pago actual
     * @return 
     */
    public String getMedioPagoActual()
    {
        return medioPagoActual;
    }
    
    /**
     * Cambia el metodo de pago actual
     * @param pMedio 
     */
    public void setMedioActual(String pMedio)
    {
        medioPagoActual = pMedio;
    }
    
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
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    public MedioPagoEntity toEntity(){
        MedioPagoEntity entidad = new MedioPagoEntity();
  
        entidad.setId(this.id);
        entidad.setMedioActual(this.medioPagoActual);
        
        return entidad;
    }
    
}
