/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
import co.edu.uniandes.csw.pear.entities.PagoEntity; 
/**
 * CuentaCobroDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
  {
  "montoIncial": 0.1,
   "montoFinal" : 0.1, 
   "medioPago" :{
                "medioPagoActual": "baloto"
       }
  }
 * @author jp.campos
 */
public class PagoDTO {
    
    
    private double montoInicial; 
    private double montoFinal; 
    private Long id; 
 
    
    /**
     * Contructor por defecto
     */
    public PagoDTO() {
    
    }
    
    public PagoDTO(PagoEntity entity){
        
        if(entity !=null)
        {
        montoInicial = entity.getMontoInicial(); 
        montoFinal = entity.getMontoFinal(); 
        }
    }
    
        /**
     * @return El ID del pago
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
     * @return montoIncial
     */
    public double getMontoIncial()
    {
        return montoInicial;
    }
    
    /**
     * Cambia el monto inicial
     * @param pMonto 
     */
    public void setMontoIncial(double pMonto)
    {
        montoInicial = pMonto; 
    }
    
    /**
     * 
     * @return Monto Final
     */
   public double getMontoFinal(){
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
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    public PagoEntity toEntity(){
        PagoEntity entidad = new PagoEntity();
        entidad.setId(this.id);
        entidad.setMontoFinal(this.montoFinal);
        entidad.setMontoInicial(this.montoInicial);
        
        return entidad;
    }
   
}
