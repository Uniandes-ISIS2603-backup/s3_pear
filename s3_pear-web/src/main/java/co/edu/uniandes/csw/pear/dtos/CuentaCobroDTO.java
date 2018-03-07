/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity; 
import co.edu.uniandes.csw.pear.entities.PagoEntity; 
/**
 * CuentaCobroDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
 * {
 *  "valorAPagar": 15.0,
 *  "id": 7,
 * "pago" : {
 *              "montoInicial":7.0
 *              "montoFinal": 8.0
 * }
 * }
 * @author jp.campos
 */
public class CuentaCobroDTO {
        
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private Double valorAPagar;
    
    private Long id; 
    
    /**
     * Contructor por defecto
     */
    public CuentaCobroDTO()
    {
        
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public CuentaCobroDTO(CuentaCobroEntity entity) {
        
        if(entity != null)
        {
        this.valorAPagar =  entity.getValorAPagar();
        this.id = entity.getId();
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
     * @return valor a pagar
     */    
    public double  getValorAPagar(){
        return valorAPagar;
    }
    
    /**
     * @param pValorAPagar nuevo valor para asignar
     */
    public void setValorAPagar(Double pValorAPagar){
        valorAPagar = pValorAPagar;
    }
    
 
    
      /**
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    public CuentaCobroEntity toEntity(){
        CuentaCobroEntity entidad = new CuentaCobroEntity();
        entidad.setId(this.id);
        
        PagoEntity pagoEntity = new PagoEntity();
        
      
        
        entidad.setPagoEntity(pagoEntity);
        entidad.setValorAPagar(this.valorAPagar);
        return entidad;
    }
    
}
