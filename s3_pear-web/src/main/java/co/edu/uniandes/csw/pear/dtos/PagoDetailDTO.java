/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.PagoEntity;

/**
 * Clase que extiende de {@link PagoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de el pago vaya a la documentacion de {@link PagoDTO}
 * @author jp.campos
 * 
 * El formato JSON de este objeto es el siguiente:
  {
  "montoIncial": 0.1,
   "montoFinal" : 0.1, 
   "medioPago" :{
                "medioPagoActual": "baloto"
       }
  }
 */
public class PagoDetailDTO extends PagoDTO{
    
     private MedioPagoDTO medioPago;   
    
     /**
     * Constructor por defecto
     */
    public PagoDetailDTO() {
        super(); 
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de pago a partir de la cual se construye el objeto
     */
    public PagoDetailDTO(PagoEntity entity) {
        super(entity);
        if(entity != null){
        if(entity.getMedioPagoEntity() != null)
        {
            this.medioPago = new MedioPagoDTO(entity.getMedioPagoEntity()); 
        }else 
        {
            this.medioPago = null;
        }
       }
    }
    
    /**
    * 
    * @return medioPago
    */
   public MedioPagoDTO getMedioPago()
   {
       return medioPago; 
   }
   
   /**
    * Cambia el medio de pago
    * @param pMedioPago 
    */
   public void setMedioPago(MedioPagoDTO pMedioPago)
   {
       medioPago = pMedioPago; 
   }

    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public PagoEntity toEntity() {
        PagoEntity entity = super.toEntity();
       
        if(this.getMedioPago() != null)
        {
            entity.setMedioPagoEntity(getMedioPago().toEntity());
        }
        
        return entity;
    }

    
    
    
    
}
