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
 *  
 * El formato JSON de este objeto es el siguiente:
  {
   "valorAPagar": 15.0,
   "id": 1, 
  "pago" : {
               "montoInicial":7.0,
               "montoFinal": 8.0
    },
   "factura": {
   "cantidadDeProductos": 13,
   "numeroFacturaDeVenta": 1,
   
  }
 }
 */
public class CuentaCobroDetailDTO extends CuentaCobroDTO {
    
    
    private PagoDTO pago; 
    
    private FacturaDTO factura;
       
    private DietaTipoDTO dieta;
       
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
        if(entidad != null){
        
      
        //TODO DONE: entity puede ser null
        if(entidad.getPagoEntity() != null)
        {
            this.pago = new PagoDTO(entidad.getPagoEntity()); 
        }
        else {
            this.pago = null; 
        }
        
        if(entidad.getFacturaEntity() != null)
        {
            this.factura = new FacturaDTO(entidad.getFacturaEntity()); 
        }else
        {
            this.factura = null;
        }
        
          if(entidad.getDieta()!= null)
        {
            this.dieta = new DietaTipoDTO(entidad.getDieta()); 
        }else
        {
            this.dieta = null;
        }
        
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
        
        if(this.getFactura() != null)
        {
            entidad.setFacturaEntity(getFactura().toEntity());
        }
        
        if(this.dieta != null)
        {
            entidad.setDieta(getDieta().toEntity());
        }
        
        return entidad;
    }

    /**
     * @return the factura
     */
    public FacturaDTO getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    /**
     * @return the dieta
     */
    public DietaTipoDTO getDieta() {
        return dieta;
    }

    /**
     * @param dieta the dieta to set
     */
    public void setDieta(DietaTipoDTO dieta) {
        this.dieta = dieta;
    }

}
