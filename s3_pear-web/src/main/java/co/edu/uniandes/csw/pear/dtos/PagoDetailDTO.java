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
 */
public class PagoDetailDTO extends PagoDTO{
    
     private MedioPagoDTO medioPago;   
    
     /**
     * Constructor por defecto
     */
    public PagoDetailDTO() {
        
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
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de pago a partir de la cual se construye el objeto
     */
    public PagoDetailDTO(PagoEntity entity) {
        super(entity);
        if(entity.getMedioPagoEntity() != null)
        {
            this.medioPago = new MedioPagoDTO(entity.getMedioPagoEntity()); 
        }
        
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public PagoEntity toEntity() {
        PagoEntity entity = super.toEntity();
       
        if(this.medioPago != null)
        {
            entity.setMedioPagoEntity(medioPago.toEntity());
        }
        
        return entity;
    }

    
    
    
    
}
