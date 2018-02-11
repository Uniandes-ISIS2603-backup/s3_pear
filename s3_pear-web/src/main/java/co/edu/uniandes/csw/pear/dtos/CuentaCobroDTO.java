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
 *  "valorAPagar": double
 *  
 * }
 * @author jp.campos
 */
public class CuentaCobroDTO {
        
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private double valorAPagar;
    
    private PagoDTO pago; 
    
    private Long id; 
    
    /**
     * Contructor por defecto
     */
    public CuentaCobroDTO()
    {
        
    }
    
      /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param entidad: Es la entidad que se va a convertir a DTO
     */
    public CuentaCobroDTO(CuentaCobroEntity entidad)
    {
        this.valorAPagar = entidad.getValorAPagar();
        pago = new PagoDTO(entidad.getPagoEntity());
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
    public void setValorAPagar(double pValorAPagar){
        valorAPagar = pValorAPagar;
    }
    
    /**
     * 
     * @return pagpDTO
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
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    public CuentaCobroEntity toEntity(){
        CuentaCobroEntity entidad = new CuentaCobroEntity();
        entidad.setId(this.id);
        
        PagoEntity pagoEntity = new PagoEntity();
        
        pagoEntity.setMontoFinal(getPago().getMontoFinal());
        pagoEntity.setMontoInicial(getPago().getMontoIncial());
        pagoEntity.setId(getPago().getId());
        
        entidad.setPagoEntity(pagoEntity);
        entidad.setValorAPagar(this.valorAPagar);
        return entidad;
    }
    
}
