/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity; 

/**
 * Clase que extiende de {@link CuentaCobro} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la cuenta de cobro vaya a la documentacion de {@link CuentaCobroDTO}
 * @author jp.campos
 */
public class CuentaCobroDetailDTO extends CuentaCobroDTO {
    
    
    private PagoDTO pago; 
    
       
       
    /**
     * Constructor por defecto
     */   
    public CuentaCobroDetailDTO()
    {
        super();
    }
      /**
     * Constructor de CuentaCobroailDTO
     * @param entidad 
     */
    public CuentaCobroDetailDTO(CuentaCobroEntity entidad) {
        super(entidad);
        if(entidad.getPagoEntity() != null)
        {
            this.pago = new PagoDTO(entidad.getPagoEntity()); 
        }
        else {
            this.pago = null; 
        }
    }
    
    
      /**
     * 
     * @return pagoDTO
     */
    public PagoDTO getPago()
    {
        return pago;
    }
    
    /**
     * Cambia el valor de pago
     * @param pPago 
     */
    public void setPago(PagoDTO pPago)
    {
        pago = pPago;
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public CuentaCobroEntity toEntity() {
        CuentaCobroEntity entidad = super.toEntity();
        
        if(this.getPago() != null)
        {
            entidad.setPagoEntity(getPago().toEntity());
        }
        
        return entidad;
    }

}
